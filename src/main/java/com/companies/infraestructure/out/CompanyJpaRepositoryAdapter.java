package com.companies.infraestructure.out;

import com.companies.application.out.CompanyRepositoryPort;
import com.companies.domain.Company;
import com.companies.domain.Transfer;
import com.companies.infraestructure.entity.CompanyEntity;
import com.companies.infraestructure.entity.TransferEntity;
import com.companies.infraestructure.repository.CompanyJpaRepository;
import com.companies.infraestructure.repository.TransferJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class CompanyJpaRepositoryAdapter implements CompanyRepositoryPort {

    private final CompanyJpaRepository companyJpaRepository;
    private final TransferJpaRepository transferJpaRepository;

    public CompanyJpaRepositoryAdapter(CompanyJpaRepository companyJpaRepository, TransferJpaRepository transferJpaRepository) {
        this.companyJpaRepository = companyJpaRepository;
        this.transferJpaRepository = transferJpaRepository;
    }

    @Override
    public Company companyAccession(Company company) {
        CompanyEntity companyEntity = CompanyMapper.toEntity(company);
        return CompanyMapper.toDomain(companyJpaRepository.save(companyEntity));
    }

    @Override
    public List<Company> getLastMonthCompaniesAccession() {
        LocalDate minusMonths = LocalDate.now().minusMonths(1);
        List<CompanyEntity> companyEntityList = companyJpaRepository
                .findCompanyEntityByAccessionDateGreaterThanEqual(minusMonths);
        return companyEntityList.stream().map(CompanyMapper::toDomain).toList();
    }

    @Override
    public List<Company> getLastMothCompanyTransfers() {
        LocalDate minusMonths = LocalDate.now().minusMonths(1);
        List<TransferEntity> transferEntityList = transferJpaRepository
                .findTransferEntityByTransferDateGreaterThanEqual(minusMonths);
        Set<Company> companySet = new HashSet<>();

        if (!transferEntityList.isEmpty()) {
            transferEntityList.forEach(transferEntity -> {
                CompanyEntity companyEntity = transferEntity.getCompany();
                companySet.add(CompanyMapper.toDomain(companyEntity));
            });
        }
        return companySet.stream().toList();
    }

    @Override
    public Transfer transfer(Transfer transfer) {
        CompanyEntity companyEntity = companyJpaRepository.findById(transfer.getCompanyId())
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
        TransferEntity transferEntity = TransferMapper.toEntity(transfer, companyEntity);
        TransferEntity savedTransfer = transferJpaRepository.save(transferEntity);
        return TransferMapper.toDomain(savedTransfer);
    }
}

package com.companies.application;

import com.companies.application.in.CompanyService;
import com.companies.application.out.CompanyRepositoryPort;
import com.companies.domain.Company;
import com.companies.domain.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepositoryPort companyRepositoryPort;

    public CompanyServiceImpl(CompanyRepositoryPort companyRepositoryPort) {
        this.companyRepositoryPort = companyRepositoryPort;
    }

    @Override
    public Company companyAccession(Company company) {
        return companyRepositoryPort.companyAccession(company);
    }

    @Override
    public List<Company> getLastMonthCompaniesAccession() {
        return companyRepositoryPort.getLastMonthCompaniesAccession();
    }

    @Override
    public List<Company> getLastMothCompanyTransfers() {
        return companyRepositoryPort.getLastMothCompanyTransfers();
    }

    @Override
    public Transfer transfer(Transfer transfer) {
        return companyRepositoryPort.transfer(transfer);
    }
}

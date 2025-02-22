package com.companies.application.out;

import com.companies.domain.Company;
import com.companies.domain.Transfer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyRepositoryPort {
    Company companyAccession(Company company);
    List<Company> getLastMonthCompaniesAccession();
    List<Company> getLastMothCompanyTransfers();
    Transfer transfer(Transfer transfer);

}

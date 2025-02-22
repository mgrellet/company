package com.companies.application.in;

import com.companies.domain.Company;
import com.companies.domain.Transfer;

import java.util.List;

public interface CompanyService {
    Company companyAccession(Company company);
    List<Company> getLastMonthCompaniesAccession();
    List<Company> getLastMothCompanyTransfers();
    Transfer transfer(Transfer transfer);
}

package com.companies.infraestructure.out;

import com.companies.domain.Company;
import com.companies.infraestructure.entity.CompanyEntity;

public class CompanyMapper {

    public static CompanyEntity toEntity(Company company) {
        return CompanyEntity.builder()
                .id(company.getId())
                .cuit(company.getCuit())
                .companyName(company.getCompanyName())
                .accessionDate(company.getAccessionDate())
                .build();
    }

    public static Company toDomain(CompanyEntity companyEntity) {
        return Company.builder()
                .id(companyEntity.getId())
                .cuit(companyEntity.getCuit())
                .companyName(companyEntity.getCompanyName())
                .accessionDate(companyEntity.getAccessionDate())
                .build();
    }
}

package com.companies.infraestructure.repository;

import com.companies.domain.Company;
import com.companies.infraestructure.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Long> {
    List<CompanyEntity> findCompanyEntityByAccessionDateGreaterThanEqual(LocalDate minusMonths);
}

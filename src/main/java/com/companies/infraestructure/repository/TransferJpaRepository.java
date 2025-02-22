package com.companies.infraestructure.repository;

import com.companies.infraestructure.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferJpaRepository extends JpaRepository<TransferEntity, Long> {
    List<TransferEntity> findTransferEntityByTransferDateGreaterThanEqual(LocalDate minusMonths);
}

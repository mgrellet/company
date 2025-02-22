package com.companies.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transfers")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "cuit", nullable = false)
    private CompanyEntity company;
    private String debitAccount;
    private String creditAccount;
    private LocalDate transferDate;
}

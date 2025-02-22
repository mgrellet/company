package com.companies.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode
public class Company {
    Long id;
    String cuit;
    String companyName;
    LocalDate accessionDate;
}

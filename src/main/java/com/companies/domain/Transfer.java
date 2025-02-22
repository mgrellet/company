package com.companies.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class Transfer {
    BigDecimal amount;
    Long companyId;
    String debitAccount;
    String creditAccount;
    LocalDate transferDate;
}

package com.companies.infraestructure.out;

import com.companies.domain.Transfer;
import com.companies.infraestructure.entity.CompanyEntity;
import com.companies.infraestructure.entity.TransferEntity;

public class TransferMapper {
    public static TransferEntity toEntity(Transfer transfer, CompanyEntity companyEntity) {
        return TransferEntity.builder()
                .amount(transfer.getAmount())
                .company(companyEntity)
                .debitAccount(transfer.getDebitAccount())
                .creditAccount(transfer.getCreditAccount())
                .transferDate(transfer.getTransferDate())
                .build();

    }


    public static Transfer toDomain(TransferEntity savedTransfer) {
        return Transfer.builder()
                .amount(savedTransfer.getAmount())
                .companyId(savedTransfer.getCompany().getId())
                .debitAccount(savedTransfer.getDebitAccount())
                .creditAccount(savedTransfer.getCreditAccount())
                .transferDate(savedTransfer.getTransferDate())
                .build();
    }
}

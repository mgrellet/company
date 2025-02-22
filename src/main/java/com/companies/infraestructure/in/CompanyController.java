package com.companies.infraestructure.in;

import com.companies.application.in.CompanyService;
import com.companies.domain.Company;
import com.companies.domain.Transfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> companyAccession(@RequestBody Company company) {
        Company savedCompany = companyService.companyAccession(company);
        return ResponseEntity.ok(savedCompany);
    }

    @GetMapping("/accession-last-month")
    public ResponseEntity<List<Company>> getLastMonthCompaniesAccession() {
        List<Company> companies = companyService.getLastMonthCompaniesAccession();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/transfer-last-month")
    public ResponseEntity<List<Company>> getLastMothCompanyTransfer() {
        List<Company> companies = companyService.getLastMothCompanyTransfers();
        return ResponseEntity.ok(companies);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transferCompany(@RequestBody Transfer transfer) {
        return ResponseEntity.ok(companyService.transfer(transfer));
    }
}

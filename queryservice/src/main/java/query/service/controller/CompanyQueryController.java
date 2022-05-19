package query.service.controller;

import command.service.bean.CompanyCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import query.service.service.CompanyQueryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyQueryController {
    @Autowired
    private CompanyQueryService companyQueryService;

    @GetMapping(path="/getall")
    public @ResponseBody List<CompanyCreation> getAllcompanyDetails() {
        return companyQueryService.getAllCompanies();
    }

    @GetMapping(path="/info/{id}")
    public @ResponseBody
    Optional<CompanyCreation> getSingleCompanyDetails(@PathVariable int companyCode) {
        return companyQueryService.getSingleCompanybyCompanyId(companyCode);
    }

}

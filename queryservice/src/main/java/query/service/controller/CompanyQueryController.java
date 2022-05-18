package query.service.controller;

import query.service.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import query.service.service.CompanyQueryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/company")
public class CompanyQueryController {
    @Autowired
    private CompanyQueryService companyQueryService;

    @GetMapping(path="/getall")
    public @ResponseBody List<Company> getAllcompanyDetails() {
        return companyQueryService.getAllCompanies();
    }

    @GetMapping(path="/info/{id}")
    public @ResponseBody
    Optional<Company> getSingleCompanyDetails(@PathVariable int companyCode) {
        return companyQueryService.getSingleCompanybyCompanyId(companyCode);
    }

}

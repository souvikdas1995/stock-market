package query.service.controller;

import query.service.bean.CompanyQuery;
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
    public @ResponseBody List<CompanyQuery> getAllcompanyDetails() {
        return companyQueryService.getAllCompanies();
    }

    @GetMapping(path="/info/{id}")
    public @ResponseBody
    Optional<CompanyQuery> getSingleCompanyDetails(@PathVariable int companyCode) {
        return companyQueryService.getSingleCompanybyCompanyId(companyCode);
    }

}

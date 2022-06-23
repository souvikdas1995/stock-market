package query.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import query.service.bean.CompanyQuery;
import query.service.repository.CompanyQueryRepository;
import query.service.service.CompanyQueryService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/query/company")
public class CompanyQueryController {
    @Autowired
    private CompanyQueryService companyQueryService;

    @Autowired
    private CompanyQueryRepository companyQueryRepository;

    @GetMapping(path="/getall")
    public @ResponseBody ResponseEntity<List<CompanyQuery>> getAllcompanyDetails() {

        return new ResponseEntity<>(companyQueryService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping(path="/info/{companyCode}")
    public @ResponseBody ResponseEntity<CompanyQuery> getSingleCompanyDetails(@PathVariable Long companyCode) {
        Optional<CompanyQuery> singleCompanybyCompanyId = companyQueryService.getSingleCompanybyCompanyId(companyCode);
        if(!singleCompanybyCompanyId.isPresent())
            return  ResponseEntity.noContent().build();
        return new ResponseEntity<>(singleCompanybyCompanyId.get(), HttpStatus.OK);



    }


}

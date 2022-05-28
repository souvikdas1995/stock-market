package query.service.controller;

<<<<<<< HEAD
import query.service.bean.Company;
=======
import command.service.bean.CompanyCreation;
>>>>>>> branch 'marketdev' of https://github.com/souvikdas1995/stock-market.git
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
<<<<<<< HEAD
    public @ResponseBody List<Company> getAllcompanyDetails() {
        return companyQueryService.getAllCompanies();
=======
    public @ResponseBody ResponseEntity<List<CompanyCreation>> getAllcompanyDetails() {

        return new ResponseEntity<>(companyQueryService.getAllCompanies(), HttpStatus.OK);
>>>>>>> branch 'marketdev' of https://github.com/souvikdas1995/stock-market.git
    }

    @GetMapping(path="/info/{id}")
<<<<<<< HEAD
    public @ResponseBody
    Optional<Company> getSingleCompanyDetails(@PathVariable int companyCode) {
        return companyQueryService.getSingleCompanybyCompanyId(companyCode);
=======
    public @ResponseBody ResponseEntity<CompanyCreation> getSingleCompanyDetails(@PathVariable int companyCode) throws  Exception {
        return new ResponseEntity<>(companyQueryService.getSingleCompanybyCompanyId(companyCode), HttpStatus.OK);
>>>>>>> branch 'marketdev' of https://github.com/souvikdas1995/stock-market.git
    }

}

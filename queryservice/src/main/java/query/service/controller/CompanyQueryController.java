package query.service.controller;

import com.google.gson.Gson;
import command.service.bean.CompanyCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import query.service.bean.CompanyQuery;
import query.service.repository.CompanyQueryRepository;
import query.service.service.CompanyQueryService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/company")
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
    public @ResponseBody ResponseEntity<CompanyQuery> getSingleCompanyDetails(@PathVariable int companyCode) {
        Optional<CompanyQuery> singleCompanybyCompanyId = companyQueryService.getSingleCompanybyCompanyId(companyCode);
        if(!singleCompanybyCompanyId.isPresent())
            return  ResponseEntity.noContent().build();
        return new ResponseEntity<>(singleCompanybyCompanyId.get(), HttpStatus.OK);



    }

    @PostMapping("/add")
    public ResponseEntity<CompanyQuery> createCompany(@Valid @RequestBody CompanyQuery company) {

        CompanyQuery savedCompany = companyQueryService.createCompany(company);

        return new ResponseEntity<>(savedCompany,HttpStatus.CREATED);
    }

    @PutMapping("/{companyCode}")
    public ResponseEntity<CompanyQuery> updateCompany(@Valid @RequestBody CompanyQuery company, @PathVariable int  companyCode) {
        CompanyQuery companyQuery = companyQueryService.updateCompany(company, companyCode);
        if(null==companyQuery)
            return ResponseEntity.unprocessableEntity().build();
        else
            return new ResponseEntity<>(companyQuery,HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{companyCode}", produces = "application/json")
    public ResponseEntity<?> deleteCompany(@PathVariable int  companyCode) {
        boolean isDeleted = companyQueryService.deleteCompany(companyCode);
        if(!isDeleted)
            return ResponseEntity.unprocessableEntity().build();
        else
            return ResponseEntity.noContent().build();

    }

}

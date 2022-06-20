package command.service.controller;


import command.service.bean.CompanyCreation;
import command.service.repository.CompanyCommandRepository;
import command.service.service.CompanyCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/company")
public class CompanyCommandController {
    @Autowired
    private CompanyCommandService companyQueryService;

    @Autowired
    private CompanyCommandRepository companyQueryRepository;

//    @GetMapping(path="/getall")
//    public @ResponseBody ResponseEntity<List<CompanyCreation>> getAllcompanyDetails() {
//        List<CompanyCreation> companyCreations =new ArrayList<>();
//        companyQueryRepository.findAll().forEach( e-> companyCreations.add(e) );
//        return new ResponseEntity<>(companyCreations, HttpStatus.OK);
//    }

    public Optional<CompanyCreation> getSingleCompanybyCompanyId(Long companyCode){
        Optional<CompanyCreation> companyQueryOptional=companyQueryRepository.findById(companyCode);
        return companyQueryOptional;
    }

//    @GetMapping(path="/info/{companyCode}")
//    public @ResponseBody ResponseEntity<CompanyCreation> getSingleCompanyDetails(@PathVariable Long companyCode) {
//        Optional<CompanyCreation> singleCompanybyCompanyId = this.getSingleCompanybyCompanyId(companyCode);
//        if(!singleCompanybyCompanyId.isPresent())
//            return  ResponseEntity.noContent().build();
//        return new ResponseEntity<>(singleCompanybyCompanyId.get(), HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<CompanyCreation> createCompany(@Valid @RequestBody CompanyCreation company) {

        CompanyCreation savedCompany = companyQueryService.createCompany(company);

        return new ResponseEntity<>(savedCompany,HttpStatus.CREATED);
    }

    @PutMapping("/{companyCode}")
    public ResponseEntity<CompanyCreation> updateCompany(@Valid @RequestBody CompanyCreation company, @PathVariable Long  companyCode) {
        CompanyCreation companyQuery = companyQueryService.updateCompany(company, companyCode);
        if(null==companyQuery)
            return ResponseEntity.unprocessableEntity().build();
        else
            return new ResponseEntity<>(companyQuery,HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{companyCode}", produces = "application/json")
    public ResponseEntity<?> deleteCompany(@PathVariable Long  companyCode) {
        boolean isDeleted = companyQueryService.deleteCompany(companyCode);
        if(!isDeleted)
            return ResponseEntity.unprocessableEntity().build();
        else
            return ResponseEntity.noContent().build();

    }

}

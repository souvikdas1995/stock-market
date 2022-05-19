package command.service.controller;


import command.service.bean.CompanyCreation;
import command.service.service.CompanyCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyCommandController<T> {

    @Autowired
    CompanyCommandService companyService;

    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestBody CompanyCreation company) {

        companyService.addCompany(company);
        return new ResponseEntity<>("Company Added Successfully", HttpStatus.OK);
    }
}
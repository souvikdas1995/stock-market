package com.cts.fse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fse.entity.Company;
import com.cts.fse.service.CompanyService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController<T> {
	
	@Autowired
	CompanyService companyService;

	@PostMapping("/add")
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
		
		companyService.addCompany(company);
		return new ResponseEntity<>("Company Added Successfully", HttpStatus.OK);
	}
}

package com.cts.fse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fse.entity.Company;
import com.cts.fse.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;

	public void addCompany(Company company) {
		companyRepository.save(company);
	}
}

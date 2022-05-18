package com.cts.fse.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fse.entity.Company;
import com.cts.fse.entity.Stock;
import com.cts.fse.repository.CompanyRepository;
import com.cts.fse.service.StockService;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

	@Autowired
	StockService stockService;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@PostMapping("/add/{companyId}")
	public ResponseEntity<String> addStock(@PathVariable() int companyId, @RequestBody Stock stock) {
		Optional<Company> findById = companyRepository.findById(companyId);
		stock.setCompanyQuery(findById.get());
		stockService.addStock(stock);
		return new ResponseEntity<>("Stock added successfully", HttpStatus.OK);
	}
}

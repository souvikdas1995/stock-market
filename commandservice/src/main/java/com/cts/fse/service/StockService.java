package com.cts.fse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fse.entity.Stock;
import com.cts.fse.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;
	
	public void addStock(Stock stock) {
		stockRepository.save(stock);
	}
}

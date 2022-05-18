package query.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import query.service.bean.Stock;
import query.service.repository.StockRepository;
import query.service.service.StockService;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {
	
	@Autowired
	StockService serviceStockService;

	@GetMapping("/getall")
	public ResponseEntity<List<Stock>> getAllStocks(){
		List<Stock> allStocks = serviceStockService.getAllStocks();
		return new ResponseEntity<List<Stock>>(allStocks, HttpStatus.OK);
	}
}

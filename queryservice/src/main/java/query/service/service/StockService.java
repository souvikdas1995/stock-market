package query.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import query.service.bean.Company;
import query.service.bean.Stock;
import query.service.repository.CompanyRepository;
import query.service.repository.StockRepository;

@Service
public class StockService {

	@Autowired
    StockRepository stockRepository;

    public List<Stock> getAllStocks()
    {
        List<Stock> stocks = new ArrayList<Stock>();
        stockRepository.findAll().forEach(stock -> stocks.add(stock));
        return stocks;
    }
}

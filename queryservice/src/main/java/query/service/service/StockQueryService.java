package query.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import query.service.bean.CompanyQuery;
import query.service.bean.StockQuery;
import query.service.repository.CompanyQueryRepository;
import query.service.repository.StockQueryRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockQueryService {

    @Autowired
    StockQueryRepository stockQueryRepository;

    @Autowired
    CompanyQueryRepository companyQueryRepository;

    public List<StockQuery> getAllStocks()
    {
        List<StockQuery> stocks = new ArrayList<>();
        stockQueryRepository.findAll().forEach(stock -> stocks.add(stock));
        return stocks;
    }

    public Optional<StockQuery> getSingleStockbyId(Long stockId) throws Exception{
        return stockQueryRepository.findByStockCode(stockId);
    }

    public List<StockQuery> findAllStocksBetweenDates(Long companyCode, Date startDate, Date endDate){
        Optional<CompanyQuery> companyQueryOptional = companyQueryRepository.findById(companyCode);
        if(!companyQueryOptional.isPresent())
            return  null;
        List<StockQuery> stocks = companyQueryOptional.get().getStocks();
        List<StockQuery> collect = stocks
                .stream()
                .filter(stock -> stock.getCreatedOn().after(startDate) && stock.getCreatedOn().before(endDate))
                .collect(Collectors.toList());
            return collect;
    }
}

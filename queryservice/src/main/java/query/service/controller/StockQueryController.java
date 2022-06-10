package query.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import query.service.bean.StockQuery;
import query.service.repository.StockQueryRepository;
import query.service.service.CompanyQueryService;
import query.service.service.StockQueryService;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
@RequestMapping("/api/v1/stock")
public class StockQueryController {

    @Autowired
    private StockQueryService stockQueryService;

    @Autowired
    private StockQueryRepository stockQueryRepository;

    @Autowired
    CompanyQueryService companyQueryService;

    @GetMapping(path = "/getall")
    public @ResponseBody
    ResponseEntity<List<StockQuery>> getAllStocks() {

        return new ResponseEntity<>( stockQueryService.getAllStocks(), HttpStatus.OK);
    }

    @GetMapping(path = "/info/{stockCode}")
    public ResponseEntity<StockQuery> getSingleStockDetails(@PathVariable Long stockCode) throws Exception{
        Optional<StockQuery> singleStockbyId = stockQueryService.getSingleStockbyId(stockCode);
        if(!singleStockbyId.isPresent())
            return  ResponseEntity.noContent().build();
        return new ResponseEntity<>(singleStockbyId.get(), HttpStatus.FOUND);

    }
}
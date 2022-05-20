package query.service.controller;

import command.service.bean.CompanyCreation;
import command.service.bean.StockCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import query.service.service.CompanyQueryService;
import query.service.service.StockQueryService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/stock")
public class StockQueryController {

    @Autowired
    private StockQueryService stockQueryService;

    @GetMapping(path = "/getall")
    public @ResponseBody
    List<StockCreation> getAllStocks() {
        return stockQueryService.getAllStocks();
    }

    @GetMapping(path = "/info/{id}")
    public @ResponseBody
    Optional<StockCreation> getSingleStockDetails(@PathVariable int stockCode) {
        return stockQueryService.getSingleStockbyId(stockCode);
    }

}
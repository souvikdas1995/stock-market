package query.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import query.service.bean.StockQuery;
import query.service.repository.StockQueryRepository;
import query.service.service.CompanyQueryService;
import query.service.service.StockQueryService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/stock")
public class StockQueryController {

    @Autowired
    private StockQueryService stockQueryService;

    @Autowired
    private StockQueryRepository stockQueryRepository;

    @Autowired
    CompanyQueryService companyQueryService;

    @GetMapping(path = "/getall")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public @ResponseBody
    ResponseEntity<List<StockQuery>> getAllStocks() {

        return new ResponseEntity<>( stockQueryService.getAllStocks(), HttpStatus.OK);
    }

    @GetMapping(path = "/info/{stockCode}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<StockQuery> getSingleStockDetails(@PathVariable Long stockCode) throws Exception{
        Optional<StockQuery> singleStockbyId = stockQueryService.getSingleStockbyId(stockCode);
        if(!singleStockbyId.isPresent())
            return  ResponseEntity.noContent().build();
        return new ResponseEntity<>(singleStockbyId.get(), HttpStatus.FOUND);

    }

    @GetMapping("/get/{companyCode}/{startDate}/{endDate}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<StockQuery>> findAllStocksBetweenDates(@PathVariable(value = "companyCode") Long companyCode, @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                      @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return new ResponseEntity<>(stockQueryService.findAllStocksBetweenDates(companyCode, startDate, endDate),HttpStatus.OK);
    }
}
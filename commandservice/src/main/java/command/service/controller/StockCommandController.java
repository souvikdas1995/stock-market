package command.service.controller;

import command.service.bean.StockCreation;
import command.service.repository.StockCommandRepository;
import command.service.service.CompanyCommandService;
import command.service.service.StockCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/stock")
public class StockCommandController {

    @Autowired
    private StockCommandService stockQueryService;

    @Autowired
    private StockCommandRepository stockQueryRepository;

    @Autowired
    CompanyCommandService companyQueryService;


    @PostMapping("/add")
    public ResponseEntity<StockCreation> addStock(@RequestBody StockCreation stockQuery){
        StockCreation addStock = stockQueryService.addstock(stockQuery);
        if(null==addStock)
            return ResponseEntity.unprocessableEntity().build();

        return new ResponseEntity<>(stockQuery, HttpStatus.CREATED);
    }

    @PutMapping("/{stockCode}")
    public ResponseEntity<StockCreation> updateStock(@Valid @RequestBody StockCreation stockQuery, @PathVariable Long  stockCode) {
        StockCreation updateStock = stockQueryService.updateStock(stockQuery, stockCode);
        if(null==updateStock)
            return ResponseEntity.unprocessableEntity().build();
        else
            return new ResponseEntity<>(updateStock,HttpStatus.CREATED);
    }

    @DeleteMapping("/{stockCode}")
    public ResponseEntity<String> deleteStock(@PathVariable Long  stockCode) {
        boolean isDeleted = stockQueryService.deleteStock(stockCode);
        if(!isDeleted)
            return new ResponseEntity<>("stock not found with Id", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("stock deleted successfully",HttpStatus.OK);
    }

}

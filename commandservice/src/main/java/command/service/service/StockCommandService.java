package command.service.service;

import command.service.bean.CompanyCreation;
import command.service.bean.StockCreation;
import command.service.repository.CompanyCommandRepository;
import command.service.repository.StockCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockCommandService {

    @Autowired
    StockCommandRepository stockCommandRepository;

    @Autowired
    CompanyCommandRepository companyCommandRepository;

    @Autowired
    MessageProducer messageProducer;

    public StockCreation addstock(StockCreation stockQuery) {
        Optional<CompanyCreation> companyQueryOptional = companyCommandRepository.findById(stockQuery.getCompanyCreation().getCompanyCode());
        if (!companyQueryOptional.isPresent())
            return null;
        stockQuery.setCompanyCreation(companyQueryOptional.get());
        stockCommandRepository.save(stockQuery);

        CompanyCreation companyCreation = companyCommandRepository.findById(stockQuery.getCompanyCreation().getCompanyCode()).get();
        companyCommandRepository.refresh(companyCreation);
        messageProducer.publishMessage(companyCreation);
        return stockQuery;
    }

    public StockCreation updateStock(StockCreation stockQuery, Long stockCode) {
        Optional<CompanyCreation> companyQueryOptional = companyCommandRepository.findById(stockQuery.getCompanyCreation().getCompanyCode());
        if (!companyQueryOptional.isPresent())
            return null;
        Optional<StockCreation> stockQueryOptional = stockCommandRepository.findById(stockCode);
        if (!stockQueryOptional.isPresent())
            return null;

        stockQuery.setCompanyCreation(companyQueryOptional.get());
        stockQuery.setStockCode(stockQueryOptional.get().getStockCode());
        stockCommandRepository.save(stockQuery);

        CompanyCreation companyupdation= companyCommandRepository.findById(stockQuery.getCompanyCreation().getCompanyCode()).get();
        companyCommandRepository.refresh(companyupdation);
        messageProducer.publishMessage(companyupdation);
        return stockQuery;
    }

    public boolean deleteStock(Long stockCode) {
        Optional<StockCreation> stockQueryOptional = stockCommandRepository.findById(stockCode);
        if (!stockQueryOptional.isPresent())
            return false;
        stockCommandRepository.deleteById(stockCode);
        return true;
    }
}
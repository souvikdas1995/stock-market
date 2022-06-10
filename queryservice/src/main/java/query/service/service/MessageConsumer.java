package query.service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import query.service.bean.CompanyQuery;
import query.service.repository.CompanyQueryRepository;
import query.service.repository.StockQueryRepository;

import java.util.Optional;

@Service
@Log4j2
public class MessageConsumer {


    @Autowired
    CompanyQueryService companyQueryService;

    @Autowired
    CompanyQueryRepository companyQueryRepository;

    @Autowired
    StockQueryRepository stockQueryRepository;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @KafkaListener(topics = "stock_market", groupId = "group_id")
    public void consume(String companyMessage) {
        try{
            CompanyQuery receivedcompanyQuery = OBJECT_MAPPER.readValue(companyMessage, CompanyQuery.class);
            Optional<CompanyQuery> singleCompanybyCompanyId = companyQueryService.getSingleCompanybyCompanyId(receivedcompanyQuery.getCompanyCode());
            if(singleCompanybyCompanyId.isPresent())
            {
                CompanyQuery existingCompany = singleCompanybyCompanyId.get();
                existingCompany.setCeo(receivedcompanyQuery.getCeo());
                existingCompany.setCompanyName(receivedcompanyQuery.getCompanyName());
                existingCompany.setDescription(receivedcompanyQuery.getDescription());
                existingCompany.setExchange(receivedcompanyQuery.getExchange());
                existingCompany.setTurnover(receivedcompanyQuery.getTurnover());
                existingCompany.setWebsite(receivedcompanyQuery.getWebsite());
                existingCompany.setStocks(receivedcompanyQuery.getStocks());
                companyQueryRepository.save(existingCompany);
                if(existingCompany.getStocks().size()>0){
                    existingCompany.getStocks().forEach(entity -> stockQueryRepository.save(entity));
                }
            }

            else{
                CompanyQuery newCompany = new CompanyQuery();
                newCompany.setCompanyCode(receivedcompanyQuery.getCompanyCode());
                newCompany.setCeo(receivedcompanyQuery.getCeo());
                newCompany.setCompanyName(receivedcompanyQuery.getCompanyName());
                newCompany.setDescription(receivedcompanyQuery.getDescription());
                newCompany.setExchange(receivedcompanyQuery.getExchange());
                newCompany.setTurnover(receivedcompanyQuery.getTurnover());
                newCompany.setWebsite(receivedcompanyQuery.getWebsite());
                newCompany.setStocks(receivedcompanyQuery.getStocks());
                companyQueryRepository.save(newCompany);
                if(newCompany.getStocks().size()>0){
                    newCompany.getStocks().forEach(entity -> stockQueryRepository.save(entity));
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

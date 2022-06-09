package command.service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import command.service.bean.CompanyCreation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MessageProducer {

    private static final String TOPIC = "stock_market";

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public void publishMessage(CompanyCreation companyCreation){
        try{
            String value = OBJECT_MAPPER.writeValueAsString(companyCreation);
            log.info(String.format("#### -> Producing message -> %s", value));
            this.kafkaTemplate.sendDefault(companyCreation.getCompanyCode(), value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
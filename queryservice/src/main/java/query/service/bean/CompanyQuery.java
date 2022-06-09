package query.service.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
@Data
public class CompanyQuery {
    @Id
    private Long companyCode;

    private String companyName;

    private String description;

    private String ceo;

    private long turnover;

    private String website;

    private String exchange;

    private List<StockQuery> stocks;





}


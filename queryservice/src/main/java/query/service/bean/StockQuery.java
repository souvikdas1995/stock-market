package query.service.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Document
@Data
public class StockQuery {
    @Id
    private Long stockCode;

    private String stockName;

    private String description;

    private double price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdOn;

    private CompanyQuery companyQuery;

}

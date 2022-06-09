package command.service.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "stockcreation")
public class StockCreation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long stockCode;

    private String stockName;

    private String description;

    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdOn;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="companycreation_company_code")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CompanyCreation companyCreation;
}



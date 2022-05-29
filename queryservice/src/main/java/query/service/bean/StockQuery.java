package query.service.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Table(name = "stockquery")
public class StockQuery {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int stockCode;

    private String stockName;

    private String description;

    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdOn;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="companyquery_company_code")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CompanyQuery companyQuery;
}

package command.service.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
public class StockCreation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int stockCode;

    private String stockName;

    private String description;

    private double price;

    @Temporal(TemporalType.DATE)
    private Date createdOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyCode", nullable=true)
    private CompanyCreation companyCreation;
}


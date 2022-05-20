package command.service.bean;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
public class StockCreation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int stockCode;

    private String stockName;

    private String description;

    private double price;

    private Calendar startDate;

    private Calendar endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyCode", nullable=false)
    private CompanyCreation companyCreation;
}


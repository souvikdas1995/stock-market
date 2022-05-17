package bean;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="STOCKQUERY")
public class StockQuery {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int stockCode;

    private String stockName;

    private String description;

    private double price;

    private Calendar startDate;

    private Calendar endDate;

    @ManyToOne
    @JoinColumn(name="companyCode", nullable=false)
    private CompanyQuery companyQuery;
}

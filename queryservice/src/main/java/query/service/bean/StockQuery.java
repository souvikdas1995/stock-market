package query.service.bean;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class StockQuery {

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
    private CompanyQuery companyQuery;
}

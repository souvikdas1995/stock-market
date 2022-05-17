package query.service.bean;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="stockquery")
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
    @JoinColumn(name="companycode", nullable=false)
    private CompanyQuery companyQuery;
}

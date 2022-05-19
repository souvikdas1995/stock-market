package query.service.bean;

import lombok.Data;

import java.util.Calendar;
@Data
public class StockQuery {

    private int stockCode;

    private String stockName;

    private String description;

    private double price;

    private Calendar startDate;

    private Calendar endDate;

    private CompanyQuery companyQuery;
}

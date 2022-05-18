package com.cts.fse.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Stock {

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
    private Company companyQuery;
}

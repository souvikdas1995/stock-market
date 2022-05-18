package com.cts.fse.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString*/
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int companyCode;

    private String companyName;

    private String description;

    private String ceo;

    private long turnover;

    private String website;

    private String exchange;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "companyQuery",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Stock> stocks;





}


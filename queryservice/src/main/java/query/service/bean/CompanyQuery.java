package query.service.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "companyquery")
public class CompanyQuery {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int companyCode;

    private String companyName;

    private String description;

    private String ceo;

    private long turnover;

    private String website;

    private String exchange;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "companyQuery")
    private List<StockQuery> stocks;





}


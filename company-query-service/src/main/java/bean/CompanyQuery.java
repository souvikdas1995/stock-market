package bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="COMPANYQUERY")
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

    @OneToMany(mappedBy="companyquery", cascade = CascadeType.ALL)
    private List<StockQuery> stocks;



}


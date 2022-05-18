package query.service.bean;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "companyQuery",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<StockQuery> stocks;





}


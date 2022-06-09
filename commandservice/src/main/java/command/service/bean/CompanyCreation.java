package command.service.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "companycreation")
public class CompanyCreation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyCode;

    private String companyName;

    private String description;

    private String ceo;

    private long turnover;

    private String website;

    private String exchange;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "companyCreation")
    private List<StockCreation> stocks;
}


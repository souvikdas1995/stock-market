package auth.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by nydiarra on 10/05/17.
 */
@Entity
@Table(name = "random_city")
@Getter
@Setter
public class RandomCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}

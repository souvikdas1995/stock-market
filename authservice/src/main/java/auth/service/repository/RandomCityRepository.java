package auth.service.repository;

import auth.service.model.RandomCity;
import org.springframework.data.repository.CrudRepository;
public interface RandomCityRepository extends CrudRepository<RandomCity, Long> {
}

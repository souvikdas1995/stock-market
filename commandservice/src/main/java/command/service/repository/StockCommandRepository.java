package command.service.repository;

import command.service.bean.StockCreation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockCommandRepository extends CrudRepository<StockCreation, Integer> {
}

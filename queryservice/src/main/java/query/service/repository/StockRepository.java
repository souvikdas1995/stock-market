package query.service.repository;

import org.springframework.data.repository.CrudRepository;
import query.service.bean.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{
}

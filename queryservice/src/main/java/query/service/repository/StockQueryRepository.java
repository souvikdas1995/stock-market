package query.service.repository;

import org.springframework.data.repository.CrudRepository;
import query.service.bean.StockQuery;

public interface StockQueryRepository extends CrudRepository<StockQuery, Integer>{
}

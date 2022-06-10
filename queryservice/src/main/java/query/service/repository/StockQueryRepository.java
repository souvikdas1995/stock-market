package query.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import query.service.bean.StockQuery;

import java.util.Optional;

@Repository
public interface StockQueryRepository extends MongoRepository<StockQuery, Long> {

    Optional<StockQuery> findByStockCode(Long stockCode);

}

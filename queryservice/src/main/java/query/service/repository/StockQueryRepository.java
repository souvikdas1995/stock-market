package query.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import query.service.bean.StockQuery;

import java.util.Date;
import java.util.List;

@Repository
public interface StockQueryRepository extends MongoRepository<StockQuery, Long> {

    List<StockQuery> findByCompanyQueryCompanyCodeAndCreatedOnBetween(Long companyId, Date startDate, Date endDate);

}

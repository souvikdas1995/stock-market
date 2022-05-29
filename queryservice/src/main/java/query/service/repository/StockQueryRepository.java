package query.service.repository;

import command.service.bean.StockCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import query.service.bean.StockQuery;

import java.util.Date;
import java.util.List;

@Repository
public interface StockQueryRepository extends JpaRepository<StockQuery, Integer> {

    List<StockQuery> findByCompanyQueryCompanyCodeAndCreatedOnBetween(int companyId, Date startDate, Date endDate);

}

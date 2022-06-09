package query.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import query.service.bean.CompanyQuery;

@Repository
public interface CompanyQueryRepository extends MongoRepository<CompanyQuery, Long> {

    }


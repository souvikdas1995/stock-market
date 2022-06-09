package query.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import query.service.bean.CompanyQuery;

@Repository
public interface CompanyQueryRepository extends JpaRepository<CompanyQuery, Integer> {

    }


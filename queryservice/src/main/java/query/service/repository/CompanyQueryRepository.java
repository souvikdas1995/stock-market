package query.service.repository;

import command.service.bean.CompanyCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import query.service.bean.CompanyQuery;

@Repository
public interface CompanyQueryRepository extends JpaRepository<CompanyQuery, Integer> {

    }


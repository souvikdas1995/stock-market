package command.service.repository;

import command.service.bean.CompanyCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyCommandRepository extends JpaRepository<CompanyCreation, Long> {

}
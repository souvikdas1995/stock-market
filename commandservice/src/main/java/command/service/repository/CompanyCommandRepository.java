package command.service.repository;

import command.service.bean.CompanyCreation;
import org.springframework.data.repository.CrudRepository;

public interface CompanyCommandRepository extends CrudRepository<CompanyCreation, Integer> {
}

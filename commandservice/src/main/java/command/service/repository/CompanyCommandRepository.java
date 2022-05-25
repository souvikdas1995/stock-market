package command.service.repository;

import command.service.bean.CompanyCreation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyCommandRepository extends JpaRepository<CompanyCreation, Integer> {
}
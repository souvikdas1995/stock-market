package command.service.service;

import command.service.bean.CompanyCreation;
import command.service.repository.CompanyCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyCommandService {


    @Autowired
    CompanyCommandRepository companyRepository;

    public void addCompany(CompanyCreation company) {
        companyRepository.save(company);
    }
}

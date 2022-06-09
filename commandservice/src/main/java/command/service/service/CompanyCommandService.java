package command.service.service;

import command.service.bean.CompanyCreation;
import command.service.repository.CompanyCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyCommandService {



    @Autowired
    CompanyCommandRepository companyCommandRepository;

    public CompanyCreation createCompany(CompanyCreation companyQuery){
        CompanyCreation savedCompanyQuery = companyCommandRepository.save(companyQuery);
        return savedCompanyQuery;
    }

    public CompanyCreation updateCompany(CompanyCreation companyQuery, int companyCode){
        Optional<CompanyCreation> companyQueryOptional=companyCommandRepository.findById(companyCode);
        if(!companyQueryOptional.isPresent())
            return null;

        companyQuery.setCompanyCode(companyQueryOptional.get().getCompanyCode());
        companyCommandRepository.save(companyQuery);
        return companyQuery;

    }

    public boolean deleteCompany(int companyCode){
        Optional<CompanyCreation> companyQueryOptional=companyCommandRepository.findById(companyCode);
        if(!companyQueryOptional.isPresent())
            return false;
        companyCommandRepository.deleteById(companyCode);
        return true;

    }

}

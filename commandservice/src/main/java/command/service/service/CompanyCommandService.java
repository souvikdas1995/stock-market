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

    @Autowired
    MessageProducer messageProducer;

    public CompanyCreation createCompany(CompanyCreation companyQuery){
        CompanyCreation savedCompanyQuery = companyCommandRepository.saveAndFlush(companyQuery);
        messageProducer.publishMessage(companyCommandRepository.findById(savedCompanyQuery.getCompanyCode()).get());
        return savedCompanyQuery;
    }

    public CompanyCreation updateCompany(CompanyCreation companyQuery, Long companyCode){
        Optional<CompanyCreation> companyQueryOptional=companyCommandRepository.findById(companyCode);
        if(!companyQueryOptional.isPresent())
            return null;

        companyQuery.setCompanyCode(companyQueryOptional.get().getCompanyCode());
        CompanyCreation save = companyCommandRepository.saveAndFlush(companyQuery);
        CompanyCreation companyCreation = companyCommandRepository.findById(companyQuery.getCompanyCode()).get();
        messageProducer.publishMessage(companyCreation);
        return companyQuery;

    }

    public boolean deleteCompany(Long companyCode){
        Optional<CompanyCreation> companyQueryOptional=companyCommandRepository.findById(companyCode);
        if(!companyQueryOptional.isPresent())
            return false;
        companyCommandRepository.deleteById(companyCode);
        return true;

    }

}

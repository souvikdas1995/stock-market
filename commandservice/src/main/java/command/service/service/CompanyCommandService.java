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
        companyCommandRepository.save(companyQuery);
        CompanyCreation companyCreation = companyCommandRepository.findById(companyQuery.getCompanyCode()).get();
        companyCommandRepository.refresh(companyCreation);
        messageProducer.publishMessage(companyCreation);
        return companyCreation;

    }

    public CompanyCreation updateCompany(CompanyCreation companyQuery, Long companyCode){
        Optional<CompanyCreation> companyQueryOptional=companyCommandRepository.findById(companyCode);
        if(!companyQueryOptional.isPresent())
            return null;

        companyQuery.setCompanyCode(companyQueryOptional.get().getCompanyCode());
        companyCommandRepository.save(companyQuery);

        CompanyCreation companyupdation = companyCommandRepository.findById(companyQuery.getCompanyCode()).get();
        companyCommandRepository.refresh(companyupdation);
        messageProducer.publishMessage(companyupdation);
        return companyupdation;

    }

    public boolean deleteCompany(Long companyCode){
        Optional<CompanyCreation> companyQueryOptional=companyCommandRepository.findById(companyCode);
        if(!companyQueryOptional.isPresent())
            return false;
        companyCommandRepository.deleteById(companyCode);
        return true;

    }

}

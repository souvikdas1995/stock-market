package query.service.service;

import command.service.bean.CompanyCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import query.service.repository.CompanyQueryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyQueryService {

    @Autowired
    CompanyQueryRepository companyQueryRepository;

    public List<CompanyCreation> getAllCompanies()
    {
        List<CompanyCreation> companies = new ArrayList<CompanyCreation>();
        companyQueryRepository.findAll().forEach(company -> companies.add(company));
        return companies;
    }

    public Optional<CompanyCreation> getSingleCompanybyCompanyId(int companyCode){
        return companyQueryRepository.findById(companyCode);
    }
}

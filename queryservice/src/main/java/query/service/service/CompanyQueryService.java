package query.service.service;

import query.service.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import query.service.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyQueryService {

    @Autowired
    CompanyRepository companyQueryRepository;

    public List<Company> getAllCompanies()
    {
        List<Company> companies = new ArrayList<Company>();
        companyQueryRepository.findAll().forEach(company -> companies.add(company));
        return companies;
    }

    public Optional<Company> getSingleCompanybyCompanyId(int companyCode){
        return companyQueryRepository.findById(companyCode);
    }
}

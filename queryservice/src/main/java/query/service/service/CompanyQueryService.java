package query.service.service;

import query.service.bean.CompanyQuery;
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

    public List<CompanyQuery> getAllCompanies()
    {
        List<CompanyQuery> companies = new ArrayList<CompanyQuery>();
        companyQueryRepository.findAll().forEach(company -> companies.add(company));
        return companies;
    }

    public Optional<CompanyQuery> getSingleCompanybyCompanyId(int companyCode){
        return companyQueryRepository.findById(companyCode);
    }
}

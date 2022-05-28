package query.service.service;

<<<<<<< HEAD
import query.service.bean.Company;
=======
import command.service.bean.CompanyCreation;
>>>>>>> branch 'marketdev' of https://github.com/souvikdas1995/stock-market.git
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

<<<<<<< HEAD
    public List<Company> getAllCompanies()
=======
    public List<CompanyCreation> getAllCompanies()
>>>>>>> branch 'marketdev' of https://github.com/souvikdas1995/stock-market.git
    {
<<<<<<< HEAD
        List<Company> companies = new ArrayList<Company>();
=======
        List<CompanyCreation> companies = new ArrayList<CompanyCreation>();
>>>>>>> branch 'marketdev' of https://github.com/souvikdas1995/stock-market.git
        companyQueryRepository.findAll().forEach(company -> companies.add(company));
        return companies;
    }

<<<<<<< HEAD
    public Optional<Company> getSingleCompanybyCompanyId(int companyCode){
        return companyQueryRepository.findById(companyCode);
=======
    public CompanyCreation getSingleCompanybyCompanyId(int companyCode) throws  Exception{
        return companyQueryRepository
                .findById(companyCode)
                .orElseThrow(()-> new Exception("company not found with this id "+companyCode));
>>>>>>> branch 'marketdev' of https://github.com/souvikdas1995/stock-market.git
    }
}

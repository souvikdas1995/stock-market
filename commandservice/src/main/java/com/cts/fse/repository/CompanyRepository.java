package com.cts.fse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fse.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    }


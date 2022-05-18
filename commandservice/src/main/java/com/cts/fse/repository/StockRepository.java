package com.cts.fse.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.fse.entity.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{
}

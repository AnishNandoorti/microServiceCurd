package com.microservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservice.entity.CustomerData;

public interface CustRepository extends CrudRepository<CustomerData, Long> {

	public CustomerData findById(int id);

	public List<CustomerData> findAll();

}

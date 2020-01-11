package com.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.CustResponse;
import com.microservice.entity.CustomerData;
import com.microservice.repository.CustRepository;
import com.microservice.repository.DataRespository;

@RestController
@RequestMapping(value = "/api")
public class MicroServiceController {

	@Autowired
	private CustRepository repository;

	@Autowired
	private DataRespository dataRepo;

	@RequestMapping(value = "/getCustData", method = RequestMethod.POST)
	public CustResponse getCustDatabyId(@RequestBody CustomerData acctNum) {
		CustomerData custData = new CustomerData();
		CustResponse custResponse = new CustResponse();
		custData = repository.findById(acctNum.getId());
		if (null != custData) {
			custResponse.setCustData(acctNum);
			custResponse.setRespCode("0000");
			custResponse.setRespDesc("Success");
		} else {
			custResponse.setCustData(acctNum);
			custResponse.setRespCode("3333");
			custResponse.setRespDesc("Account Number doesn't exist");
		}
		return custResponse;
	}

	@RequestMapping(value = "/getAllCustData", method = RequestMethod.GET)
	public List<CustomerData> getAllCustData() {
		List<CustomerData> custData = new ArrayList<CustomerData>();
		custData = repository.findAll();
		return custData;
	}

	@RequestMapping(value = "/insertCustData", method = RequestMethod.POST, consumes = { "application/json" })
	public CustResponse insertCustData(@RequestBody CustomerData data) throws Exception {

		CustomerData custData = new CustomerData();
		CustResponse custResponse = new CustResponse();
		custData = repository.findById(data.getId());
		if (null != custData) {
			custResponse.setCustData(data);
			custResponse.setRespCode("2222");
			custResponse.setRespDesc("Account Number already exist");
		} else {
			CustomerData id = repository.save(data);

			if (id.getId() != null) {
				custResponse.setCustData(id);
				custResponse.setRespCode("0000");
				custResponse.setRespDesc("Success");
			} else {
				custResponse.setRespCode("1111");
				custResponse.setRespDesc("Failed");
			}
		}
		return custResponse;
	}

	@RequestMapping(value = "/updateCustData", method = RequestMethod.POST)
	public CustResponse updateCustData(@RequestBody CustomerData data) {
		CustomerData custData = new CustomerData();
		CustResponse custResponse = new CustResponse();
		custData = repository.findById(data.getId());
		if (null != custData) {
			CustomerData id = repository.save(data);

			if (id.getId() != null) {
				custResponse.setCustData(id);
				custResponse.setRespCode("0000");
				custResponse.setRespDesc("Success");
			} else {
				custResponse.setRespCode("1111");
				custResponse.setRespDesc("Failed");
			}
		} else {
			custResponse.setCustData(data);
			custResponse.setRespCode("3333");
			custResponse.setRespDesc("Account Number doesn't exist");
		}
		return custResponse;
	}

	@RequestMapping(value = "/deleteCustData", method = RequestMethod.POST)
	public CustResponse DeleteCustData(@RequestBody CustomerData data) {
		System.out.println(Long.valueOf(data.getId()));
		dataRepo.deleteById(data.getId());
		CustomerData custData = new CustomerData();
		CustResponse custResponse = new CustResponse();
		custData = repository.findById(data.getId());
		if (null != custData) {
			custResponse.setRespCode("1111");
			custResponse.setRespDesc("Failed");
		} else {
			custResponse.setCustData(data);
			custResponse.setRespCode("0000");
			custResponse.setRespDesc("Success");
		}
		return custResponse;
	}
}

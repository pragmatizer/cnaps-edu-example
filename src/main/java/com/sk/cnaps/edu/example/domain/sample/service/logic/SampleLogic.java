package com.sk.cnaps.edu.example.domain.sample.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sk.cnaps.domain.model.IdValue;
import com.sk.cnaps.edu.example.domain.sample.model.Business;
import com.sk.cnaps.edu.example.domain.sample.model.Service;
import com.sk.cnaps.edu.example.domain.sample.repository.BusinessRepository;
import com.sk.cnaps.edu.example.domain.sample.repository.ServiceRepository;
import com.sk.cnaps.edu.example.domain.sample.service.SampleService;

@org.springframework.stereotype.Service
public class SampleLogic implements SampleService {
	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	

	@Override
	@Transactional
	public void doSomethingManyAggregates() {
		Business business = registerBusiness("TEST");
		Service service = registerService(business.getId());
		System.err.println(service.toString());	
		service.getBusiness().setValue(business);
		System.err.println(service.toString());	
	}
	
	private Business registerBusiness(String name) {
		return businessRepository.save(Business.builder().name(name).description(name + " description").build());
	}
	
	private Service registerService(Long businessId) {
		return serviceRepository.save(Service.builder().name("test").business(new IdValue<Business>(businessId)).build());
	}

	@Override
	public void doSomethingUsingServicedesk() {
		// TODO Auto-generated method stub
		
	}
}

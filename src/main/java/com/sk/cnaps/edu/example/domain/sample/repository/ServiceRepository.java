package com.sk.cnaps.edu.example.domain.sample.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sk.cnaps.edu.example.domain.sample.model.Business;
import com.sk.cnaps.edu.example.domain.sample.model.Service;

public interface ServiceRepository extends PagingAndSortingRepository<Service, Long>,
										   QueryDslPredicateExecutor<Business> {	
}
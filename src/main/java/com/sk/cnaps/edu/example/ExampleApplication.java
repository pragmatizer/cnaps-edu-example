package com.sk.cnaps.edu.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.cnaps.application.sp.web.EnumTypeRestController;
import com.sk.cnaps.edu.example.domain.sample.service.logic.SampleLogic;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableFeignClients
public class ExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner test(SampleLogic sampleLogic) {
		return (args) -> {
			sampleLogic.doSomethingManyAggregates();
			
			//sampleLogic.doSomethingUsingServicedesk();
		};
	}

	@Bean
	public EnumTypeRestController createEnumtypeRestController() {
		return new EnumTypeRestController("com.sk");
	}
}

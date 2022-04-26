package com.side.anitime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.side.anitime.domain.category.PlanCategoryType;
import com.side.anitime.repository.plan.PlanCategoryTypeRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class AnitimeApplication extends SpringBootServletInitializer implements CommandLineRunner {
	
	private final PlanCategoryTypeRepository planCategoryTypeRepository;

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AnitimeApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AnitimeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<PlanCategoryType> planCategoryTypeList = new ArrayList<>();
		planCategoryTypeList.add(new PlanCategoryType(1L, "병원"));
		planCategoryTypeList.add(new PlanCategoryType(2L, "일"));
		planCategoryTypeList.add(new PlanCategoryType(3L, "생일"));
		planCategoryTypeList.add(new PlanCategoryType(4L, "모임"));
		planCategoryTypeList.add(new PlanCategoryType(5L, "기타"));
		
		if(planCategoryTypeRepository.count() < 1) {
			planCategoryTypeRepository.saveAllAndFlush(planCategoryTypeList);
		}
		
	}

}

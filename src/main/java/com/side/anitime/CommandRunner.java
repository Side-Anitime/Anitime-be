package com.side.anitime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.side.anitime.domain.category.Color;
import com.side.anitime.domain.category.PlanCategoryType;
import com.side.anitime.repository.plan.ColorRepository;
import com.side.anitime.repository.plan.PlanCategoryTypeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
	
	private final PlanCategoryTypeRepository planCategoryTypeRepository;
	private final ColorRepository colorRepository;
	
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
		
		List<Color> colorList = new ArrayList<>();
		colorList.add(new Color(1L, "#DB4035"));
		colorList.add(new Color(2L, "#FAD000"));
		colorList.add(new Color(3L, "#299438"));
		colorList.add(new Color(4L, "#4073FF"));
		colorList.add(new Color(5L, "#FF8D85"));
		
		if(colorRepository.count() < 1) {
			colorRepository.saveAllAndFlush(colorList);
		}
		
	}

}

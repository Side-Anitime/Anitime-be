package com.side.anitime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.side.anitime.domain.plan.Alarm;
import com.side.anitime.domain.plan.Color;
import com.side.anitime.domain.plan.PlanCategory;
import com.side.anitime.repository.alarm.AlarmRepository;
import com.side.anitime.repository.plan.ColorRepository;
import com.side.anitime.repository.plan.PlanCategoryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
	
	private final PlanCategoryRepository planCategoryTypeRepository;
	private final ColorRepository colorRepository;
	private final AlarmRepository alarmRepository;
	
	@Override
	public void run(String... args) throws Exception {
		List<PlanCategory> planCategoryTypeList = new ArrayList<>();
		planCategoryTypeList.add(new PlanCategory(1L, "병원"));
		planCategoryTypeList.add(new PlanCategory(2L, "일"));
		planCategoryTypeList.add(new PlanCategory(3L, "생일"));
		planCategoryTypeList.add(new PlanCategory(4L, "모임"));
		planCategoryTypeList.add(new PlanCategory(5L, "기타"));
		
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
		
		List<Alarm> alarmList = new ArrayList<>();
		alarmList.add(new Alarm(1L, "-10min"));
		alarmList.add(new Alarm(2L, "-30min"));
		alarmList.add(new Alarm(3L, "-1day"));
		alarmList.add(new Alarm(4L, "ontime"));
		alarmList.add(new Alarm(5L, "noalarm"));
		
		if(alarmRepository.count() < 1) {
			alarmRepository.saveAllAndFlush(alarmList);
		}
		
	}

}

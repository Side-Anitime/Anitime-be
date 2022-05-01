package com.side.anitime.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.side.anitime.domain.plan.Alarm;
import com.side.anitime.domain.plan.Color;
import com.side.anitime.domain.plan.PlanCategory;
import com.side.anitime.repository.alarm.AlarmRepository;
import com.side.anitime.repository.plan.ColorRepository;
import com.side.anitime.repository.plan.PlanCategoryTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanCategoryTypeRepository planCategoryTypeRepository;
    private final ColorRepository colorRepository;
    private final AlarmRepository alarmRepository;
    
    public List<PlanCategory> getPlanCategoryTypeList(){
    	return planCategoryTypeRepository.findAll();
    }
    
    public List<Color> getColorList(){
    	return colorRepository.findAll();
    }
    
    public List<Alarm> getAlarmTypeList(){
    	return alarmRepository.findAll();
    }
    
}

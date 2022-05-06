package com.side.anitime.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.side.anitime.domain.plan.Alarm;
import com.side.anitime.domain.plan.Color;
import com.side.anitime.domain.plan.PlanCategory;
import com.side.anitime.domain.user.User;
import com.side.anitime.repository.alarm.AlarmRepository;
import com.side.anitime.repository.plan.ColorRepository;
import com.side.anitime.repository.plan.PlanCategoryRepository;
import com.side.anitime.repository.plan.PlanRepository;
import com.side.anitime.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {

	private final PlanRepository planRepository;
    private final PlanCategoryRepository planCategoryRepository;
    private final ColorRepository colorRepository;
    private final AlarmRepository alarmRepository;
    private final UserRepository userRepository;
    
    public void savePlan(com.side.anitime.dto.Plan.SaveReq vo) {
    	//TODO userToken to user DTO
    	
    	// 일정일 시작일 종료일 초기화
    	vo.setStartDate(vo.getStartDate()+":00.000");
    	vo.setEndDate(vo.getEndDate()+":59.999");
    	
    	// String to LocalDateTime
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    	LocalDateTime planStartDate = LocalDateTime.parse(vo.getStartDate(), formatter);
    	LocalDateTime planEndDate = LocalDateTime.parse(vo.getEndDate(), formatter);
    	
    	// req param에 해당하는 entity 정보 가져오기
    	Color colorDto = colorRepository.findById(vo.getColorId()).get();
    	PlanCategory planCategoryDto = planCategoryRepository.findById(vo.getPlanCategoryId()).get();
    	Alarm alarmDto = alarmRepository.findById(vo.getAlarmId()).get();
    	User userDto = userRepository.findByUserToken(vo.getUserToken());
    	
    	com.side.anitime.domain.plan.Plan planDto = com.side.anitime.domain.plan.Plan
																		  .builder()
														    			  .contents(vo.getContents())
														    			  .title(vo.getTitle())
														    			  .startDate(planStartDate)
														    			  .endDate(planEndDate)
														    			  .color(colorDto)
														    			  .planCategory(planCategoryDto)
														    			  .alarm(alarmDto)
														    			  .user(userDto)
														    			  .build();
    	
    	planRepository.save(planDto);
    }
    
    public List<PlanCategory> getPlanCategoryTypeList(){
    	return planCategoryRepository.findAll();
    }
    
    public List<Color> getColorList(){
    	return colorRepository.findAll();
    }
    
    public List<Alarm> getAlarmTypeList(){
    	return alarmRepository.findAll();
    }
    
}

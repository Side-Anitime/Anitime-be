package com.side.anitime.service.plan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.side.anitime.domain.plan.Alarm;
import com.side.anitime.domain.plan.Color;
import com.side.anitime.domain.plan.Plan;
import com.side.anitime.domain.plan.PlanCategory;
import com.side.anitime.domain.plan.PlanPetMapping;
import com.side.anitime.domain.user.User;
import com.side.anitime.dto.PlanDTO;
import com.side.anitime.dto.PlanDTO.CalendarViewRes;
import com.side.anitime.dto.PlanDTO.SavePlanReq;
import com.side.anitime.repository.alarm.AlarmRepository;
import com.side.anitime.repository.pet.PetRepository;
import com.side.anitime.repository.plan.ColorRepository;
import com.side.anitime.repository.plan.PlanCategoryRepository;
import com.side.anitime.repository.plan.PlanPetMappingRepository;
import com.side.anitime.repository.plan.PlanRepository;
import com.side.anitime.repository.user.UserRepository;
import com.side.anitime.util.DateUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {

	private final PlanRepository planRepository;
	private final PlanCategoryRepository planCategoryRepository;
	private final ColorRepository colorRepository;
	private final AlarmRepository alarmRepository;
	private final UserRepository userRepository;
	private final PlanPetMappingRepository planPetMappingRepository;
	private final PetRepository petRepository;

	public void savePlan(SavePlanReq vo) {
		// TODO userToken to user DTO

		// 일정일 시작일 종료일 초기화
		vo.setStartDate(vo.getStartDate() + ":00.000");
		vo.setEndDate(vo.getEndDate() + ":59.999");

		// String to LocalDateTime
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime planStartDate = LocalDateTime.parse(vo.getStartDate(), formatter);
		LocalDateTime planEndDate = LocalDateTime.parse(vo.getEndDate(), formatter);

		// req param에 해당하는 entity 정보 가져오기
		Color colorDto = colorRepository.findById(vo.getColorId()).get();
		PlanCategory planCategoryDto = planCategoryRepository.findById(vo.getPlanCategoryId()).get();
		Alarm alarmDto = alarmRepository.findById(vo.getAlarmId()).get();
		User userDto = userRepository.findByUserToken(vo.getUserToken());

		Plan planDto = Plan.builder()
				.contents(vo.getContents()).title(vo.getTitle()).startDate(planStartDate).endDate(planEndDate)
				.color(colorDto).planCategory(planCategoryDto).alarm(alarmDto).user(userDto).build();

		Plan savedPlan = planRepository.save(planDto);

		List<PlanPetMapping> planPetMappingList = new ArrayList<PlanPetMapping>();
		
		for(Long petId : vo.getPetIds()) {
			PlanPetMapping planPetMapping = new PlanPetMapping();
			planPetMapping.setPlan(savedPlan);
			planPetMapping.setPet(petRepository.findById(petId).get());
			
			planPetMappingList.add(planPetMapping);
		}
		planPetMappingRepository.saveAll(planPetMappingList);
		
	}

	public List<PlanCategory> getPlanCategoryTypeList() {
		return planCategoryRepository.findAll();
	}

	public List<Color> getColorList() {
		return colorRepository.findAll();
	}

	public List<Alarm> getAlarmTypeList() {
		return alarmRepository.findAll();
	}
	
	public List<Plan> getFindPlansByDate(String year, String month, String day, String userToken){
		
		LocalDateTime startDate = DateUtil.getFormattedStartDate(year, month, day);
		LocalDateTime endDate =  DateUtil.getFormattedEndDate(year, month, day);
		return planRepository.findPlanByDate(startDate, endDate, userToken);
		
	}

	public List<HashMap<String,Object>> getCalendarPlanByYearMonth(PlanDTO.CalendarViewReq vo) throws Exception {

		List<HashMap<String,Object>> findPlanMapList = new ArrayList<HashMap<String,Object>>();
		
		//요청 월의 마지막 날짜 정보 초기화
		int monthLastDay = DateUtil.getLastDateByMonth(vo.getYear(), vo.getMonth());
		
		//시작 일 부터 마지막 일 까지 일정 조회
		for (int dayIndex = 1; dayIndex <= monthLastDay; dayIndex++) {
			
			//조회 기간 초기화
			LocalDateTime startDate = DateUtil.getFormattedStartDate(vo.getYear(), vo.getMonth(), dayIndex);
			LocalDateTime endDate =  DateUtil.getFormattedEndDate(vo.getYear(), vo.getMonth(), dayIndex);

			//해당 기간 일정 조회
			List<Plan> findPlanList = planRepository.findPlanByDate(startDate, endDate, vo.getUserToken());
			
			List<String> categoryNameList = new ArrayList<String>();
			List<PlanDTO.Color>colorHexList = new ArrayList<PlanDTO.Color>();
			for (Plan findPlanDto : findPlanList) {
				
				PlanDTO.Color colorDto = new PlanDTO.Color(); 
				colorDto.setColor(findPlanDto.getColor().getHex());
				
				categoryNameList.add(findPlanDto.getPlanCategory().getPlanCategoryName());
				colorHexList.add(colorDto);
			}
			
			PlanDTO.CalendarViewRes calendarViewResDto = new CalendarViewRes();
			calendarViewResDto.setName(categoryNameList.toArray(new String[categoryNameList.size()]));
			calendarViewResDto.setDots(colorHexList);
			
			HashMap<String, Object> findPlanByDateMap = new HashMap<>();
			findPlanByDateMap.put(DateUtil.getFormattedDate(vo.getYear(), vo.getMonth(), dayIndex), calendarViewResDto);
			findPlanMapList.add(findPlanByDateMap);
		}

		return findPlanMapList;
		
	}

}

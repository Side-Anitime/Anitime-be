package com.side.anitime.repository.plan;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.side.anitime.domain.plan.Plan;

@Transactional
public interface PlanRepository extends JpaRepository<Plan, Long> {
	
	@Query(value = "SELECT P.* FROM plan P"
			+ " LEFT OUTER JOIN user U ON P.user_id = U.user_id "
			+ "WHERE U.user_token=:user_token AND :start_date  BETWEEN P.start_date AND  P.end_date "
			+ "OR  :end_date  BETWEEN P.start_date AND P.end_date", nativeQuery = true)
	List<Plan> findPlanByDate(
			  @Param("start_date") LocalDateTime startDate
			, @Param("end_date") LocalDateTime endDate
			, @Param("user_token") String userToken
			);
	
	@Modifying
    @Query(value ="UPDATE plan P SET P.update_date = NOW()"
    		+ ", P.contents = :contents"
    		+ ", P.title = :title"
    		+ ", P.alarm_id = :alarmId"
    		+ ", P.start_date = :startDate"
    		+ ", P.end_date = :endDate"
    		+ ", P.color_id = :colorId "
    		+ ", P.plan_category_id = :planCategoryId"
    		+ "WHERE P.user_id = :userId AND P.plan_id = :planId", nativeQuery = true)
    void updatePlanByUserId(@Param("contents") String contents
    		, @Param("title") String title
    		, @Param("startDate") LocalDateTime startDate
    		, @Param("endDate") LocalDateTime endDate
    		, @Param("colorId") Long colorId
    		, @Param("planCategoryId") Long planCategoryId
    		, @Param("alarmId") Long alarmId
    		, @Param("userId") Long userId
    		, @Param("planId") Long planId);
	
}

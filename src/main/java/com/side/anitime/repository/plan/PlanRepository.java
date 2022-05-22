package com.side.anitime.repository.plan;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.side.anitime.domain.plan.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
	
	@Query(value = "SELECT P.* FROM plan P"
			+ " LEFT OUTER JOIN user U ON P.user_id = U.user_id "
			+ "WHERE U.user_token=:user_token AND P.start_date BETWEEN :start_date AND :end_date "
			+ "OR P.end_date BETWEEN :start_date AND :end_date", nativeQuery = true)
	List<Plan> findByPlanBetween(
			  @Param("start_date") LocalDateTime startDate
			, @Param("end_date") LocalDateTime endDate
			, @Param("user_token") String userToken
			);
	
	
	@Query(value = "SELECT P.* FROM plan P" 
			+ " LEFT OUTER JOIN user U ON P.user_id = U.user_id " 
			+ " WHERE U.user_token=:user_token " 
			+ " AND start_date >= NOW()"
			+ " ORDER BY start_date desc LIMIT :limit", nativeQuery = true)
	List<Plan> findByUserTokenLatestPlan(@Param("user_token") String userToken, @Param("limit") int limit);
	
}

package com.side.anitime.repository.alarm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.side.anitime.domain.plan.Alarm;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}

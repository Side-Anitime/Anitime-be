package com.side.anitime.domain.plan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ALARM")
public class Alarm {

    @Id
    @Column(name = "ALARM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarmId;

    @Column(name = "ALARM_TYPE", length = 10)
    private String alarmType;
  
}

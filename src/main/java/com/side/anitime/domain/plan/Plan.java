package com.side.anitime.domain.plan;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.side.anitime.domain.common.BaseEntity;
import com.side.anitime.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PLAN")
public class Plan extends BaseEntity {

    @Id
    @Column(name = "PLAN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @Column(name = "TITLE", length = 50)
    private String title;

    @Column(name = "CONTENTS", length = 200)
    private String contents;

    @Column(name = "START_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime endDate;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "COLOR_ID")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "PLAN_CATEGORY_ID")
    private PlanCategory planCategory;
    
    @ManyToOne
    @JoinColumn(name = "ALARM_ID")
    private Alarm alarm;

}

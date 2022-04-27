package com.side.anitime.domain.plan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.side.anitime.domain.alarm.Alarm;
import com.side.anitime.domain.category.Color;
import com.side.anitime.domain.category.PlanCategory;
import com.side.anitime.domain.common.BaseEntity;
import com.side.anitime.domain.user.User;

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

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "COLOR_ID")
    private Color color;

    @Column(name = "START_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAN_ID", referencedColumnName = "PLAN_ID")
    private PlanCategory planCategory;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAN_ID", referencedColumnName = "PLAN_ID")
    private List<Alarm> alarms = new ArrayList<>();
}

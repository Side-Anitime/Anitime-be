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
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {

    @Id
    @Column(name = "PLAN_CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planCategoryId;

    @Column(name = "PLAN_CATEGORY_NAME", length = 10)
    private String planCategoryName;

}

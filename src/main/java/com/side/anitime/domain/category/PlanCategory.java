package com.side.anitime.domain.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.side.anitime.domain.plan.Plan;

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

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private PlanCategoryType planCategoryType;

    @Column(name = "NAME", length = 10)
    private String name;

    @OneToOne
    @JoinColumn(name="PLAN_ID")
    private Plan plan;
}

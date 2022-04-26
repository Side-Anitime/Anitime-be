package com.side.anitime.domain.category;

import com.side.anitime.codeconst.PlanType;
import com.side.anitime.domain.alarm.Alarm;
import com.side.anitime.domain.plan.Plan;
import com.side.anitime.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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

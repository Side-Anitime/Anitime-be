package com.side.anitime.domain.category;

import com.side.anitime.codeconst.PlanType;
import com.side.anitime.domain.plan.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

    @Column(name = "TYPE", columnDefinition = "ENUM('HOSPITAL', 'WALK', 'BIRTHDAY', 'MOIM', 'ETC') DEFAULT 'ETC'")
    private PlanType type;

    @Column(name = "NAME", length = 10)
    private String name;

    @OneToOne
    @JoinColumn(name="PLAN_ID")
    private Plan plan;
}

package com.side.anitime.domain.category;

import com.side.anitime.codeconst.PlanType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planCategoryId;

    @Column(columnDefinition = "ENUM('HOSPITAL', 'WALK', 'BIRTHDAY', 'MOIM', 'ETC') DEFAULT 'ETC'")
    private PlanType planType;

    @Column(length = 10)
    private String name;

    private Long planId; //TODO: plan과 foreign key 설정, OneToOne
}

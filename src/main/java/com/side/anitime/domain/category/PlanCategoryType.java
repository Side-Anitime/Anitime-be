package com.side.anitime.domain.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PLAN_CATEGORY_TYPE")
public class PlanCategoryType {

    public PlanCategoryType(Long typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	@Id
    @Column(name = "TYPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @Column(name = "TYPE_NAME", length = 10)
    private String typeName;

}

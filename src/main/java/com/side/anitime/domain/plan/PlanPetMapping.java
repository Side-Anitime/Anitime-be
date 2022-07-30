package com.side.anitime.domain.plan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.side.anitime.domain.pet.Pet;

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
@Table(name = "PLAN_PET_MAPPING",uniqueConstraints={
        	@UniqueConstraint(columnNames={"PLAN_ID", "PET_ID"})
        })
public class PlanPetMapping {
	
	@Id
    @Column(name = "MAPPING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mappingId;

    @ManyToOne
    @JoinColumn(name = "PLAN_ID")
    private Plan plan;
    
    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

}

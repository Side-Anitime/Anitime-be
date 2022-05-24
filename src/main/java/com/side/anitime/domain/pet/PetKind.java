package com.side.anitime.domain.pet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.side.anitime.codeconst.AnimalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PET_KIND")
public class PetKind {

	@Id
	@Column(name = "PET_KIND_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petTypeId;

	@Column(name = "TYPE", columnDefinition = "ENUM('DOG', 'CAT') DEFAULT 'DOG'")
	@Enumerated(EnumType.STRING)
	private AnimalType type;

	@Column(name = "KIND_NAME", length = 20)
	private String kindName;

}

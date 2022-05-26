package com.side.anitime.domain.pet;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.side.anitime.codeconst.AnimalType;
import com.side.anitime.codeconst.Gender;
import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.common.BaseEntity;
import com.side.anitime.domain.plan.PlanCategory;
import com.side.anitime.domain.user.User;

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
@Table(name = "PET")
public class Pet extends BaseEntity{

    @Id
    @Column(name = "PET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "PET_KIND_ID")
    private PetKind petKind;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "BIRTHDAY")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "PERSONALITY", length = 100)
    private String personality;

    @Column(name = "IMAGE", length = 50)
    private String image;
    
    @Column(name = "TYPE", columnDefinition = "ENUM('DOG', 'CAT') DEFAULT 'DOG'")
    @Enumerated(EnumType.STRING)
    private AnimalType type;

    @Column(name = "GENDER", columnDefinition = "ENUM('FEMALE', 'MALE') DEFAULT 'MALE'")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "NEUTER_YN", columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    @Enumerated(EnumType.STRING)
    private YesNo neuterYn;

    @Column(name = "REPRESENT_YN", columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    @Enumerated(EnumType.STRING)
    private YesNo representYn;
    
}

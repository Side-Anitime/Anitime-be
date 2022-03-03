package com.side.anitime.domain.pet;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.side.anitime.codeconst.AnimalType;
import com.side.anitime.codeconst.Gender;
import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.Member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PET")
public class Pet {

    @Id
    @Column(name = "PET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Member user;

    @Column(name = "TYPE", columnDefinition = "ENUM('DOG', 'CAT') DEFAULT 'DOG'")
    private AnimalType type;

    @Column(name = "KIND", length = 20)
    private String kind;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "BIRTHDAY")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "PERSONALITY", length = 100)
    private String personality;

    @Column(name = "IMAGE", length = 50)
    private String image;

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

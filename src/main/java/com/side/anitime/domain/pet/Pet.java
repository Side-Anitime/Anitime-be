package com.side.anitime.domain.pet;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.side.anitime.codeconst.AnimalType;
import com.side.anitime.codeconst.Gender;
import com.side.anitime.codeconst.YesNo;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    private Long userId; //TODO; user와 foreign key 설정, ManyToOne

    @Column(columnDefinition = "ENUM('DOG', 'CAT') DEFAULT 'DOG'")
    private AnimalType type;

    @Column(length = 20)
    private String kind;

    @Column(length = 20)
    private String name;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(length = 100)
    private String personality;

    @Column(length = 50)
    private String image;

    @Column(columnDefinition = "ENUM('FEMALE', 'MALE') DEFAULT 'MALE'")
    private Gender gender;

    @Column(columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    @Enumerated(EnumType.STRING)
    private YesNo neuterYn;

    @Column(columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    @Enumerated(EnumType.STRING)
    private YesNo representYn;
}

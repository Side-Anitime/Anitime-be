package com.side.anitime.domain.category;

import com.side.anitime.codeconst.AnimalType;
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
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(columnDefinition = "ENUM('DOG', 'CAT') DEFAULT 'DOG'")
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    @Column(length = 20)
    private String name;
}

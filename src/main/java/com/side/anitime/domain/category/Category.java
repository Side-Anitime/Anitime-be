package com.side.anitime.domain.category;

import com.side.anitime.codeconst.AnimalType;
import com.side.anitime.domain.Member.Member;
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
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Member user;

    @Column(name = "TYPE", columnDefinition = "ENUM('DOG', 'CAT') DEFAULT 'DOG'")
    @Enumerated(EnumType.STRING)
    private AnimalType type;

    @Column(name = "NAME", length = 20)
    private String name;
}

package com.side.anitime.domain.category;

import com.side.anitime.codeconst.ColorType;
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
@Table(name = "COLOR")
public class Color {

    @Id
    @Column(name = "COLOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colorId;

    @Column(name = "TYPE", columnDefinition = "")
    @Enumerated(EnumType.STRING)
    private ColorType type;

    @Column(name = "NAME", length = 10)
    private String name;

    @OneToOne
    @JoinColumn(name = "PLAN_ID")
    private Plan plan;

}

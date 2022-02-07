package com.side.anitime.domain.alarm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.plan.Plan;
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
@Table(name = "ALARM")
public class Alarm {

    @Id
    @Column(name = "ALARM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarmId;

    @Column(name = "TITLE", length = 50)
    private String title;

    @Column(name = "ALARM_YN", columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    @Enumerated(EnumType.STRING)
    private YesNo alarmYn;

//    @Column(name = "PLAN_ID")
//    private Long planId;

    @ManyToOne
    @JoinColumn(name = "PLAN_ID")
    private Plan plan;

    @Column(name = "TIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate time;
}

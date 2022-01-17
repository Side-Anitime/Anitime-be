package com.side.anitime.domain.alarm;

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
@Table(name = "ALARM")
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarmId;

    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
    @Enumerated(EnumType.STRING)
    private YesNo alarmYn;

    private Long planId; //TODO: plan과 primary key 설정, ManyToOne

    private LocalDate time;
}

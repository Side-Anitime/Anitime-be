package com.side.anitime.domain.setting;

import com.side.anitime.codeconst.KindType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="SETTING")
public class setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="setting_id")
    private Long id;

    @Column(name="kind")
    private KindType kindType;

    @Column(name="version")
    private String version;
}

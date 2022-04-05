package com.side.anitime.domain.setting;

import com.side.anitime.codeconst.OsType;
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
public class Setting {

    @Id
    @Column(name="SETTING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settingId;

    @Column(name="OS_TYPE")
    @Enumerated(EnumType.STRING)
    private OsType osType;

    @Column(name="VERSION")
    private String version;
}

package com.side.anitime.domain.user;

import com.side.anitime.codeconst.RoleType;
import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.common.BaseEntity;
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
@Table(name = "USER")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private String nickname;

    @Column(columnDefinition = "ENUM('ADMIN', 'USER', 'NONE') DEFAULT 'USER'")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Column(columnDefinition = "ENUM('Y', 'N') DEFAULT 'Y'")
    @Enumerated(EnumType.STRING)
    private YesNo accountStatus;

    @Column(length = 50)
    private String picture;

    //TODO: erd상 Role과 RoleType이 존재하는데 무슨 차이인지?
    //TODO: 발급 된 토큰을 저장할 필요가 있을까? 검증만 하면 되는 과정이기 때문에 추가 저장할 필요가 없어보인다. (stateless)
}

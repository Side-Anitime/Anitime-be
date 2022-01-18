package com.side.anitime.domain.user;

import com.side.anitime.codeconst.UserType;
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

    @Column(columnDefinition = "ENUM('NORMAL', 'NAVER', 'KAKAO', 'NON') DEFAULT 'NORMAL'")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(columnDefinition = "ENUM('Y', 'N') DEFAULT 'Y'")
    @Enumerated(EnumType.STRING)
    private YesNo accountStatus;

    @Column(length = 50)
    private String picture;

    @Column(length = 50)
    private String accessToken;

    //TODO: oauth 토큰 저장 후 네이버에서 들어왔는지 카카오에서 들어왔는지.. 소셜 정보에 대한 특정 id를 담을 column이 필요한가?
}

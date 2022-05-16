package com.side.anitime.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.common.BaseEntity;
import com.side.anitime.domain.pet.Pet;
import com.side.anitime.domain.plan.Plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "USER")
public class User extends BaseEntity {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // 일반 회원가입 토큰
    @Column(name = "USER_TOKEN", length = 50, unique = true)
    private String userToken;

    // oauth2 Token
    @Column(name = "ACCESS_TOKEN", length = 50)
    private String accessToken;

//    NOTE: User -> Category 1:N
//    @ManyToOne
//    @JoinColumn(name = "CATEGORY_ID")
//    private Category category;

    @OneToMany(mappedBy = "user")
    private List<Pet> pets = new ArrayList<>();

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "NICKNAME", length = 20)
    private String nickname;

    @Column(name = "PASSWORD", length = 20)
    private String password;

    @Column(name = "USER_TYPE", columnDefinition = "ENUM('NORMAL', 'NAVER', 'KAKAO', 'NON') DEFAULT 'NORMAL'")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "ACCOUNT_STATUS", columnDefinition = "ENUM('Y', 'N') DEFAULT 'Y'")
    @Enumerated(EnumType.STRING)
    private YesNo accountStatus;

    @Column(name = "PICTURE", length = 50)
    private String picture;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private List<Plan> plans = new ArrayList<>();

}

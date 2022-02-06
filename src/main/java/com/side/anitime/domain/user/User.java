package com.side.anitime.domain.user;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.category.Category;
import com.side.anitime.domain.common.BaseEntity;
import com.side.anitime.domain.pet.Pet;
import com.side.anitime.domain.plan.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

//    @Column(name = "CATEGORY_ID")
//    private Long categoryId;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    @Builder.Default
    private Category category;

    @OneToMany(mappedBy = "user")
    private List<Pet> pets = new ArrayList<>();

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "NICKNAME", length = 20)
    private String nickname;

    @Column(name = "USER_TYPE", columnDefinition = "ENUM('NORMAL', 'NAVER', 'KAKAO', 'NON') DEFAULT 'NORMAL'")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "ACCOUNT_STATUS", columnDefinition = "ENUM('Y', 'N') DEFAULT 'Y'")
    @Enumerated(EnumType.STRING)
    private YesNo accountStatus;

    @Column(name = "PICTURE", length = 50)
    private String picture;

    @Column(name = "ACCESS_TOKEN", length = 50)
    private String accessToken;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @Builder.Default
    private List<Plan> plans = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
//    @Builder.Default
//    private List<Pet> pets = new ArrayList<>();

    //TODO: oauth 토큰 저장 후 네이버에서 들어왔는지 카카오에서 들어왔는지 소셜 정보에 대한 특정 id 또는 index를 담을 column이 필요한가?
}

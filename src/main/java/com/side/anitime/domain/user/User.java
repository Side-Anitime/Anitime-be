package com.side.anitime.domain.user;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.common.BaseEntity;
import com.side.anitime.domain.pet.Pet;
import com.side.anitime.domain.plan.Plan;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "USER")
public class User extends BaseEntity implements UserDetails {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

//    NOTE: User -> Category 1:N
//    @ManyToOne
//    @JoinColumn(name = "CATEGORY_ID")
//    private Category category;

    @OneToMany(mappedBy = "user")
    private List<Pet> pets = new ArrayList<>();

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(length = 300, nullable = false)
    private String password;

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
    private List<Plan> plans = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //TODO: oauth 토큰 저장 후 네이버에서 들어왔는지 카카오에서 들어왔는지 소셜 정보에 대한 특정 id 또는 index를 담을 column이 필요한가?
}

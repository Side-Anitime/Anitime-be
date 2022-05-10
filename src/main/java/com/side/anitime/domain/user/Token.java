package com.side.anitime.domain.user;

import com.side.anitime.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Token extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "INIT_TOKEN")
    private String initToken;

    @Column(name = "PRIVATE_KEY")
    private String privateKey;

    @Column(name = "PUBLIC_KEY")
    private String publicKey;
}

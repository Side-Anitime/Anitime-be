package com.side.anitime.domain.user;

import com.side.anitime.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Token extends BaseEntity {

    @GeneratedValue
    private Long id;

    @Id
    @Column(name = "INIT_TOKEN")
    private String initToken;

    @Column(name = "PRIVATE_KEY")
    private String privateKey;

    @Column(name = "PUBLIC_KEY")
    private String publicKey;
}

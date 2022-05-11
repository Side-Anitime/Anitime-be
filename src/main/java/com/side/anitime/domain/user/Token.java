package com.side.anitime.domain.user;

import com.side.anitime.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Token extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOKEN_ID")
    private Long tokenId;

    @Column(name = "INIT_TOKEN")
    private String initToken;

    @Lob
    @Column(name = "PRIVATE_KEY")
    private String privateKey;

    @Lob
    @Column(name = "PUBLIC_KEY")
    private String publicKey;
}

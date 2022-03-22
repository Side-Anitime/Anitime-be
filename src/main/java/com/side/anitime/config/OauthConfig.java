package com.side.anitime.config;

import com.side.anitime.domain.user.oauth2.OauthProperties;
import com.side.anitime.dto.user.oauth2.OauthAdapter;
import com.side.anitime.dto.user.oauth2.OauthProvider;
import com.side.anitime.repository.user.oauth2.InMemoryProviderRepository;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableConfigurationProperties(OauthProperties.class)
public class OauthConfig {

    private final OauthProperties properties;

    public OauthConfig(OauthProperties properties) {
        this.properties = properties;
    }

    @Bean
    public InMemoryProviderRepository inMemoryProviderRepository() {
        Map<String, OauthProvider> providers = OauthAdapter.getOauthProviders(properties);
        return new InMemoryProviderRepository(providers);
    }

}

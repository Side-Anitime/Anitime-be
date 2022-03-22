package com.side.anitime.dto.user.oauth2;

import com.side.anitime.domain.user.oauth2.OauthProperties;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class OauthAdapter {

//    private OauthAdapter() {}
    // OauthProperties를 OauthProvider로 변환해준다.
    public static Map<String, OauthProvider> getOauthProviders(OauthProperties properties) {
        Map<String, OauthProvider> oauthProvider = new HashMap<>();

        properties.getUser().forEach((key, value) -> oauthProvider.put(key, new OauthProvider(value, properties.getProvider().get(key))));
        return oauthProvider;
    }
}

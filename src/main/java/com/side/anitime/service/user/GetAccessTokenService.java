package com.side.anitime.service.user;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GetAccessTokenService {
    public void getAccessToken(String authorizationCode){
        try{
            MyOkHttpClient.getAccessToken(authorizationCode);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

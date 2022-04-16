package com.side.anitime.config;

@EnableWebSecurity // 웹 보안 활성화
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtSecurityConfig jwtSecurityConfig;

    // password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers(
                        "/h2-console/**",
                        "/favicon.ico"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // token을 사용하는 방식이기 때문에 csrf를 disable
                .csrf().disable()

                // Exception을 핸들링할 때 직접 만든 클래스를 추가
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // enable h2-console
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                // 세션을 사용하지 않기 때문에 STATELESS로 설정
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/signup").permitAll()

                .anyRequest().authenticated() // 나머지는 인증 필요

                // JwtSecurityConfig 클래스 적용
                .and()
                .apply(jwtSecurityConfig);
    }
}

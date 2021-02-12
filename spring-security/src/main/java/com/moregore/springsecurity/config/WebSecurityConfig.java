package com.moregore.springsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN", "USER");
        auth.inMemoryAuthentication().withUser("sys").password("{noop}123").roles("SYS", "ADMIN", "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //권한 검사
                .antMatchers("/login").permitAll()
//                .antMatchers("/sho/login", "/shop/users/**").permitAll()
//                .antMatchers("/sho/mypage").hasRole("USER")
//                .antMatchers("/sho/admin/pay").access("hasRole('ADMIN')")
//                .antMatchers("/sho/admin/**").access("hasRole('ADMIN') or hasRole('SYS')")
//                설정 시 구체적인 경로가 먼저 오고 그것 봐 큰 범위의 경로가 뒤에 오도록 해야 한다.
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/admin/pay").hasRole("ADMIN")
                .antMatchers("/admin/**").access("hasRole('ADMIN') or hasRole('SYS')")
                .anyRequest().authenticated();

        http
                .formLogin()
//                .loginPage("/login")   // 사용자 정의 로그인 페이지
                .defaultSuccessUrl("/") // 로그인 성공 후 이동 페이지
                .failureUrl("/login")   // 로그인 실패 후 이동 페이지
                .usernameParameter("username")  // 아이디 파라미터명 설정
                .passwordParameter("password")  // 패스워드 파라미터명 설정
                .loginProcessingUrl("/login")   // 로그인 Form Action Url
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        log.debug("authentication {}", authentication.getName());
//                        response.sendRedirect("/");
                        RequestCache requestCache = new HttpSessionRequestCache();
                        SavedRequest savedRequest = requestCache.getRequest(request, response);
                        String redirectUrl = savedRequest.getRedirectUrl();
                        response.sendRedirect(redirectUrl);
                    }
                })  // 로그인 성공 후 핸들러
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        log.debug("exception {}", exception.getMessage());
                        response.sendRedirect("/login");
                    }
                })  // 로그인 실패 후 핸들러
                .permitAll();

        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID", "remember-me")
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
                        request.getSession().invalidate();
                    }
                })
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.sendRedirect("/login");
                    }
                })
                .deleteCookies("remember-me");

        http
                .rememberMe()
//                .rememberMeParameter("remember-me") //default : remember-me
                .tokenValiditySeconds(3600) //default : 14일
//                .alwaysRemember(true) //default : false, rememberMe 기능이 활성화되지 않아도 항상 실행
                .userDetailsService(userDetailsService);

        http
                .sessionManagement()
                .sessionFixation().changeSessionId() //default:changeSessionId, none, migrateSession, newSession
//                .invalidSessionUrl("/invalid") //세션이 유효하지 않을 때 이동 할 페이지, 우선순위: invalidSessionUrl > expiredUrl(expireUrl과 동시 존재할 경우 invalidSessionUrl만 실행)
                .maximumSessions(1) //최대 허용 가능 세션 수, -1:무제한 로그인 세션 허옹
                .maxSessionsPreventsLogin(false); //동시 로그인 차단함, false: 기존 세션 만료(default), true: 인증 요청 실패 처리
//                .expiredUrl("/expired"); //세션이 만료된 경우 이동 할

        http
                .exceptionHandling()
//                .authenticationEntryPoint(new AuthenticationEntryPoint() {
//                    @Override
//                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//                        response.sendRedirect("/login");
//                    }
//                }) //인증실패 시 처리
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                        response.sendRedirect("/denied");
                    }
                }) //인가실패 시 처리
        ;
    }

}

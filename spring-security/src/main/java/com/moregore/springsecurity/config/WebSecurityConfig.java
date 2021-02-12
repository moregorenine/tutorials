package com.moregore.springsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

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
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();

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
                        response.sendRedirect("/");
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
//                .expiredUrl("/expired"); //세션이 만료된 경우 이동 할 페이지
    }

}

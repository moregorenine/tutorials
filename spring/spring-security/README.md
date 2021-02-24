# spring security

## 스프링 시큐리티 기본 API 및 Filter 이해
### 1. formLogin()
### 2. logout()
### 3. rememberMe()
### 4. sessionManagement()
#### 4.1. 동시 세션 제어
#### 4.2. 세션 고정 보호
#### 4.3. 세션 정책
### 5. authorizeRequests()
#### 5.1. 권한설정과 표현식
### 6. 인증/인가 API, 예외 처리 및 요청 캐시 필터
#### 6.1. ExceptionTranslationFilter
#### 6.2. RequestCacheAwareFilter
### 7. Csrf Filter

## 스프링 시큐리티 주요 아키텍처 이해
### 1. DelegatingProxyChain, FilterChainProxy
### 2. 필터 초기화와 다중 보안 설정
- @Configuration 다중일 경우 @Order()로 순번 지정
### 3. Authentication
#### 3.1. SecurityContexHolder.getContext().getAuthentication()
- principal : 사용자 아이디 혹은 User 객체를 저장
- credentials : 사용자 비밀번호
- authorities : 인증된 사용자의 권한 목록
- details : 인증 부가 정보
- Authenticated : 인증 여부
### 4. SecurityContextHolder, SecurityContext
#### 4.1. SecurityContext
- Authentication 객체가 저장되는 보관소
- ThreadLocal 에 저장되어 아무 곳에서나 참조가 가능하도록 설계함
- 인증이 완료되면 HttpSession 에 저장되어 어플리케이션 전반에 걸쳐 전역적인 참조가 가능하다
#### 4.2. SecurityContextHolder
- SecurityContext 객체 저장 방식
  - MODE_THREADLOCAL : 스레드당 SecurityContext 객체를 할당, 기본값
  - MODE_INHERITABLETHREADLOCAL : 메인 스레드와 자식 스레드에 관하여 동일한 SecurityContext 를 유지
  - MODE_GLOBAL :  응용 프로그램에서 단 하나의 SecurityContext를 저장한다
- SecurityContextHolder.clearContext() : SecurityContext 기존 정보 초기화
### 5. SecurityContextPersistenceFilter
#### 5.1. SecurityContext 객체의 생성, 저장, 조회
#### 5.2. 익명 사용자
- 새로운 SecurityContext 객체를 생성하여 SecurityContextHolder 에 저장
- AnonymousAuthenticationFilter 에서 AnonymousAuthenticationToken 객체를 SecurityContext 에 저장
#### 5.3. 인증 시
- 새로운 SecurityContext 객체를 생성하여 SecurityContextHolder 에 저장
- UsernamePasswordAuthenticationFilter 에서 인증 성공 후 SecurityContext 에 UsernamePasswordAuthenticationToken 객체를 SecurityContext 에 저장
- 인증이 최종 완료되면 Session 에 SecurityContext 를 저장
#### 5.4. 인증 후
- Session 에서 SecurityContext 꺼내어 SecurityContextHolder 에서 저장
- SecurityContext 안에 Authentication 객체가 존재하면 계속 인증을 유지한다
#### 5.5. 최종 응답 시 공통
- SecurityContextHolder.clearContext()
### 6. Authentication Flow
- Client -> UsernamePassword AuthenticationFilter -> AuthenticationManager -> AuthenticationProvider -> UserDetailsService -> Repository  
### 7. AuthenticationManager
- AuthenticationProvider 목록 중에서 인증 처리 요건에 맞는 AuthenticationProvider 를 찾아 인증처리를 위임한다
- 부모 ProviderManager 를 설정하여  AuthenticationProvider 를 계속 탐색 할 수 있다


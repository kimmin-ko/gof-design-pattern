### 책임 연쇄 패턴 (Chain-of-Responsibility)
> 요청을 보내는 쪽(sender/client)과 요청을 처리하는 쪽(receiver/server)을 분리하는 패턴

- 핸들러 체인을 사용해서 요청을 처리한다.

#### 장점
- 클라이언트 코드를 변경하지 않고 새로운 핸들러를 체인에 추가할 수 있다. (데코레이션?)
- 각각의 체인은 자신의 책임이 명확해진다. 
- 다양한 체인을 다양한 방법으로 구성할 수 있다.

#### 단점
- 디버깅이 어렵다.

#### 사용 사례
- Filter
````java
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    // TODO 전처리
    chain.doFilter(request, response);
    // TODO 후처리
}
````
- WebSecurityConfigurerAdapter
````java
@Override
protected void configure(HttpSecurity http) throws Exception{
    http.authorizeRequests().anyRequest().permitAll().and()
        // 책임 연쇄 패턴이 적용된 필터 처리들
        .addFiter()
        .addFiterAt()
        .addFiterAfter()
        .addFiterBefore()
}
````


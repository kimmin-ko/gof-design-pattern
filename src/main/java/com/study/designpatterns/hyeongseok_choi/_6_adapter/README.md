# Structural Pattern

## 어댑터 (Adapter) 패턴

> 기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴

- 장점 : 클라이언트가 사용하는 인터페이스를 따르지 않는 기존 코드를 재사용할 수 있게 해준다.
- 대표적인 예시 : 콘센트 돼지코

![Adapter Pattern UML](Adapter_Pattern_UML.jpg)


### 예시

```java
// 여러 어플리케이션에서 공통으로 사용
//package com.study.designpatterns.hyeongseok_choi._6_adapter._01_before.security;

// 타겟
public interface UserDetailsService {
    UserDetails loadUser(String username);
}

// 타겟
public interface UserDetails {
    String getUsername();
    String getPassword();
}

// 클라이언트
public class LoginHandler {
    UserDetailsService userDetailsService;
//    ...
    public String login(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUser(username);
        if (userDetails.getPassword().equals(password)) {
            return userDetails.getUsername();
        } else {
            throw new IllegalArgumentException();
        }
    }
}

// 특정 어플리케이션에서만 사용
//package com.study.designpatterns.hyeongseok_choi._6_adapter._01_before;

// 어댑티
public class Account {
    private String name;
    private String password;
    private String email;
//    ...
}

// 어댑티
public class AccountService {

    public Account findAccountByUsername(String username) {
        Account account = new Account();
        account.setName(username);
        account.setPassword(username);
        account.setEmail(username);
        return account;
    }

    public void createNewAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }
}
```
- 로그인하는 프로그램 작성
  - *LoginHandler* 클래스의 *login()* 함수가 클라이언트
  - **여러 어플리케이션에서 공통**으로 사용 : *UserDetails*, *UserDetailsService*
  - **특정 어플리케이션에서만** 사용 : *Account*, *AccountService*
  - 어댑터에 해당하는 코드가 없는 상황


▼ (상호호환)

#### Option 1

```java
// 어댑터
public class AccountUserDetailsService implements UserDetailsService {

    private AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        return new AccountUserDetails(accountService.findAccountByUsername(username));
    }
}

// 어댑터
public class AccountUserDetails implements UserDetails {

    private Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public String getUsername() {
        return account.getName();
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }
}
```

- 기존에 있는 코드를 건드리지 않으면서 재사용성을 높임
  - 3rd Party 라이브러리와 같이 코드에 대한 수정 권한이 없을 때 사용

#### Option 2
```java
// implements 이용 기존 코드 수정
public class Account implements UserDetails {

    private String name;

    private String password;

    private String email;

    @Override
    public String getUsername() {
        return this.name;
    }
    
    @Override
    public String getPassword() {
        return password;
    } 
}

public class AccountService implements UserDetailsService {

    public Account findAccountByUsername(String username) {
        Account account = new Account();
        account.setName(username);
        account.setPassword(username);
        account.setEmail(username);
        return account;
    }

    @Override
    public UserDetails loadUser(String username) {
        return findAccountByUsername(username);
    }
}
```

- 장점
  - 추가적인 클래스를 만들지 않아도 됨
- 단점
  - 기존 코드에 대한 수정이 필요함
  - 단일책임 원칙(SRP)에 부적합함 (그러나 실용적일 경우에는 원칙을 고집할 필요 없음)

#### 정리

- 장점
  - 기존 코드를 그대로 유지하며, 우리가 원하는 타겟 인터페이스에 맞춰 구현체를 만들어 재사용성을 높여줌 : 개방폐쇄 원칙(OCP)
  - (1) 기존 코드가 하던 일, (2) 특정 인터페이스 구현체로 변환하는 작업을 각기 다른 클래스로 분리 가능 : 단일책임 원칙(SRP)
- 단점
  - 새 클래스가 생김으로 인해 복잡도 증가. 기존 코드를 직접 수정 가능하다면 수정하는 것도 좋은 방법.

#### 다른 곳에서는 어떻게 사용하나?

##### 자바
```java
// collections
List<String> strings = Arrays.asList("a", "b", "c"); // List → Collection
Enumeration<String> enumeration = Collections.enumeration(strings); // List → Enumeration
ArrayList<String> list = Collections.list(enumeration); // Enumeration → List

// io
try(InputStream is = new FileInputStream("input.txt"); // String → InputStream
    InputStreamReader isr = new InputStreamReader(is); // InputStream → InputStreamReader
    BufferedReader reader = new BufferedReader(isr)) { // InputStreamReader → BufferedReader
    while(reader.ready()) {
        System.out.println(reader.readLine());
    }
} catch (IOException e) {
    throw new RuntimeException(e);
}
```

##### 스프링

- 스프링 시큐리티
- 스프링 MVC : HandlerAdapter
- 
```java
@GetMapping("/hello") // RequestMappingHandlerAdapter : 자주 사용하는 핸들러. 이와 다른 다양한 형태의 핸들러가 있음
public string hello() {
    return "hi"
}

DispatcherServlet dispatcherServlet = new DispatcherServlet();
HandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();

public interface HandlerAdapter {
    @Nullable
    ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;
}
```
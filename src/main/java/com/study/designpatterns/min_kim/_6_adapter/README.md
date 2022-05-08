## 어댑터 패턴 (Adapter Pattern)

### 어댑터 패턴 정의

- 어댑터 패턴은 구조에 관련된 패턴 중 하나이다.
- 기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴이다.
- 다시 말하면, 클라이언트가 Target 인터페이스를 통해서 Adaptee 클래스의 인터페이스를 사용할 수 있도록 해주는 클래스가 Adapter이다.

![](../../../../../../resources/static/_6_adapter/adapter.png)

---

### 예제 코드 살펴보기

#### Target: UserDetails, UserDetailsService

- 클라이언트가 사용하는 Target 인터페이스이다.
- username과 password를 가져오는 인터페이스를 가지고 있는 UserDetails와 username으로 UserDetails를 조회할 수 있는 인터페이스를 가진 UserDetailsService가 있다.
- 애플리케이션 개발자는 Target을 구현해서 Target을 사용하는 Client에게 사용자 데이터를 제공해주어야 한다.

```java
public interface UserDetails {
    String getUsername();

    String getPassword();
}

public interface UserDetailsService {
    UserDetails loadUser(String username);
}
```

#### Client: LoginHandler

- 사용자가 입력한 username과 password를 이용해서 로그인을 시도하는 핸들러이다.
- 타겟에 해당되는 UserDetailsService의 loadUser() 인터페이스를 통해서 실제 애플리케이션의 사용자 데이터를 가져온다.
- UserDetails의 getPassword() 인터페이스를 통해서 저장된 사용자의 비밀번호와 사용자가 입력한 비밀번호를 비교해서 로그인한다.

```java
public class LoginHandler {

    private final UserDetailsService userDetailsService;

    public LoginHandler(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String login(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUser(username); // loadUser() 타겟 인터페이스

        if (userDetails.getPassword().equals(password)) { // getPassword() 타겟 인터페이스
            return userDetails.getUsername(); // getUsername() 타겟 인터페이스
        }

        throw new IllegalArgumentException();
    }
}
```

#### Adaptee: Account, AccountService

- 애플리케이션에 독립적인 사용자 엔티티와 사용자 서비스이다.
- Security 패키지는 다양한 애플리케이션에서 공통적으로 사용하지만 사용자 엔티티 및 서비스는 애플리케이션마다 구성이 다르기 때문에 LoginHandler에 사용자 데이터를 제공해주기 위해서는
  UserDetails와 UserDetailsService 인터페이스에 맞춰진 Adapter를 작성해야 한다.

```java
public class Account {

    private String username;

    private String password;

    private String email;

    public Account(String username) {
        this.username = username;
        this.password = username;
        this.email = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class AccountService {

    public Account findByUsername(String username) {
        return new Account(username);
    }
}
```

---

### 어댑터 패턴 적용하기

- 어댑터 패턴을 적용해서 LoginHandler의 코드 변경 없이 Account와 AccountService의 인터페이스를 이용해서 로직을 실행할 수 있도록해보자.
- 그러려면 두 개의 타겟 인터페이스를 구현한 다음의 두 개의 어댑터 클래스를 정의해야 한다.

#### Adapter: AccountUserDetails, AccountUserDetailsService

- AccountUserDetails는 UserDetails 인터페이스를 구현해서 LoginHandler에게 Account의 username과 password를 제공한다.
- AccountUserDetailsService는 UserDetailsService를 구현해서 LoginHandler에게 username으로 Account를 조회할 수 있는 기능을 제공한다.

```java
public class AccountUserDetails implements UserDetails {

    private final Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }
}

public class AccountUserDetailsService implements UserDetailsService {

    private final AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
```

- 결과적으로 어댑터 패턴을 적용해서 security 패키지의 공통적인 코드와 애플리케이션에 독립적인 코드가 연결되었다. 

---

### 어댑터 패턴 장단점

- 장점
    - 기존 코드를 변경하지 않고 원하는 인터페이스 구현체를 만들어서 재사용할 수 있다. -> 개방 폐쇄 원칙을 충족한다.
    - 기존 코드(Adaptee)가 하던 일과 특정 인터페이스(Target)의 구현체로 변환하는 작업을 각기 다른 클래스(Adapter)로 분리하여 관리할 수 있다. -> 단일 책임 원칙을 충족한다.
- 단점
    - 어댑터라는 새 클래스가 생겨서 복잡도가 증가할 수 있다.
        - 이것에 대한 대안으로 개발자가 Adaptee 클래스를 직접 수정할 수 있다면, Target 인터페이스를 직접 구현해서 복잡도를 낮출 수 있다.
        - 하지만 이 방법을 단일 책임 원칙에 위반하는 문제가 있기 때문에 개발자가 장단점을 고려해서 상황에 맞게 설계해야 한다.

---

### 자바와 스프링에서 찾아보는 어댑터 패턴

- java.util.Arrays#asList(T…)
    - String[] 클래스가 Arrays.asList() 어댑터를 통해서 클라이언트가 사용하는 List\<String>로 변환되었다.

```java
public class AdapterInJava {

    public static void main(String[] args) {
        // target -> List<String>
        // adapter -> Arrays.asList()
        // adaptee -> String[]
        String[] adaptee = {"a", "b", "c"};
        List<String> target = Arrays.asList(adaptee);
    }
}
```

- java.io.FileInputStream(String)
  - "input.txt"라는 문자열이 FileInputStream(String) 어댑터를 통해서 클라이언트가 사용하는 InputStream으로 변환되었다.

```java
public class AdapterInJava {
    public static void main(String[] args) {

        try (InputStream is = new FileInputStream("input.txt");
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr)) {

            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

- org.springframework.web.servlet.HandlerAdapter
  - 어댑터 패턴 관점의 Spring MVC 구성
    - Client: DispatcherServlet
    - Target: HandlerAdapter
    - Adapter: RequestMappingHandlerAdapter 등 HandlerAdapter 구현체들
    - Adaptee: 애플리케이션 컨트롤러 내의 각 핸들러
  - DispatcherServlet은 HandlerAdapter의 handle() 인터페이스를 통해서 ModelAndView 인스턴스를 반환받는다.
  - HandlerAdapter를 구현한 실제 Adapter 구현체는 HandlerMapping에서 찾은 handler를 실제로 호출한다.
  - 실제 로직은 Adaptee인 애플리케이션 컨트롤러 내의 각 핸들러가 처리한다.

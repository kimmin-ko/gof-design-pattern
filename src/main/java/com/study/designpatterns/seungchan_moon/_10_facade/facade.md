### 퍼사드 패턴
> 퍼사드 패턴의 Facade 는 "건물의 정면"을 의미한다. 퍼사드는 클래스 라이브러리 같은 어떤 소프트웨어의 다른 커다란 코드 부분에 대한 간략화된 인터페이스를 제공하는 객체이다.

- 복잡한 서브 시스템 의존성을 최소화하는 방법이다.
- 클라이언트가 사용해야 하는 복잡한 서브 시스템 의존성을간단한 인터페이스로 추상화 할 수 있다.

#### 장점
- 서브 시스템에 대한 의존성을 한곳으로 모으고 관리 할 수 있다.
- 재사용 될 객체를 생성해 중복코드를 방지한다.
- 클라이언트에 로직에서 서버의 내부 로직을 숨길 수 있다.

#### 단점
- 퍼사드 클래스가 서브 시스템에 대한 모든 의존성을 가지게 된다.

#### 사용 사례

```java
MailSender mailSender = new JavaMailSenderImpl();

PlatformTransactionManager platformTransactionManager = new JdbcTransactionManager();
```
- 클라이언트는 인터페이스를 사용하고 구현체는 퍼사드 객체 뒤로 숨겼다.
  - JavaMailSenderImpl.class
  - JdbcTransactionManager.class
- Spring MVC

# Structural Pattern

## 브릿지 (Bridge) 패턴

> 추상적인 것과 구체적인 것을 분리하여 연결하는 패턴

- 장점 : 하나의 계층 구조보다 각기 나누면 독립적인 계층 구조로 발전 시킬 수 있음

![Bridge Pattern UML](Bridge_Pattern_UML.jpg)


### 예시
- 게임 프로그램
- 다양한 챔피언, 스킨, 액션들이 계층구조로 분리되어 있지 않다면 무척 복잡해질 것임


```java
public interface Champion extends Skin {

    void move();

    void skillQ();

    void skillW();

    void skillE();

    void skillR();

}

public class KDA아리 implements Champion {

    @Override
    public void move() {
        System.out.println("KDA 아리 move");
    }
//    ...
}

// 스킨을 다양하게 추가할 때
public class PoolParty아리 implements Champion {

    @Override
    public void move() {
        System.out.println("PoolParty move");
    }
//    ...
}

// 챔피언을 다양하게 추가할 때
public class KDA아칼리 {
}

// 실행 방법
public static void main(String[] args) {
    Champion kda아리 = new KDA아리();
    kda아리.skillQ();
    kda아리.skillR();
}
```

▼

```java
// Champion을 상속받는 DefaultChampion 클래스 생성
public class DefaultChampion implements Champion {

    private Skin skin;

    private String name;

//    ...

    @Override
    public void move() {
        System.out.printf("%s %s move\n", skin.getName(), this.name);
    }
//    ...
}

// 스킨 인터페이스 추가
public interface Skin {
    String getName();
}

// 챔피언을 늘리고 싶다면 DefaultChampion을 상속받아 구현하면 됨. 스킨과 분리된 코드
// Refined Abstraction
public class 아리 extends DefaultChampion {

    public 아리(Skin skin) {
        super(skin, "아리");
    }
}

// 스킨을 늘리고 싶다면 Skin을 구현하면 됨. 챔피언과 분리된 코드
public class PoolParty implements Skin {
    @Override
    public String getName() {
        return "PoolParty";
    }
}

// 실행 방법
public static void main(String[] args) {
    Champion kda아리 = new 아리(new KDA());
    kda아리.skillQ();
    kda아리.skillW();

    Champion poolParty아리 = new 아리(new PoolParty());
    poolParty아리.skillR();
    poolParty아리.skillW();
}
```

- 클라이언트는 추상화된 계층 구조만을 이용하면 됨

#### 정리
> 추상적인 것과 구체적인 것을 분리하여 연결하는 패턴
- 장점
    - 추상적인 코드를 구체적인 코드 변경 없이도 독립적으로 확장 가능 : 개방폐쇄 원칙(OCP)
    - 추상적인 코드와 구체적인 코드를 분리 : 단일책임 원칙(SRP)
    - → 재사용성을 높이고 중복 코드를 줄임
- 단점
    - 계층 구조가 늘어나므로 복잡도 증가
    
#### 다른 곳에서는 어떻게 사용하나?
 
##### 자바
- JDBC
    - JDBC의 다른 부분이 바뀌지 않으면서도 새로운 DB를 만들어 연결할 수 있음
```java
public class JdbcExample {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName ("org.h2.Driver"); // 구체적인 부분

        try (Connection conn = DriverManager.getConnection ("jdbc:h2:mem:~/test", "sa","")) { // 추상화된 부분

            String sql =  "CREATE TABLE  ACCOUNT " +
                    "(id INTEGER not NULL, " +
                    " email VARCHAR(255), " +
                    " password VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";

            Statement statement = conn.createStatement();
            statement.execute(sql);

//            PreparedStatement statement1 = conn.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

- SLF4J
    - 어떤 로거 구현체를 사용하든 *LoggerFactory*, *logger* 는 바뀌지 않음
```java
public class Slf4jExample {

    private static Logger logger = LoggerFactory.getLogger(Slf4jExample.class);

    public static void main(String[] args) {
        logger.info("hello logger");
    }
}
```

##### 스프링

```java
public class BridgeInSpring {

    public static void main(String[] args) {
        MailSender mailSender = new JavaMailSenderImpl();

        PlatformTransactionManager platformTransactionManager = new JdbcTransactionManager();
    }
}
```
- 구체적인 구현체를 추상화 해둔 부분 : MailSender, PlatformTransactionManager
- 구현체 : JavaMailSenderImpl, JdbcTransactionManager
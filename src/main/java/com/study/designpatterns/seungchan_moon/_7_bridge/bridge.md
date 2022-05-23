### 브릿지 패턴
> 추상적인 것과 구체적인 것을 분리하여 연결하는 패턴

- 하나의 계층 구조일 때 보다 각기 나누었을 때 독립적인 계층 구조로 발전 시킬 수 있다.

#### 장점
- 추상적인 코드를 구체적인 코드 변경 없이도 독립적으로 확장할 수 있다. (OCP)
- 추상적인 코드와 구체적인 코드를 분리할 수 있다. (SRP)

중복 코드를 줄이고 재사용 가능한 코드를 유지할 수 있다.

#### 단점
- 게층 구조가 늘어나 복잡도가 증가할 수 있다.

#### 사용 사례

```java
public class JdbcExample {
    public static void main(String[] args) throws ClassNotFoundException {
        // 브릿지의 구체적인 곳이다. (org.h2.Driver)
        Class.forName("org.h2.Driver"); 

        // 브릿지의 추상화쪽에 해당한다. 
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {
            String sql = "CREATE TABLE ACCOUNT" +
                    "(id INTEGER NOT NULL , " +
                    "email VARCHAR(255), " +
                    "password VARCHAR(255), " +
                    "PRIMARY KEY (id)" +
                    ")";

            Statement statement = connection.createStatement();
            statement.execute(sql);

//            PreparedStatement statement1 = connection.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

```

+ DB가 변경되어도 DriverManager.getConnection 코드는 바뀌지 않는다. (추상화된 부분)
+ org.h2.Driver 는 h2 DB를 사용하기 위한 드라이버이다. (구체적인 부분)

````java
private static Logger logger = LoggerFactory.getLogger(Slf4jExample.class);
````

+ 관점의 차이는 있지만 (추상팩토리 같은..?) 브릿지 패턴으로 볼 수 있다.

````java
MaillSender mailSender = new javaMailSenderImpl();
PlatformTransactionManager pt = new JdbcTransactionManager();
````

+ MaillSender, PlatformTransactionManager 추상 인터페이스
+ javaMailSenderImpl, JdbcTransactionManager 구현체
## 책임 연쇄 패턴 (Chain-of-responsibility pattern)

### 책임 연쇄 패턴 정의

- 요청을 보내는 쪽과 요청을 처리하는 쪽을 분리하는 패턴이다.
- 하나의 책임을 가지고 있는 클래스들이 연결되어서 특정한 요청을 연쇄적으로 처리하도록 구성한다.
- 요청을 보내는 쪽은 요청을 처리하는 핸들러가 어떤 구체적인 클래스인지 알 필요 없이 디커플링된 상태에서 요청을 처리할 수 있도록 해준다.

---

### 책임 연쇄 패턴 적용하기 전

- 클라이언트가 서버에 요청을 보내면 서버는 요청 핸들러를 통해서 요청을 처리한다.
- 요청 핸들러는 요청 본문을 출력하는 간단한 로직을 처리한다.

```java
public class Client {

    public static void main(String[] args) {
        Request request = new Request("무궁화 꽃이 피었습니다.");

        RequestHandler requestHandler = new RequestHandler();
        requestHandler.handle(request);
    }
}

public class RequestHandler {

    public void handle(Request request) {
        System.out.println(request.getBody());
    }
}
```

- 해당 요청을 처리할 때 클라이언트에 대한 인증 및 인가 처리가 이루어져야 한다면??
- 가장 간단한 방법으로 요청 핸들러 내부에서 인증 및 인가 처리를 진행한다.
    - 하지만 이 방법은 요청 핸들러의 단일 책임 원칙을 위반한다.

```java
public class RequestHandler {

    public void handle(Request request) {
        System.out.println("[인증] 사용자가 해당 서비스에 접근할 권한이 있는가?");
        System.out.println("[인가] 인증된 사용자가 해당 요청을 처리할 권한이 있는가?");
        System.out.println(request.getBody());
    }
}
```

- 단일 책임 원칙을 위반하는 문제를 해결하기 위해서 요청 핸들러를 확장한 인증 요청 핸들러를 구현한다.
- 그리고 만약에 해당 요청에 대해 로깅 처리가 추가 되어야 한다면?
    - 클라이언트는 로깅 요청 핸들러에 추가적으로 메시지를 전달해야 한다.

```java
public class AuthRequestHandler extends RequestHandler {

    @Override
    public void handle(Request request) {
        System.out.println("[인증] 사용자가 해당 서비스에 접근할 권한이 있는가?");
        System.out.println("[인가] 인증된 사용자가 해당 요청을 처리할 권한이 있는가?");
        super.handle(request);
    }
}

public class Client {

    public static void main(String[] args) {
        Request request = new Request("무궁화 꽃이 피었습니다.");

        RequestHandler authRequestHandler = new AuthRequestHandler();
        authRequestHandler.handle(request);

        RequestHandler loggingRequestHandler = new LoggingRequestHandler();
        loggingRequestHandler.handle(request);
    }
}
```

### 책임 연쇄 패턴 적용해서 개선하기

- 추상 클래스인 요청 핸들러는 멤버 변수로 다음 요청 핸들러의 인스턴스를 참조하고 있다.
- 추상 클래스의 handle 메서드는 요청을 직접 처리하는 대신 다음 요청 핸들러에게 연쇄적으로 요청을 전달하는 역할을 한다.

```java
public abstract class RequestHandler {

    private final RequestHandler chain;

    RequestHandler(RequestHandler chain) {
        this.chain = chain;
    }

    public void handle(Request request) {
        if (Objects.isNull(this.chain)) {
            return;
        }

        this.chain.handle(request);
    }
}
```

- 하나의 요청에 대해 다양한 처리를 하고 싶다면, 추상 클래스를 확장해서 handle 메서드를 오버라이딩한다.
- 예를 들어 요청을 처리하기 전에 인증 및 인가 처리를 해야한다면, AuthRequestHandler에서는 인증 인가 로직을 구현하고, 다음 핸들러에게 요청을 전달합니다.

```java
public class AuthRequestHandler extends RequestHandler {

    public AuthRequestHandler(RequestHandler chain) {
        super(chain);
    }

    @Override
    public void handle(Request request) {
        System.out.println("인증");
        System.out.println("인가");
        super.handle(request);
    }
}
```

- 애플리케이션을 실행할 때 요청 핸들러를 생성할 때 다음 요청 핸들러 인스턴스를 주입하면, 책임 연쇄 패턴을 통해서 클라이언트 입장에서는 하나의 인스턴스에 메세지를 보내지만 요청에 대한 인증, 로깅, 출력 처리를 기대할 수 있습니다.

```java
public class App {

    public static void main(String[] args) {
        RequestHandler requestHandler = new AuthRequestHandler(new LoggingRequestHandler(new PrintRequestHandler(null)));

        Client client = new Client(requestHandler);
        client.doWork();
    }
}

public class Client {

    private final RequestHandler requestHandler;

    public Client(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void doWork() {
        Request request = new Request("이번 놀이는 뽑기입니다.");
        requestHandler.handle(request);
    }
}
```

---

### 책임 연쇄 패턴 장단점

- 장점
  - 클라이언트 코드를 변경하지 않고 체인을 추가하거나 순서를 변경할 수 있다.
- 단점
  - 디버깅이 조금 어렵다.
## 커맨드 패턴 (Command pattern)

### 커맨드 패턴 정의

- 요청을 캡슐화해서 호출자(invoker)와 수신자(receiver)를 분리하는 패턴이다.
- 요청을 처리하는 코드가 바뀌어도 호출자의 코드는 변경되지 않는다.

---

### 커맨드 패턴 적용 전 예제

- 불(receiver)을 켜고 끌 수 있는 버튼이 있다고 가정할 때, 버튼(invoker)은 press라는 하나의 기능이 있다.
- press를 호출하여 불을 끄고 싶다면 press 내부 로직을 light.off()로 변경 해줘야 하는 문제가 발생한다.
- 또한 Light의 off 메서드 이름이 turnOff로 변경된다면 호출자의 코드도 변경된다는 문제가 발생한다.

```java
public class Button {

    private final Light light;

    public Button(Light light) {
        this.light = light;
    }

    public void press() {
        light.on();
    }

    public static void main(String[] args) {
        Button button = new Button(new Light());
        button.press(); // 불은 켠다
        button.press(); // 불은 끈다
    }
}
```

- 또 다른 경우로 버튼을 눌렀을 때 불을 켜는 기능이 아니라 게임을 시작하는 기능도 할 수 있다고 가정하자.
- 그럴 경우 버튼 클래스의 내부 구현을 불을 켜는 기능 대신 게임을 시작하는 기능으로 변경해야 한다.

```java
public class Button {

    private final Game game;

    public Button(Game game) {
        this.game = game;
    }

    public void press() {
        game.start();
    }

    public static void main(String[] args) {
        Button button = new Button(new Game());
        button.press();
        button.press();
    }
}
```

### 커맨드 패턴을 적용해서 문제점 개선

- 먼저 수신자의 기능을 추상화 한 Command 인터페이스를 정의한다.
- 호출자는 Command 인터페이스의 단일 메서드를 통해서 주입되는 Command 구현체에 따라서 불을 켜고 끔과 게임 시작과 종료를 실행할 수 있다.

```java
public interface Command {
    void execute();
}

public class Button {

    private final Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute(); // 모든 기능 수행 가능
    }
}
```

- 만약에 수신자의 동작 방법이 변경된다고 해도 Command 구현체의 코드만 변경될 뿐 호출자에게는 영향이 가지 않는다.
- 아래 코드를 예로 들면 Light 클래스의 off 메서드가 turnOff로 변경되어도 LightOffCommand 클래스의 코드에만 영향이 갈 뿐이고, 이 기능을 사용하는 다중 클라이언트는 변경되지 않는다.

```java
public class LightOffCommand implements Command {

    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off(); // 해당 부분만 변경됨
    }
}
```

---

### 커맨드 패턴의 장점과 단점

- 장점
  - 기존 코드를 변경하지 않고 새로운 커맨드를 만들 수 있다.
  - 수신자의 코드가 변경되어도 호출자의 코드는 변경되지 않는다.
  - 커맨드 객체를 로깅, DB에 저장, 네트워크로 전송 하는 등 다양한 방법으로 활용할 수도 있다.
- 단점
  - 코드가 복잡하고 클래스가 많아진다.
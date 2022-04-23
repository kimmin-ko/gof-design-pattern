### 추상 팩토리 (Abstract Factory)

서로 관련있는 여러 객체를 만들어주는 인터페이스 

펙토리 메소드 패턴과 비슷하다.

```java
// 추상펙토리 
public interface ShipPartsFactory {
    
    Anchor createAnchor();
    
    Whell createWheel();
}

public class whiteshipPartsFactory implements ShipPartsFactory {
    
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }
    
    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
```

단일책임원칙을 지켰다고 볼 수도 있지만. 또 다른 한편으로는 해당 클래스에서 여러가즈 객체를 생성하다보니
단일책임원칙을 위반한게아니냐는 주장도 나뉘고있다.

### 장점과 단점 

#### 추상 펙토리 패턴은 일반 팩토리 메서드와 비슷하지만 관점이 다르다.
 - 팩토리 메소드 패턴은 팩토리를 구현하는 방법에 초점을 둔다.
 - 추상 팩토리 패턴은 팩토리를 사용하는 방법에 초점을 둔다.

#### 목적이 다르다.
 - 팩토리 메소드 패턴은 구체적인 객체 생성 과정을 하위 또는 구체적인 클래스로 옮기는것이 목적
 - 추상 팩토리 패턴은 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는것이 목적.

---

### 실제 실무 에서는 어떻게 쓰이고 있는가
 - `DocumentBuilderFactory`, `FactoryBean`
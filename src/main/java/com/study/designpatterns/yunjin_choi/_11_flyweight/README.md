## 플라이웨이트 패턴 ( Fly Weight Pattern )

---

> 플라이 웨이트 패턴이란 객체를 가볍게 만들어 메모리 사용을 줄이는 패턴을 의미한다.
> 
> 자주 사용하는 속성과 변하지 않는 속성을 분리하고 재사용하여 메모리 사용을 줄일 수 있다.

주의사항은 플라이웨이트 패턴 코드 작성시 코드들은 주관적이고 상황에따라 다르기 때문에 정답이 있지 않고
도메인의 특성에 마젝 적용하면된다.

---

공통으로 묶고자하는 데이터들은 플라이웨이트객체 인스턴스로 취급하여 생성한다. 다만 플라이웨이트 객체 인스턴스로 처리시 주의해야할 점은
플라이웨이트 객체는 불변성을 가져야한다. Immutable하지 못하다면 다른데이터도 공유하게되기때문에다른 객체에도 영향을 줄 수 있기대문에 Immutable하게 구성한다.
불변 
final 키워드를 사용하고 생성자로만 생성하게하고 Getter만 열어둔다. 또한 상속을 막기위해 class에도 final 을 붙여줘 Immutable하게 만든다

```java
public final class Font {
  private String fontSize;
  private String fontColor;
  
  public Font(String fontSize, String fontColor) {
    this.fontSize = fontSize;
    this.fontColor = fontColor;
  }
}
```

---

Cache는 Map으로 구현

```java

public class FontFactory {
  private Map<String, font> cache = new HashMap<>();
  
  public Font getFont(String font) {
    if(cache.containsKey(font)) {
      return cachge.get(font);
    }
    
    String[] split = font.split(":");
    Font newFont = new Font(split[0], split[1]);
    cache.put(font, newFont);
    return newFont;
  }
}
```

---

플라이웨이트 패턴의 장단점<br>

>장점 - 애플리케이션에서 사용하는 공통적인 부분에 대해서 메모리를 아낄수 있다.<br>
> 
> 단점 - 구조적인면에서 좀 더 복잡하다.. 해당 패턴을 모르고 본다면 왜이렇게했는지 의문을 들 수 있다.

---

자바에서 플라이웨이트 패턴은 어디에 사용되고 있는가?

Java에서 Integer.valueOf와 같은 valueOf들을 예로 들 수 있다.

해당 valueOf를 찾아서 설명을 보면 내부적으로 -128 ~ 127까지의 값들은 Caching하는것으로 나와있다.

```java

Integer t1 = Integer.valueOf(100);
Integer t2 = Integer.valueOf(100);

System.out.println(t1 == t2); // true 출력
```

예로 들어 설명하였지만 == 보다는 equals를 사용하는것을 권장. 
# behavioral_patterns

## 플라이웨이트 패턴

- 객체를 가볍게 만들어 메모리 사용을 줄이는 패턴
- 자주 변하는 속성(extrinsit)과 자주 변하지 않는 속성(intrinsit)을 분리하여 재사용성을 높임

![UML](uml.png)
- Flyweight 객체는 immutable

### 예시
- 편집기 프로그램
```java
public class Client {

    public static void main(String[] args) {
        Character c1 = new Character('h', "white", "Nanum", 12);
        Character c2 = new Character('e', "white", "Nanum", 12);
        Character c3 = new Character('l', "white", "Nanum", 12);
        Character c4 = new Character('l', "white", "Nanum", 12);
        Character c5 = new Character('o', "white", "Nanum", 12);
    }
}
```
▼
```java
public final class Font { // Flyweight 객체 (immutable)

    final String family;

    final int size;

    public Font(String family, int size) {
        this.family = family;
        this.size = size;
    }

    public String getFamily() {
        return family;
    }

    public int getSize() {
        return size;
    }
}

public class Character {

    private char value;

    private String color;

    private Font font;

    public Character(char value, String color, Font font) {
        this.value = value;
        this.color = color;
        this.font = font;
    }
}

public class FontFactory { // Flyweight Factory

    private Map<String, Font> cache = new HashMap<>();

    public Font getFont(String font) {
        if (cache.containsKey(font)) {
            return cache.get(font);
        } else {
            String[] split = font.split(":");
            Font newFont = new Font(split[0], Integer.parseInt(split[1]));
            cache.put(font, newFont);
            return newFont;
        }
    }
}

public class Client {

    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        Character c1 = new Character('h', "white", fontFactory.getFont("nanum:12"));
        Character c2 = new Character('e', "white", fontFactory.getFont("nanum:12"));
        Character c3 = new Character('l', "white", fontFactory.getFont("nanum:12"));
    }
}
```

### 장점
- 애플리케이션에서 사용하는 메모리를 줄일 수 있음
    
### 단점
- 코드가 복잡해짐

### 자바와 스프링에서의 예시
- 자바
    - valueOf() 메서드
        ```java
        public class FlyweightInJava {
        
            public static void main(String[] args) {
                Integer i1 = Integer.valueOf(10); // 캐싱을 이용
                Integer i2 = Integer.valueOf(10);
                System.out.println(i1 == i2);
            }
        }
        ```
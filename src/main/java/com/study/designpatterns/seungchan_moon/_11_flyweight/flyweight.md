### 플라이웨이트 패턴
> 플라이웨이트 패턴는 동일하거나 유사한 객체들 사이에 가능한 많은 데이터를 서로 공유하여 사용하도록 하여 메모리 사용량을 최소화하는 소프트웨어 디자인 패턴이다

- 객체를 가볍게 만들어 메모리 사용을 줄이는 패턴
- 자주 변하는 속성(또는 외적인 속성, Extrinsit)과 변하지 않는 속성(또는 내적인 속성, Intrinsit)을 분리하고 재사용하여 메모리 사용을 줄일 수 있다.

#### 조건 
1. 공유하는 객체는 immutable 속성을 가져야 한다.
   - final 키워드 
````java
public final class Font {
    final String family;
    final int size;

    public Font(String family, int size) {
        this.family = family;
        this.size = size;
    }
}
````

#### 장점
- 애플리케이션에서 사용하는 메모리를 줄일 수 있다.


#### 단점
- 더 복잡한 생성 과정을 거치게 된다. (복잡도 증가)


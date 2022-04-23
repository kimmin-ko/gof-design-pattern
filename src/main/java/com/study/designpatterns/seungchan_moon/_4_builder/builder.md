
### 빌더 패턴
> 동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 방법

- 생성자에 인자를 강제하고 싶을 떄 (인스턴스를 안전한 상태로 구성하고 싶을 때)
- 장황한 생성자를 간소하기 하기 위해
- 복잡한 객체를 만드는 프로세스를 독립적으로 분리할 수 있음


#### 빌더 패턴을 사용한 생성자
```java
TourPlan plan = builder.title("일본 여행")
                .nightsAndDays(2, 3)
                .whereToStay("호텔")
                .addPlan(0, "체크인하고 짐 풀기")
                .addPlan(0, "저녁 식사")
                .getPlan();

TourPlan longBeachTrip = builder.title("롱비치")
        .startDate(LocalDate.of(2021, 7, 15))
        .getPlan();
```
##### 빌더를 사용하지 않았다면 ?
```java
TourPlan longBeachTrip = new TourPlan("롱비치", 0, null, null, ...)
```

#### 빌더 셋업
- [빌더 셋업(TourDirector)](./after/TourDirector.java)

````java
TourDirector director = new TourDirector(new DefaultTourBuilder());
TourPlan plan1 = director.japanTrip();
TourPlan plan2 = director.longBeachTrip();
````

#### 빌더 패턴의 장점과 단점

장점
- 객체를 만드는 순차적인 프로세스를 강제할 수 있다.
- 동일한 프로세스를 통해서 각기 다른 객체를 얻을 수 있다.
- 불안전한 객체를 생성못하게 강제할 수 있다.

단점
- Builder 나 셋업 객체가 필요하다. 
  - 구조가 복잡해진다.

#### 사용 사례
- StringBuilder, StringBuffer
- Stream.Builder
- Lombok
- UriComponents (초기화 후 사용)
- 
```java
public static UriComponentsBuilder newInstance() {
    return new UriComponentsBuilder();
}

protected UriComponentsBuilder() {
    this.pathBuilder = new CompositePathComponentsBuilder();   
}
```
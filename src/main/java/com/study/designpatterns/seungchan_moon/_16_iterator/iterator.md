### 이터레이터 패턴
> 집합 객체 내부 구조를 노출시키지 않고 순회하는 방법을 제공한다.

- 집합 객체를 순회하는 클라이언트 코드를 변경하지 않고 다양한 순회 방법을 제공할 수 있다.
```java
List<Post> posts = board.getPosts();
for (int i = 0; i < posts.size(); i++) {
    Post post = posts.get(i);
    System.out.println(post.getContent());
}
```
- 집합 객체의 내부 구현을 드러내지 않고 순회시킨다.

#### 애그리거트 이터레이터
```java
List<Post> posts = board.getPosts(); // List가 애그리거트에 해당한다.
Iterator<Post> iterator = posts.iterator(); // iterator 인터페이스
System.out.println(iterator.getClass());
// class java.util.ArrayList$Itr
// List<Post> 실제 구현체인 ArrayList 는 ConcreteAggregate 가  된다.
```


#### 장점

- 집합 객체가 가지고 있는 객체들에 손쉽게 접근할 수 있다.
- 일관된 인터페이스를 사용해 여러 형태의 집합 구조를 순회할 수 있다.

#### 단점

- 클래스가 늘어나고 복잡도가 증가 할 수 있다.

#### 사용 사례
- java.util.Enumeration 
- java.util.Iterator
- Java StAx 의 Iterator 기반 API
  - XmlEventReader, XmlEventWriter
  -  (성능보단 편의)
- 스프링
  - CompositeIterator

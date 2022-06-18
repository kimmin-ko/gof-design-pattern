# behavioral_patterns

## 이터레이터 패턴

- 집합 객체에서 내부 구조를 드러내지 않고 요소들을 순회하는 방법
    - ex) Iterator Interface
    
- AS-IS : 단순히 인덱스를 통해 요소들에 접근
    - 단점 : 순회하는 클라이언트가 하부 구조를 알게 됨
        - List → Set, Array 등 변경 시 영향이 생김


![UML](uml.png)
- Aggregate : List 인터페이스
- Iterator : Iterator 인터페이스
- ConcreteAggregate : ArrayList 클래스
- ConcreteIterator : ArrayListIterator 클래스

### 예시
- 최신 순으로 게시글(post)을 순회하는 코드
```java
class Client {
    void doSomething() {
        Collections.sort(posts, (p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime())); // 순회 조건에 따라 직접 정렬해야 함 
        for (int i = 0 ; i < posts.size() ; i++) { // 리스트 순회 코드를 작성해야 함
            Post post = posts.get(i);
            System.out.println(post.getTitle());
        }
    }
}
```
▼
```java
class Client {
    void doSomething() {
        Iterator<Post> recentPostIterator = board.getRecentPostIterator(); // 내부적으로 어떤 구조를 갖는지 신경 쓰지 않아도 됨
        while(recentPostIterator.hasNext()) {
            System.out.println(recentPostIterator.next().getTitle());
        }
    }
}
```

### 장점
- 집합객체를 손쉽게 사용할 수 있는 방법을 제공
    - 순회하는 방법만 알고, 내부 구조는 몰라도 됨 → 단일책임원칙
        - List, Set, Tree, Heap, Stack 등을 몰라도 됨
- 기존 코드의 큰 변경 없이 적용할 수 있음
    - 단, Aggregate 쪽에는 추가 변경이 발생함 (Iterator 를 제공해야 하므로)
        ```java
        class Aggregate {
            public Iterator<Post> getRecentPostIterator() {
                return new RecentPostIterator(this.posts);
            }
        
            public Iterator<Post> getOldPostIterator() {
                return new RecentOldIterator(this.posts);
            }
        }
        ```
        - 그래도 클라이언트에서 이터레이터를 주입받는 식으로 구성할 경우 클라이언트 측의 변경은 최소화 할 수 있음
            ```java
            class Client {
                private Iterator<Post> postIterator;
                public Client(Iterator<Post> postIterator){
                    this.postIterator = postIterator;
                }   
            }
            ```
          
### 단점
- 기존보다 구조가 복잡해짐
    - 다양한 방법으로 순회가 필요하고, 내부 집합객체 구조가 변경될 가능성이 있을 경우에 적용하자 

### 자바와 스프링에서의 예시
- 자바
    - Enumeration (레거시) / Iterator
    - StAX (Streaming API for XML)의 Iterator 기반 API (콘솔 기반 API 도 제공함)
        - XmlEventReader, XmlEventWriter
- 스프링
    - CompositeIterator (언제 필요할까?)

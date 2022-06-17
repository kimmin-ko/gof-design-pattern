### 중재자(Mediator) 패턴
> 여러 객체들이 소통하는 방법을 캡슐화하는 패턴이다.

- 연예인 매니저라고 생각하면 편하다.
- 여러 컴포넌트간의 결합도를 중재자를 통해 낮출 수 있다.

#### 장점

- 컴포넌트 코드를 변경하지 않고 새로운 중재자를 만들어 사용할 수 있다.
- 각각의 컴포넌트 코드를 보다 간결하게 유지할 수 있다.

#### 단점
- 중재자 역할을 하는 클래스의 복잡도와 결합도가 증가한다.
- 모든 의존성이 메디에이터 한 곳으로 몰린다.

#### 사용 사례 
- java
  - ExecutorService
  - Executor
- 스프링
  - DispatcherServlet
  - ApplicationContext 가 중재자라면.. 
    - EnvironmentCapable,
    - ListableBeanFactory, 
    - HierarchicalBeanFactory, 
    - MessageSource, 
    - ApplicationEventPublisher, 
    - ResourcePatternResolver
  - 와 같은 기능들을 한곳에서 확장하고 재사용하기 좋다.

### 프록시 패턴
> 일반적으로 프록시는 다른 무언가와 이어지는 인터페이스의 역할을 하는 클래스이다. 프록시는 어떠한 것과도 인터페이스의 역할을 수행할 수 있다. 프록시 패턴의 잘 알려진 예로는 참조 횟수 스마트 포인터 객체이다

- 특정 객체에 대한 접근을 제어하거나 기능을 추가할 수 있는 패턴
- 초기화 지연, 접근 제어, 로깅, 캐싱 등 다양하게 응용해 사용할 수 있다.


#### 장점
- 기존 코드를 변경하지 않고 새로운 기능을 추가할 수 있다.
- 기존 코드의 책임이 변하지 않는다.
- 기능 추가 및 초기화 지연 등으로 다양하게 활용할 수 있다.

#### 단점
- 코드의 복잡도가 증가한다.

#### 사용 사례

- Dynamic Proxy (java)
  - java.lang.reflect.Proxy
````java
private GameService getGameServiceProxy(DefaultGameService target) {
    return (GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
            new Class[]{GameService.class}, (new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("Hello dynamic proxy");
                    method.invoke(target, args);
                    return null;
                }
            }));
}
````
- AOP
  - @Transactional
  - @Cacheable
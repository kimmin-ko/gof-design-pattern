## 프록시 패턴 ( Proxy Pattern )

---

> 클라이언트가 원래 사용하려던 객체들을 직접 참조해서 쓰는게 아니라 Proxy라는 대리인을 통해서 참조하여 사용하는 디자인 패턴을 의미
> 
> 초기화 지연, 접근 제어, 로깅, 캐싱등 다양하게 응용하여 사용할 수 있다.



---

프록시 패턴의 장단점

장점 
 - 기존 코드를 변경하지 않고 새로운 Proxy class 생성을 통해 기존 기능의 확장이 가능하다.
 - 기능 추가 및 초기화 지연등으로 다양하게 활용할 수 있다.
 - 사이즈가 큰 객체가 로딩되기 전에도 프록시를 통해 참조를 할 수 있다.


단점

 - 코드의 복잡도가 증가하여, 가독성이 떨어질 수 있다.
 - 객체를 생성할 때 한 단계를 더 거치게 되므로, 빈번한 객체 생성이 필요한 경우에는 성능이 저하할 수 있다.
 - 


---

프록시 패튼을 자바와 스프링에서 어디서 쓰고있을까 ?

자바에서는 다이나믹 프록시, java.lang.reflect.Proxy, 스프링에서는 AOP에서 사용하고 있다.

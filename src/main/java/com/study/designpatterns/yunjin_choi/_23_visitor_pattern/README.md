> ### 행동 관련 디자인 패턴

## 방문자 패턴 ( Visitor Pattern )

---

기존 코드를 변경하지 않고 새로운 기능을 추가하는 방법. 

 - 더블 디스패치 (Double Dispatch)를 활용할 수 있다.

![img.png](img.png)


### ⭐ Visitor
> 강의 에서 나오는 Device interface 를 의미 

### ⭐ ConcreteVisitor
> Phone, Watch와 같은 Device interface를 상속받아서 구현한 클래스를 의미.


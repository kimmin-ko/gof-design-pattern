
### 프로토타입 패턴
> 기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법

- 복제 기능을 갖추고 있는 기존 인스턴스를 프로토타입으로 사용해 새 인스턴스를 만들 수 있다.
- 인스턴스를 만들 때  동일한 작업을 반복하지 않아도 된다. 
  - 특히나 복잡하거나, 리소스 소모가 심한 작업에 적합하다.

clone 메소드 번역

```
/**
* 이 개체의 복사본을 만들고 반환합니다. 정확한 의미는
* "복사"의 값은 객체의 클래스에 따라 달라질 수 있습니다. 장군
* 의도는 {@codex} 개체에 대해 다음과 같은 식입니다.
* <block >
* <사전>
* x.clone argets != x/pre> </block quote>
* 이 표현은 참이 될 것입니다.
* <block >
* <사전>
* x.clone().getClass() == x.getClass()</pre></blockquote>
* {@code true}이(가) 되겠지만 절대 요구 사항은 아닙니다.
* 일반적으로 다음과 같은 경우가 있다.
* <block >
* <사전>
* x.clone().clone(x)</pre></block quote>
* {@code true}이(가) 됩니다. 이는 절대 요구 사항이 아닙니다.
* p
* 관례에 따라 반환된 객체는 호출을 통해 획득해야 합니다.
* {@code super.clone}입니다. 클래스 및 모든 슈퍼 클래스(제외)
* {@codeObject}은(는) 이 규칙을 준수하며 다음과 같은 경우에 해당합니다.
* {@code x.clone().getClass() == x.getClass()}.
* p
* 관례상 이 메서드에 의해 반환되는 오브젝트는 독립적이어야 합니다.
* 이 개체(복제 중인 개체)를 선택합니다. 이 독립을 이루기 위해서는
* 반환된 개체의 필드를 하나 이상 수정해야 할 수 있습니다.
* 반환하기 전에 {@code super.clone}을(를) 사용하십시오. 일반적으로, 이것은 다음을 의미한다.
* 내부 "심층 구조"를 구성하는 모든 가변 객체 복사
* 복제되는 물체에 대한 참조를 대체하고 있습니다.
* 복사본에 대한 참조가 있는 객체 클래스에 다음만 포함된 경우
* 원시 필드 또는 불변 객체에 대한 참조, 그리고 그것은 보통
* {@code super.clone}에서 반환된 개체의 필드가 없는 경우
* 수정이 필요합니다.
* p
* 클래스 {@codeObject}에 대한 {@codeclone} 메서드가 다음 작업을 수행합니다.
* 특정 복제 작업입니다. 첫째, 만약 이 객체의 클래스가
* 인터페이스 {@code Cloneable}을(를) 구현하지 않은 경우,
* {@code 클론 지원되지 않음예외}이(가) 느려졌습니다. 모든 배열은
* {@codeCloneable} 인터페이스를 구현하는 것으로 간주됩니다.
* 어레이 유형 {@codeT[]의 {@codeclone} 메서드의 반환 유형
* 는 {@code T[]}이며, 여기서 T는 참조 또는 원시 유형입니다.
* 그렇지 않으면 이 메서드는 이 클래스의 새 인스턴스를 만듭니다.
* 정확한 내용으로 모든 필드를 오브젝트하고 초기화합니다.
* 할당과 같은 이 객체의 해당 필드
* 필드의 내용은 복제되지 않습니다. 따라서 이 방법은
* 에서는 이 개체에 대해 "deep copy" 작업이 아닌 "deep copy" 작업을 수행합니다.
* p
* {@codeObject} 클래스가 자체적으로 인터페이스를 구현하지 않음
* 개체에서 {@codeClone} 메서드를 호출하는 {@codeCloneable}
* 클래스가 {@codeObject}인 경우 다음 값이 느려집니다.
* 실행 시 예외입니다.
*
* @이 인스턴스의 복제본을 반환합니다.
* @복제가 지원되지 않음개체의 클래스가 그렇지 않은 경우 예외
* 에서는 {@codeCloneable} 인터페이스를 지원합니다. 하위 클래스
* {@code clone} 메서드를 재정의하는 경우
* 인스턴스가 다음을 수행할 수 없음을 나타내기 위해 이 예외를 던집니다.
* 복제되다
* @java.java를 참조하십시오.복제 가능
*/
```

#### Shallow copy (얕은 복사), Deep copy (깊은 복사)

기본적으로 자바는 shallow copy 를 제공한다.

- clone.getRepository() == issue.getRepository() => true

````java
protected Object clone() throws CloneNotSupportedException {
    return super.clone();
}
````

Deep copy
````java
@Override
protected Object clone() {
  GithubRepository repository = new GithubRepository();
  repository.setUser(this.repository.getUser());
  repository.setName(this.repository.getName());
  
  GithubIssue githubIssue = new GithubIssue(repository);
  githubIssue.setId(this.id);
  githubIssue.setTitle(this.title);
  
  return githubIssue;
}
````

#### 프로토타입 패턴의 장점과 단점

장점 
- 복잡한 객체르르 만드는 과정을 캡슐화 가능하다.
- 기존 객체를 복제하는 과정이 새 인스턴스를 만드는 것보다 비용적인 면에서 효율적일 수도 있다.
- 추상적인 타입을 리턴할 수 있다.

단점
- 복제한 객체를 만든느 과정 자체가 복잡할 수 있다. (특히, 순환 참조가 있는 경우)

#### 사용 사례

- Collection 
  - List 에서 Cloneable 을 사용하지 않아서 List<A> list = new ArrayList<>(복사대상); 방식을 주로 사용한다.
- Mapper
  - model mapper(리플렉션), mapstruct
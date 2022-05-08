## 프로토타입 패턴

---

### ▪ Prototype 패턴 이란?
> 기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법, 복제 기능을 갖추고 있는 기존 인스턴스를 프로토타입으로 사용하여 새 인스턴스를 만들 수 있다.

---

### [실습 예제 코드](./App.java)

해당 예제는 강의에 있는 코드를 그대로 README로 옮기기만 했습니다.

#### [GithubRepository.java](./GithubRepository.java)
```java
public class GithubRepository {

    private String user;
    private String name;

    public GithubRepository(String user, String name) {
        this.user = user;
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }
}
```

---

#### [GithubIssue.java](./GithubIssue.java)
```java
public class GithubIssue {
    private int id;
    private String title;
    private GithubRepository githubRepository;
    private String base = "https://github.com";

    public GithubIssue(int id, String title, GithubRepository githubRepository) {
        this.id = id;
        this.title = title;
        this.githubRepository = githubRepository;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public GithubRepository getGithubRepository() {
        return githubRepository;
    }

    public String getUrl() {
        return String.format("%s/%s/%s/issues/%s", base, this.githubRepository.getUser(), this.githubRepository.getName(), id);
    }
}
```

---

```java
// GithubIssue를 새로만들기 위해 생성자를 통해 새로 만드는것이 아닌 clone()을 이용하여 복제한다.
GithubIssue newIssue = githubIssue.clone();
```

clone()을 통해 복제하였다고 해서 기존의 `githubIssue`와 `newIssue`는 같지 않다.<br>
다만 `newIssue.equals(githubIssue)`를 하였을때는 true를 반환한다.

> 해당 내용에 대해서는 Object.class의 clone()에 설명되어있다.

---

### ▪ clone()을 사용하는방법 

clone()이라는 메서드는 Object.class에 존재하며 protected로 만들어져 있다.

clone()을 지원하기 위한 인스턴스를 만들기 위해서는 `Cloneable` 인터페이스를 반드시 구현해야 한다.

implements한 다음 `clone()`메서드를 오버라이딩 해준다.

```java
// clone()의 반환값은 Object이기 때문에 형변환 필요.
GithubIssue newIssue = (GithubIssue) githubIssue.clone();
```

clone()을 사용하였을때는 불필요한 생성과 같은 작업을 반복해서 하지 않아서 좋지만 단점은 
clone()이 될때의 복사는 얕은 복사로 생성이된다.

해당 코드에서는 GithubIssue가 가지고 있는 GithubRepository의 주소값은 복사된 값과 원본값은 같은 주소값을 가리킨다.

이말은 즉 복제된 newIssue에서 기존의 githubRepository의 값을 변경하게 된다면 원본값은 githubIssue도 영향을 받게 된다.

만약 얕은 복사가 아니라 깊은 복사를 하고싶다면 `clone()`메서드를 오버라이딩한 부분에 코드를 추가하면 된다.

```java
@Override
protected Object clone() throws CloneNotSupportedException {
    
    GithubRepository repository = new GithubRepository(this.githubRepository.getUser(), this.githubRepository.getName());
    return new GithubIssue(this.id, this.title, repository);
}
```
---

### ▪ Prototype Pattern의 장,단점

#### ▪ 장점
- 복잡한 객체를 만드는 과정을 숨길 수 있다. `clone()`
- 기존 객체를 복제하는 과정이 새 인스턴스를 만드는 것보다 비용적인 면에서 효율적일 수도 있다.
- 추상적인 타입을 리턴할 수 있다.

#### ▪ 단점
- 복제한 객체를 만드는 과정 자체가 복잡할 수 있다. (특히 순환참조가 있을 경우)

---

### ▪ 자바와 스프링에서 찾아보는 Prototype Pattern

:✨ Java의 ArrayList가 Cloneable를 구현하고있어 사용할 수 있으나 추상적인 인터페이스인 List를 사용하기 때문에 자주 사용하지 않는다.
> ArrayList에서는 Cloneable를 구현하고 있지만 List는 Cloneable를 구현하고있지 않다. 추가로 ArrayList를 상속받은 class들은 clone이 사용 가능하다.

✨ ModelMapper 사용 
```groovy
// build.gradle 에 해당 dependency 추가
implementation 'org.modelmapper:modelmapper:2.4.2'
```

ModelMapper의 원리는 Java의 Reflection을 사용하여 동작한다. 
[ModelMapper 공식 사이트](http://modelmapper.org/)
```java
ModelMapper modelMapper = new ModelMapper();
GithubIssueData githubIssueData = modelMapper.map(githubIssue, GithubIssueData.class);
```

`ModelMapper`와 비슷하게 `MapStruct`가 있는듯 한데. `MapStruct`가 속도가 월등히 빠르다고 한다. 
혹시나 사용해보거나 공부해보고자 한다면 MapStruct에 대해서 알아보는 것이 더 좋아보임.
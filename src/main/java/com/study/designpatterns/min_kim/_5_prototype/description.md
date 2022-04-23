### 객체 생성 패턴: 프로토타입 패턴 (Prototype Pattern)

#### 프로토타입 패턴이란?
- 기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법
- 복제 기능을 가지고 있는 기존 인스턴스를 프로토 타입으로 사용해 새 인스턴스를 만들 수 있다.
- 기존 인스턴스를 만들 때 DB나 다른 프로세스와 네트워크 통신을 통해 가져온 데이터를 기반으로 인스턴스를 생성해야할 때 유용하다.
  - 위의 경우 처럼 리소스가 많이 필요한 기존 인스턴스를 복사해서 새 인스턴스를 생성하면 네트워크 통신에 필요한 리소스와 시간을 줄일 수 있다.

#### 프로토타입 패턴 적용
- 프로토 타입을 적용하면 기존 issue 인스턴스를 복사해서 새로운 인스턴스를 생성할 수 있다.
- 기존 인스턴스를 clone 했을 때 레퍼런스가 다르기 때문에 동일성은 만족하지 않지만 데이터는 같기 때문에 동등성은 만족해야 한다.


    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("kimmin-ko");
        repository.setName("design-patterns");
    
        GithubIssue issue = new GithubIssue(repository);
        issue.setId(1);
        issue.setTitle("1주차 과제: JVM은.........");

        String url = issue.getUrl();
        System.out.println(url);

        GithubIssue cloneIssue = issue.clone(); --> 컴파일 에러

        System.out.println(issue != cloneIssue == true); // 동일성을 만족하지 않음
        System.out.println(issue.equals(cloneIssue) == true); // 동등성을 만족함
    }


- 현재 컴파일 에러가 발생하는 GithubIssue 인스턴스가 clone()를 사용할 수 있도록 Java에서 제공하는 방법을 살펴보자.
*Object 클래스에서 제공하는 clone() 메서드*


    public class Object {

        @HotSpotIntrinsicCandidate
        protected native Object clone() throws CloneNotSupportedException;

    }

- Object의 clone() 메서드의 접근제한자는 protected이기 때문에 GithubIssue 인스턴스를 사용하는 클라이언트는 clone() 메서드에 접근할 수 없다.
- 그래서 GithubIssue는 클라이언트에게 clone() 메서드를 제공해주기 위해 public 접근제한자로 clone() 메서드를 오버라이딩 해야한다.


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


- 또 한가지로 clone() 메서드를 사용하는 클래스는 Cloneable 인터페이스를 구현해야 하는데, 구현하지 않을 경우 CloneNotSupportedException 예외가 발생한다.


    public class GithubIssue implements Cloneable


- Object의 clone()은 얕은 복사를 제공하는데, 깊은 복사를 제공해 주기 위해서는 개발자가 직접 복제 로직을 구현해야 한다.



    @Override
    public Object clone() throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("hi");
        repository.setName("design-pattern-1");

        GithubIssue issue = new GithubIssue(repository);
        issue.setId(this.id);
        issue.setTitle(this.title);

        return issue;
    }


#### 프로토타입 패턴의 장단점
- 장점
  - 기존 객체를 복제하는 과정이 새 인스턴스를 만드는 것보다 시간이나 메모리 비용에서 효율적일 수 있다.
  - clone() 메서드의 반환 타입을 추상화해서 조금 더 유연하게 설계할 수 있다.
- 단점
  - 순환 참조가 있는 경우에 객체를 복제하는 과정이 복잡해질 수 있다.
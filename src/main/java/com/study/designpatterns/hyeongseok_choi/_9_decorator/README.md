# behavioral_patterns

## 데코레이터 패턴

- 기존 코드를 변경하지 않으며 부가기능을 다이나믹하게 추가할 수 있음
    - 런타임에 기존 코드 확장 가능

![UML](uml.png)

### 예시
- 댓글을 다는 프로그램
```java
public class TrimmingCommentService extends CommentService { // 트리밍 하는 기능

    @Override
    public void addComment(String comment) {
        super.addComment(trim(comment));
    }

    private String trim(String comment) {
        return comment.replace("...", "");
    }

}
public class SpamFilteringCommentService extends CommentService { // 스팸을 걸러내는 기능

    @Override
    public void addComment(String comment) {
        boolean isSpam = isSpam(comment);
        if (!isSpam) {
            super.addComment(comment);
        }
    }

    private boolean isSpam(String comment) {
        return comment.contains("http");
    }
}
public class Client {

    private CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment) {
        commentService.addComment(comment);
    }

    public static void main(String[] args) {
        Client client = new Client(new SpamFilteringCommentService()); // 클라이언트는 하나의 기능밖에 사용할 수 없음
        client.writeComment("오징어게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://whiteship.me");
    }

}
```
▼
```java
public interface CommentService { // 컴포넌트 인터페이스

    void addComment(String comment);
}
public class DefaultCommentService implements CommentService { // concrete 컴포넌트
    @Override
    public void addComment(String comment) {
        System.out.println(comment);
    }
}

public class CommentDecorator implements CommentService { // 데코레이터 인터페이스

    private CommentService commentService;

    public CommentDecorator(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void addComment(String comment) {
        commentService.addComment(comment);
    }
}
public class SpamFilteringCommentDecorator extends CommentDecorator { // concrete 데코레이터

    public SpamFilteringCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        if (isNotSpam(comment)) {
            super.addComment(comment);
        }
    }

    private boolean isNotSpam(String comment) {
        return !comment.contains("http");
    }
}
public class TrimmingCommentDecorator extends CommentDecorator {

    public TrimmingCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        super.addComment(trim(comment));
    }

    private String trim(String comment) {
        return comment.replace("...", "");
    }
}

public class Client {

    private CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    public void writeComment(String comment) {
        commentService.addComment(comment);
    }
}
public class App {

    private static boolean enabledSpamFilter = true;

    private static boolean enabledTrimming = true;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        if (enabledSpamFilter) {
            commentService = new SpamFilteringCommentDecorator(commentService);
        }

        if (enabledTrimming) {
            commentService = new TrimmingCommentDecorator(commentService);
        }

        Client client = new Client(commentService); 
        client.writeComment("오징어게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://whiteship.me");
    }
}
```

### 장점
- 새로운 클래스를 만들지 않고 기존 기능들을 *조합* 할 수 있음 → 단일책임원칙
- 런타임에 동적으로 기능을 변경할 수 있음 → 개방폐쇄원칙, 의존성역전원칙(인터페이스 이용)
    
### 단점
- 코드가 조금 복잡해 질 수 있음
    - 상속을 사용한 기존 코드가 더 복잡할 수도 있으므로 크게 다르지 않기도 함

### 자바와 스프링에서의 예시
- 자바
    - io (InputStream, InputStreamReader)
    - collections
        ```java
        public class DecoratorInJava {
        
            public static void main(String[] args) {
                // Collections가 제공하는 데코레이터 메소드
                ArrayList list = new ArrayList<>();
                list.add(new Book());
        
                List books = Collections.checkedList(list, Book.class); // 타입 체킹 기능 제공
        
        //        books.add(new Item());
        
                List unmodifiableList = Collections.unmodifiableList(list); // immutable 로 취급하게 해주는 기능 제공
                list.add(new Item());
                unmodifiableList.add(new Book());
            }
        }
        ```
    - HttpServletRequestWrapper : 서블릿 리퀘스트를 확장해서 부가적인 기능을 수행할 수 있음
- 스프링
    - BeanDefinitionDecorator
    - ServerHttpRequestDecorator

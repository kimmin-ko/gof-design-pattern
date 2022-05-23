### 어댑터 패턴
> 클라이언트가 사용하는 인터페이스를 따르지 않는 기존 코드를 어댑터를 통해 재사용할 수 있게 해준다.

#### 장점
- 기존 코드를 변경하지 않고 원하는 인터페이스 구현체를 만들어 재상용할 수 있다. (OCP)
- 기존 코드가 하던 일과 특정 인터페이스 구현체로 변환하는 작업을 각기 다른 클래스로 분리하여 관리할 수 있다. (SRP)

#### 단점
- 새 클래스가 생겨 복잡도가 증가할 수 있다. 경우에 따라서는 기존 코드가 해당 인터페이스를 구현하도록 수정하는 것이 좋은 선택이 될 수도 있다.

#### 사용 사례
````java
public class AdapterInJava {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("A", "B", "C");
        Enumeration<String> enumeration = Collections.enumeration(strings);
    }
}
````

+ strings => 어댑티
+ Enumeration<String> enumeration => 타켓
+ Collections.enumeration => 어댑터

````java
try (InputStream is = new FileInputStream("input.txt");
     InputStreamReader isr = new InputStreamReader(is);
     BufferedReader reader = new BufferedReader(isr)) {
     while (reader.ready()) {
        System.out.println(reader.readLine());
     }
} catch (IOException e) {
    throw new RuntimeException(e);
}
````

관점에 따라선 아래와 같이 볼 수 있다.

+ input.txt, is, isr => 어댑티
+ InputStream, InputStreamReader, BufferedReader => 타겟
+ FileInputStream, InputStreamReader, BufferedReader => 어댑터

````java
public class AdapterSpring {
    public static void main(String[] args) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        HandlerAdapter handler = new RequestMappingHandlerAdapter();
    }
}

public interface HandlerAdapter {
    
    boolean supports(Object handler);

    @Nullable
    ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;
    
}
````
스프링에선 핸들러를 매핑하기 위해 여러가지 방법이 존재하는데 이때 사용하는게 HandlerAdapter 이다.

```java
protected HandlerAdapter getHandlerAdapter(Object handler) throws ServletException {
    if (this.handlerAdapters != null) {
        for (HandlerAdapter adapter : this.handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
    }
    throw new ServletException("No adapter for handler [" + handler +
            "]: The DispatcherServlet configuration needs to include a HandlerAdapter that supports this handler");
}
```
getHandlerAdapter 는 오브젝트 타입의 어댑티를 받아서 그에 맞는 어댑터 타겟을 반환한다. 

+ HttpServletRequest request, HttpServletResponse response, Object handler => 어댑티
+ ModelAndView => 타겟
+ HandlerAdapter => 어댑터
# 싱글톤 패턴

> 인스턴스를 오직 한개만 제공하는 클래스

시스템 런타임, 환경 세팅에 대한 정보등 , 인스턴스가 여러개일때 문제가 생길 수 있는 경우 인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요하다. 이럴때 싱글톤 패턴을 사용한다.


---

### 가장 기본적으로 생성하는 방법 [Sample 소스](./BasicSingletonSample.java)

 - 생성자는 private으로 생성해준다. 
 - `public static` 하게 해당 인스턴스를 받을 수 있는 메서드를 작성한다.
 
흔히 작성하는 코드
```java

public static StaticClass getInstance() {
    if (instance == null) {
        instance = new StaticClass();    
    }
    
    return instance;
}
```

해당 코드에는 심각한 문제가 존재
웹 어플리케이션 코드를 작성하게되면 멀티쓰레드를 통해 동작하게 되는데 멀티쓰레드 환경에서
해당 코드가 안전한지 확인해봐야 하지만, 해당 코드는 안전하지 않다. 

---

## 멀티 쓰레드에서 안전하게 싱글톤 객체를 생성하는 방법 

### ▪ 1. Method 레벨에 `synchronized`키워드 사용 [Sample 소스](./SynchronizedSample.java)

멀티 쓰레드 환경에서 동시에 getInstance()를 호출하는 시점에 instance가 null이라면 문제가 발생한다.

여러 가지 방법이 있지만 그중 하나의 방법은 `synchronized` 키워드를 사용하여 해당 메서드에 딱 하나의 쓰레드만 접근가능하도록 설정하는 방법이다

```java
public static synchronized StaticClass getInstance() {
    if (instance == null) {
        instance = new StaticClass();    
    }
    
    return instance;
}
```

다음과 같이 하면 하나의 인스턴스를 보장할 수 있다. 하지만 단점은 getInstance를 호출할때마다 해당 메서드를 동기화 하기 때문에 성능의 불이익이 생길수 있다는 단점이 있다.


### ▪ 2. Eager Initialization 사용

```java
public static final StaticClass INSTANCE = new StaticClass();

public static synchronized StaticClass getInstance() {
    return instance;
}
```

올라옴과 동시에 처음부터 객체를 생성해놓고 반환만 하도록 한다.

해당 방법을 사용하면 처음부터 하나만 만들수 있어서 멀티 쓰레드 환경에서도 안전하다고 보장 할 수 있다.
하지만 미리 만든다는점 자체가 단점이 될 수 있음.

해당 객체를 만드는 과정이 메모리를 많이 사용하여 만들었지만 해당 애플리케이션에서 사용이 되지 않는다면 불이익이 될 수 있다. 


### ▪ 3. Double Checked Locking 사용

```java
private static volatile StaticClass instance;

public static synchronized StaticClass getInstance() {
    if (instance == null) {
        synchronized(StaticClass.class) {
            if(instance == null) {
                instance = new StaticClass();    
            }
        }
    }
    return instance;
}
```
동시에 들어와서 생성하려고 하여도 StaticClass를 사용중인 쓰레드가 있다면 `synchronized`에 의해 하나의 쓰레드는 기다리게 된다.

`volatile`키워드를 사용해줘야 double checked locking 가 완성이 된다. 

해당 코드는 instance 가 null 일경우에만들어와서 동기화로직을 확인하기 때문에 훨씬더 성능에 유리하다. 

또한 인스턴스를 필요로 하는 해당 시점에만 만들 수 있어서 좋다 .


### ▪ 4. static inner 클래스 사용하기

```java

public class  StaticClass {
    private StaticClass() {}
    
    private static class StaticClassHolder() {
        private static final StaticClass INSTANCE = new StaticClass(); 
    }
    
    public static StaticClass getInstance() {
        return StaticClassHolder.INSTANCE;
    }
}
```

멀티쓰레드 환경에서도 안전하고 getInstance()가 호출될때 해당 클래스가 호출되고 만들어지기 때문에 
Lazy Loading 도 가능한 코드가 된다. Double checking Locking 보다 덜 복잡하다.


---


## 싱글톤 구현을 깨트리는 방법

### 🔹 리플렉션. [Sample 소스](./ReflectionSample.java)

리플렉션은 막을 방법이 없음. 

### 🔹 직렬화 & 역 직렬화. [Sample 소스](./SerializationDeserializationSample.java)

직렬화 & 역직렬화를 막는방법으로는 readResolve()를 구현한다.

### 🔹 Enum을 사용한다

리플렉션 사용시 `Cannot reflectively create enum objects` 에러 발생 .

단점은 enum을 사용하게 되면 미리 만들어진다. 쓰는 순간 로딩하도록 만들 수 없다.













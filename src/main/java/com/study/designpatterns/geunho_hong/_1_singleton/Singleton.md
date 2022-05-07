# 싱글톤 패턴

### 싱글톤 패턴

- 인스턴스를 오직 한개만 제공하는 클래스
    - 시스템 런타임, 환경 세팅에 대한 정보는 인스턴스가 여러개 일때 문제가 생길 수 있어
    인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요하다

**싱글톤 패턴 구현 1**

```java
public class Settings {

	private static Settings instance;

  private Setting() { }

  public static Settings getInstance() {
			if(instance == null) {
					instance = new Settings();
			}
			return instance;
	}
}
```

- 일반적으로 사용하는 싱글톤 패턴 사용 방식이다
    - Multi-Thread 환경에서 여러개의 인스턴스가 생성될 수 있어 안전하지 않다

**싱글톤 패턴 구현2 - Synchronized** 

```java
public static synchronized Settings getInstance() {
		if(instance == null) {
				instance = new Settings();
		}
		return instance;
}
```

- 자바의 `synchronized` 를 사용해 동시성 문제를 해결할 수 있다
    - 단 하나의 Thread 가 접근 중일 때 Lock이 걸리기 때문에 시스템이 느려질 수 있다
- synchronized method는 인스턴스에 lock을 건다
    - 인스턴스 단위로 Lock을 걸지만 synchronized 키워드가 붙은 메소드들에 대해서만 lock을 공유 한다
- static 키워드가 포함된 synchronized 메소드는 클래스 단위로 Lock을 공유한다

> 클래스 단위에 거는 lock과 인스턴스 단위에 거는 lock은 공유가 안 되기 때문에 혼용해서 쓴다면 동기화 이슈가 발생한다
> 

**싱글톤 패턴 구현3 - 이른 초기화**

```java
private static final Settings INSTANCE = new Settings();
private Settings() {}

public static Settings getInstance() {
		return INSTANCE;
}
```

- 인스턴스를 미리 생성해 놓는 방법이다.
    - 생성만 해놓고 사용하지 않을 경우 메모리 낭비가 발생할 수 있다

**싱글톤 패턴 구현4 - double checked locking**

```java
public static Settings getInstance(){
	if(instance == null) {
		synchronized (Settings.class) {
			if(instance == null) {
					instance = new Settings();
			}
		}
	}
}
```

- 인스턴스가 null일 때만 한번 더 검증 하여 멀티 스레드 환경에서 동시성 문제를 좀 더 효율적으로 처리할 수 있다
- `volatile` 키워드를 붙여 사용해야 하며, JDK 1.4 이전에서는 적용하기 힘든 단점이 있다

**싱글톤 패턴 구현5 - static inner**

```java
private Settings() {}

private static class SettingsHolder() {
	 private static final Settings SETTINGS = new Settings();
}

public static Settings getInstance() {
		return SettingsHolder.SETTINGS;
}
```

- 여러가지 싱글톤 패턴 구현 중에 권장하는 방식
    - Lazy Loading을 사용하여 호출 하는 시점에 한번 만 생성하고 그것을 계속해서 사용한다

**싱글톤 패턴 구현6 - enum**

```java
public enum Settings {
		INSTANCE;
}
```

- enum은 `serializeable` 을 구현하고 있기 때문에 직렬화 및 역직렬화 환경에서 안전하게 사용할 수 있다

### 싱글톤 패턴 깨트리기

1. 리플렉션 사용하기
    1. 구체적인 클래스 타입을 알지 못해도 그 클래스의 메소드, 타입 , 변수들에 접근하게 해주는 API
2. 직렬화 & 역직렬화 사용하기
    1. 객체를 직렬화 해서 파일을 쓰고 역직렬화 해서 파일을 읽어 들임 

<aside>
💡 serialVersionUID

- serialVersionUID 값을 명시적으로 지정하지 않으면 complier가 계산된 값을 부여한다. Serialze 할 때와 Deserialize 할때의 serialVersionUID 값이 다르면 저장된 값을 객체로 저장한 후 불러올 수 없다
- 객체를 저장하고 불러올 때 serialVersionUID 값을 통해 불러온다
</aside>
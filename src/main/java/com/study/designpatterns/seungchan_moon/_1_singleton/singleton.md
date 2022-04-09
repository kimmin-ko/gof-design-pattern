
### 싱글톤 패턴

인스턴스를 오직 한개만 제공하는 클래스이며 시스템 런타임, 환경 세팅에 대한 정보 등 인스턴스가 여러개 일 때 문제가 생길 수 있는 경우 사용한다.


- [가장 단순한 방법](./Settings_1.java)
    - 멀티 스레드에 취약하다.
    - synchronized 블록을 통해 안전하게 만들 수 있다.
        - 스레드를 blocking 시키기 때문에 성능상 좋지 않다.
- [이른 초기화(eager initialization)](./Settings_2.java)
    - 객체가 사용하지 않아도 초기화 시키기 때문에 메모리상 좋지 않다.
- [double checked locking](./Settings_3.java)
    - 메모리 비용과 성능상 이점을 높였지만 복잡하다.
- [느린 초기화(lazy initialization)](./Settings_4.java)
    - 권장하는 방법 중 하나.

---

#### 싱글톤을 파괴하는 방법
1. 리플렉션
```java
Settings_4 destroy = Settings_4.getInstance();

Constructor<Settings_4> constructor = Settings_4.class.getDeclaredConstructor();
constructor.setAccessible(true);
Settings_4 settings_4 = constructor.newInstance();

System.out.println(destroy == settings_4); 
```

- 방어법

리플렉션을 통해 싱글톤을 파괴하는 경우 막을 방법이 없지만 enum 을 사용하면 Constructor 코드 내에 enum object 생성의 경우 오류를 내도록 되어있다.
```java
 public T newInstance(Object ... initargs)
        throws InstantiationException, IllegalAccessException,
               IllegalArgumentException, InvocationTargetException
    {
        if (!override) {
            Class<?> caller = Reflection.getCallerClass();
            checkAccess(caller, clazz, clazz, modifiers);
        }
        if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            throw new IllegalArgumentException("Cannot reflectively create enum objects");
        ConstructorAccessor ca = constructorAccessor;   // read volatile
        if (ca == null) {
            ca = acquireConstructorAccessor();
        }
        @SuppressWarnings("unchecked")
        T inst = (T) ca.newInstance(initargs);
        return inst;
    }
```
[enum 을 이용해 싱글톤 생성](./Settings_5.java)


2. 직렬화와 역직렬화
```java
Settings_4 settings = Settings_4.getInstance();
Settings_4 object = null;

try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
    objectOutput.writeObject(settings);
}

try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream("settings.obj"))) {
    object = (Settings_4) objectInput.readObject();
}

System.out.println(object == settings); 
```

- 방어법
```java
protected Object readResolve() {
    return getInstance();    
} 
```


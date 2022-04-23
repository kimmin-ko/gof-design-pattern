
### 추상 팩토리 패턴
> 서로 관련있는 여러 객체를 만들어주는 인터페이스

- 구체적으로 어떤 클래스의 인스턴스를(concrete product)를 사용하는지 감출 수 있다.

#### 팩토리 메소드 패턴과 무엇이 다른가?
- 둘 다 구체적인 객체 생성 과정을 추상화한 인터페이스를 제공하지만 관점이 다르다.
  - 팩토리 메소드 : 팩토리를 구현하는 방법(inheritance)에 초점을 둔다.
  - 추상 팩토리 : 팩토리를 사용하는 방법(composition)에 초점을 둔다.

- 목적이 다르다.
  - 팩토리 메소드 : 구체적인 생성 과정을 하위 또는 구체적인 클래스로 옮기는 것이 목적이다.
  - 추상 팩토리 : 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는 것이 목적이다.
  
#### 사용 사례
- 자바 라이브러리
  - javax.xml.xpath.XPathFactory#newInstance()
  - javax.xml.transform.TransformerFactory#newInstance()
  - javax.xml.parsers.DocumentBuilderFactory#newInstance()
- 스프링
  - FactoryBean 과 그 구현체
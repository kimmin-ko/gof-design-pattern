## 파타드 패턴

---

파사드 패턴이란 복잡한 서브 시스템 의존성을 최소화하는 방법을 의미한다.<br>
클라이언트가 사용해야 하는 복잡한 서브 시스템 의존성을 간단한 인터페이스로 추상화 할 수 있다.


```java

public class Client{
  public static void main(String[] args) {

    String to = "zzdd1558@gmail.com";
    String from = "zzdd1558@gmail.com";
    String host = "127.0.0.1";
    
    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host",host);
    
    Session session = Session.getDefaultInstance(properties);
    
    try {
      MimeMessage message = new MimeMessage(sessioin);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject("Test Mail From Java Program");
      message.setText("message");
      
      Transport.send(message);
    }catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
```

위의 메일 보내는 코드를 메일을 보내는 EmailSender, EmailMessage, EmailSettings 를 통하여 클래스를 사용하여 역할을 분리.


---

파사드 패턴의 장단점

장점
 - 서브 시스템에 대한 의존성을 한곳으로 모을 수 있다. (해당 예제의 EmailSender)
 - 코드를 사용하는 부분에대해서 관심있는부분에만 집중할 수 있다.

단점
 - 파사드 자체가 SubSystem에 대한 모든 의존성을 가지게 된다. ( 그러나 읽기는 편해진다. )
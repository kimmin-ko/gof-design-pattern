## 퍼사드 패턴 (facade pattern)

### 퍼사드 패턴 정의

- 복잡한 서브 시스템의 의존성을 간단한 인터페이스로 추상화하여 클라이언트가 쉽게 사용할 수 있도록 한다.

### java 라이브러리를 이용해서 mail 전송하기

- 클라이언트는 mail을 보내기 위해서 다양한 java 라이브러리에 대한 의존성을 가져야하고, 라이브러리에 대한 복잡한 사용 방법도 알고있어야 한다.

```java
public class Client {

    public static void main(String[] args) {
        String from = "min@naver.com";
        String to = "kimmin@naver.com";
        String host = "127.0.0.1";
        String subject = "Test mail from java program";
        String text = "message";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(from);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
```

---

### 퍼사드 패턴으로 개선하기

- 메일을 보내기 위한 java 라이브러리의 의존성과 복잡한 로직을 EmailSender 라는 퍼사드를 통해 감추었다.

```java
public class EmailSender {

    private final EmailSettings emailSettings;

    public EmailSender(EmailSettings emailSettings) {
        this.emailSettings = emailSettings;
    }

    public void send(EmailMessage emailMessage) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", emailSettings.getHost());

        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(emailMessage.getFrom());
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailMessage.getTo()));
            message.setSubject(emailMessage.getSubject());
            message.setText(emailMessage.getText());

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
```

- 클라이언트는 EmailSender의 send() 메서드를 통해 쉽게 메일을 보내는 기능을 구현할 수 있다.

```java
public class Client {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        EmailSettings emailSettings = new EmailSettings(host);

        String from = "min@naver.com";
        String to = "kimmin@naver.com";
        String subject = "Test mail from java program";
        String text = "message";
        EmailMessage message = new EmailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        EmailSender emailSender = new EmailSender(emailSettings);
        emailSender.send(message);
    }
}
```

---

### 퍼사드 패턴의 장점과 단점

- 장점
  - 서브 시스템의 대한 의존성을 한 곳으로 모을 수 있다.
- 단점
  - 퍼사드 클래스가 서브 시스템에 대한 의존성을 모두 갖게된다.
    - 모든 클라이언트에서 의존성을 갖기 보다 퍼사드 클래스 하나에서 갖고 있으면 유지보수성이 증가하기 때문에 단점이라고 하기 애매하다.
    - 퍼사드 클래스가 의존성을 갖고 있지만, 퍼사드 패턴을 적용함으로써 클라이언트 코드가 읽기 좋아졌다면 단점보다 장점에 가깝다.
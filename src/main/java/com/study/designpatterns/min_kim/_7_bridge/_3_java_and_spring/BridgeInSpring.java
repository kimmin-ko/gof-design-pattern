package com.study.designpatterns.min_kim._7_bridge._3_java_and_spring;

import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

public class BridgeInSpring {

    private static EntityManager em;

    public static void main(String[] args) {
        // 인스턴스를 생성하는 부분은 외부에서 DI로 주입할 수 있다.
        TransactionTemplate transactionTemplate = new TransactionTemplate(new JpaTransactionManager());

        Long examId = transactionTemplate.execute((status) -> {
            Exam exam = em.createQuery("select e from Exam e where e.id = :id", Exam.class)
                    .setParameter("id", 1)
                    .getSingleResult();
            return exam.getId();
        });
    }
}

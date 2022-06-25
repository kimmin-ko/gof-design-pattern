package com.study.designpatterns.min_kim._22_template_method._3_java;

import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class TemplateCallbackInSpring {

    public static void main(String[] args) {
        // JdbcTemplate
        String sql = "insert into a (id) values (1)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.execute(sql);
        jdbcTemplate.execute(new StatementCallback<Object>() {
            @Override
            public Object doInStatement(Statement stmt) throws SQLException, DataAccessException {
                stmt.execute(sql);
                return null;
            }
        });

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("http://localhost:8080/users", HttpMethod.GET, entity, String.class);

        // requestEntity와 responseType을 감싼 RequestCallback 인스턴스 생성
        // RequestCallback은 void doWithRequest(ClientHttpRequest request); 메소드 정의
    }
}

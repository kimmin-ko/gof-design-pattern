package com.study.designpatterns.seungchan_moon._14_command.java;

import com.study.designpatterns.seungchan_moon._14_command.after.Command;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CommandInSpring {

    private DataSource dataSource;

    public CommandInSpring(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(Command command) {
//        SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
//                .withTableName("command")
//                .usingGeneratedkeyColumns("id");
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("name", command.getClass().getSimpleName());
//        data.put("when", LocalDateTime.now());
//        insert.execute(data);

    }
}

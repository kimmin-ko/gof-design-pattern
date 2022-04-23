package com.study.designpatterns.yunjin_choi._5_prototype_pattern;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._5_prototype_pattern
 *      GithubRepository
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-12 오후 11:44
 */

public class GithubRepository {

    private String user;
    private String name;

    public GithubRepository(String user, String name) {
        this.user = user;
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }
}

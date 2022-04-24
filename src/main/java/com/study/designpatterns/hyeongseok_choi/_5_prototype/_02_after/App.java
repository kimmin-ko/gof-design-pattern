package com.study.designpatterns.hyeongseok_choi._5_prototype._02_after;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("whiteship");
        repository.setName("live-study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제 : ...");

        String url = githubIssue.getURL();
        System.out.println(url);

        GithubIssue githubIssue2 = (GithubIssue) githubIssue.clone();
        githubIssue.setId(2);
        githubIssue.setTitle("2주차 과제 : ...");

//        얕은 복사일 경우 repository 값이 변경 되었을 때 문제
        repository.setUser("keesun");

        System.out.println(githubIssue != githubIssue2);
        System.out.println(githubIssue.equals(githubIssue2));
        System.out.println(githubIssue.getClass() == githubIssue2.getClass());
        System.out.println(githubIssue.getRepository() == githubIssue2.getRepository());
    }
}

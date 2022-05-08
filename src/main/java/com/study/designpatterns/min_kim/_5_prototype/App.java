package com.study.designpatterns.min_kim._5_prototype;

public class App {

    public static void main(String[] args) throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("kimmin-ko");
        repository.setName("design-patterns");

        GithubIssue issue = new GithubIssue(repository);
        issue.setId(1);
        issue.setTitle("1주차 과제: JVM은.........");

        System.out.println(issue.getUrl());

        GithubIssue cloneIssue = (GithubIssue) issue.clone();

        System.out.println(cloneIssue.getUrl());

        System.out.println(issue != cloneIssue); // 동일성을 만족하지 않음
        System.out.println(issue.equals(cloneIssue)); // 동등성을 만족함
        System.out.println(cloneIssue.getClass() == issue.getClass());
    }
}
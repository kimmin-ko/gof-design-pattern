package com.study.designpatterns.seungchan_moon._5_prototype.after;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("msc");
        repository.setName("study");

        GithubIssue issue = new GithubIssue(repository);
        issue.setId(1);
        issue.setTitle("1주차 과제 : JVM 이란?");

        String url = issue.getUrl();
        System.out.println(url);

        GithubIssue clone = (GithubIssue) issue.clone();
        System.out.println(clone.getUrl());

        repository.setUser("moon");

        System.out.println(clone != issue);
        System.out.println(clone.equals(issue));
        System.out.println(clone.getClass() == issue.getClass());
        System.out.println(clone.getRepository() == issue.getRepository());

        System.out.println(clone.getUrl());
    }
}

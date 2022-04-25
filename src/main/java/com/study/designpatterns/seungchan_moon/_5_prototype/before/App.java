package com.study.designpatterns.seungchan_moon._5_prototype.before;

public class App {
    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("msc");
        repository.setName("study");

        GithubIssue issue = new GithubIssue(repository);
        issue.setId(1);
        issue.setTitle("1주차 과제 : JVM 이란?");

        String url = issue.getUrl();
        System.out.println(url);

        //TODO : clone != issue
        //TODO : clone.equals(issue) > true
    }
}

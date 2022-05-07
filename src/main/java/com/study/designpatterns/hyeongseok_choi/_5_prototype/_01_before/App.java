package com.study.designpatterns.hyeongseok_choi._5_prototype._01_before;

public class App {
    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("whiteship");
        repository.setName("live-study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제 : ...");

        String url = githubIssue.getURL();
        System.out.println(url);

//        매번 이슈를 새로 만들기 복잡하므로 클론을 이용하고 싶음
//        GithubIssue githubIssue2 = githubIssue.clone();
//        githubIssue.setId(2);
//        githubIssue.setTitle("2주차 과제 : ...");
//        TODO clone != githubIssue
//        TODO clone.equals(githubIssue) => true
    }
}

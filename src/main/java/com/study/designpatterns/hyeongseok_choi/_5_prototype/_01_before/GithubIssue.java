package com.study.designpatterns.hyeongseok_choi._5_prototype._01_before;

public class GithubIssue {
    private int id;
    private String title;
    private GithubRepository repository;

    public String getURL() {
        return "url.....";
    }

    public GithubIssue(GithubRepository repository) {
        this.repository = repository;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GithubRepository getRepository() {
        return repository;
    }

    public void setRepository(GithubRepository repository) {
        this.repository = repository;
    }
}

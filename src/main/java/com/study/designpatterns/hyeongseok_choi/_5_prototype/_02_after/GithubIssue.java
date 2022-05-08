package com.study.designpatterns.hyeongseok_choi._5_prototype._02_after;

import java.util.Objects;

public class GithubIssue implements Cloneable{
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

//    object 클래스에 정의된 clone 이용
//    얕은 복사라는 사실 명심할 것 (deep-copy 아님)
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected Object cloneDeepCopy() {
        GithubRepository repository = new GithubRepository();
        repository.setUser(this.repository.getUser());
        repository.setName(this.repository.getName());

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(this.id);
        githubIssue.setTitle(this.title);

        return githubIssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GithubIssue that = (GithubIssue) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(repository, that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, repository);
    }
}

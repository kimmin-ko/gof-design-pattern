package com.study.designpatterns.min_kim._5_prototype;

import java.util.Objects;

public class GithubIssue implements Cloneable {

    private int id;

    private String title;

    private GithubRepository repository;

    public GithubIssue(GithubRepository repository) {
        this.repository = repository;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public GithubRepository getRepository() {
        return repository;
    }

    public String getUrl() {
        return String.format("https://github.com/%s/%s/issues/%d", repository.getUser(), repository.getName(), id);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("hi");
        repository.setName("design-pattern-1");

        GithubIssue issue = new GithubIssue(repository);
        issue.setId(this.id);
        issue.setTitle(this.title);

        return issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GithubIssue that = (GithubIssue) o;

        if (id != that.id) return false;
        if (!Objects.equals(title, that.title)) return false;
        return Objects.equals(repository, that.repository);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (repository != null ? repository.hashCode() : 0);
        return result;
    }
}

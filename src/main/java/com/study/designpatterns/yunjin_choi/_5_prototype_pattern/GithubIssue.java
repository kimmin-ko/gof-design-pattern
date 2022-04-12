package com.study.designpatterns.yunjin_choi._5_prototype_pattern;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._5_prototype_pattern
 *      GithubIssue
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-12 오후 11:44
 */

public class GithubIssue implements Cloneable{
    private int id;
    private String title;
    private GithubRepository githubRepository;
    private String base = "https://github.com";

    public GithubIssue(int id, String title, GithubRepository githubRepository) {
        this.id = id;
        this.title = title;
        this.githubRepository = githubRepository;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public GithubRepository getGithubRepository() {
        return githubRepository;
    }

    public String getUrl() {
        return String.format("%s/%s/%s/issues/%s", base, this.githubRepository.getUser(), this.githubRepository.getName(), id);
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository(this.githubRepository.getUser(), this.githubRepository.getName());
        return new GithubIssue(this.id, this.title, repository);
    }
}

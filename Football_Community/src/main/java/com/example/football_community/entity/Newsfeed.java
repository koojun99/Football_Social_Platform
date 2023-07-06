package com.example.football_community.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Newsfeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "newsfeed")
    private List<MatchReview> matchReviews = new ArrayList<>();

    @OneToMany(mappedBy = "newsfeed")
    private List<Post> posts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if (user.getNewsfeed() != this) {
            user.setNewsfeed(this);
        }
    }

    public List<MatchReview> getMatchReviews() {
        return matchReviews;
    }

    public void setMatchReviews(List<MatchReview> matchReviews) {
        this.matchReviews = matchReviews;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        posts.add(post);
        post.setNewsfeed(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.setNewsfeed(null);
    }

    public void addMatchReview(MatchReview matchReview) {
        matchReviews.add(matchReview);
        matchReview.setNewsfeed(this);
    }

    public void removeMatchReview(MatchReview matchReview) {
        matchReviews.remove(matchReview);
        matchReview.setNewsfeed(null);
    }
}

package com.example.football_community.domain.post;

import com.example.football_community.domain.member.Member;
import com.example.football_community.domain.newsfeed.Newsfeed;
import com.example.football_community.domain.postlike.Like;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;
    @Column
    private Integer likesCount = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Like> likes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "newsfeed_id")
    private Newsfeed newsfeed;

    public Post() {
        this.createdDate = LocalDateTime.now();
        this.newsfeed = null;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Member getAuthor() {
        return author;
    }

    public void setAuthor(Member author) {
        this.author = author;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public void incrementLikesCount(){
        likesCount++;
    }
    public void decrementLikesCount() {
        if (likesCount > 0) {
            likesCount--;
        }
    }

    public void setNewsfeed(Newsfeed newsfeed) {
        if (this.newsfeed != null) {
            this.newsfeed.removePost(this);
        }
        this.newsfeed = newsfeed;
        if (newsfeed != null) {
            newsfeed.addPost(this);
        }
    }
}

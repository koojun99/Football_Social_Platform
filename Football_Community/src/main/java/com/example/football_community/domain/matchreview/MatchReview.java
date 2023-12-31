package com.example.football_community.domain.matchreview;

import com.example.football_community.domain.match.Match;
import com.example.football_community.domain.member.Member;
import com.example.football_community.domain.newsfeed.Newsfeed;
import jakarta.persistence.*;

@Entity
public class MatchReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Member author;

    @ManyToOne
    @JoinColumn(name = "newsfeed_id")
    private Newsfeed newsfeed;

    public MatchReview() {
        this.newsfeed = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Member getAuthor() {
        return author;
    }

    public void setAuthor(Member author) {
        this.author = author;
    }

    public void setNewsfeed(Newsfeed newsfeed) {
        if (this.newsfeed != null) {
            this.newsfeed.removeMatchReview(this);
        }
        this.newsfeed = newsfeed;
        if (newsfeed != null) {
            newsfeed.addMatchReview(this);
        }
    }
}

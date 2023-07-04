package com.example.football_community.dto;

import java.util.ArrayList;
import java.util.List;

public class NewsfeedDTO {
    private Long id;
    private List<MatchReviewDTO> matchReviewsDTO;
    private List<PostDTO> postsDTO;

    public NewsfeedDTO() {
        this.matchReviewsDTO = new ArrayList<>();
        this.postsDTO = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MatchReviewDTO> getMatchReviewsDTO() {
        return matchReviewsDTO;
    }

    public void setMatchReviewsDTO(List<MatchReviewDTO> matchReviewsDTO) {
        this.matchReviewsDTO = matchReviewsDTO;
    }

    public List<PostDTO> getPostsDTO() {
        return postsDTO;
    }

    public void setPostsDTO(List<PostDTO> postsDTO) {
        this.postsDTO = postsDTO;
    }
    public void addMatchReviewDTO(MatchReviewDTO matchReviewDTO) {
        matchReviewsDTO.add(matchReviewDTO);
    }

    public void removeMatchReviewDTO(MatchReviewDTO matchReviewDTO) {
        matchReviewsDTO.remove(matchReviewDTO);
    }

    public void addPostDTO(PostDTO postDTO) {
        postsDTO.add(postDTO);
    }

    public void removePostDTO(PostDTO postDTO) {
        postsDTO.remove(postDTO);
    }
}
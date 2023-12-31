package com.example.football_community.domain.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFollowerId(Long followerId);

    List<Follow> findByFollowingId(Long followingId);

    Follow findByFollowerIdAndFollowingId(Long followerId, Long followingId);
}

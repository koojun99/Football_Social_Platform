package com.example.football_community.repository;

import com.example.football_community.entity.Match;
import com.example.football_community.entity.TeamSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamScheduleRepository extends JpaRepository<TeamSchedule, Long> {
    Optional<TeamSchedule> findByMatchesContaining(Match match);
}
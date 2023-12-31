package com.example.football_community.domain.schedule;

import com.example.football_community.domain.match.Match;
import com.example.football_community.domain.team.Team;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TeamSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany
    @JoinColumn(name = "match_id")
    private List<Match> matches;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        if(team.getTeamSchedule() != this) {
            team.setTeamSchedule(this);
        }
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public void addMatch(Match match) {
        matches.add(match);
        match.setTeamSchedule(this);
    }

    public void deleteMatch(Match match) {
        matches.remove(match);
    }
}

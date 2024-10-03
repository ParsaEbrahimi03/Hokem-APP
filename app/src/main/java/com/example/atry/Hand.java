package com.example.atry;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Round> rounds; // دورهای انجام شده در این دست
    private int team1Score; // امتیاز گروه ۱
    private int team2Score; // امتیاز گروه ۲

    public Hand() {
        this.rounds = new ArrayList<>();
        this.team1Score = 0;
        this.team2Score = 0;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void addRound(Round round) {
        rounds.add(round);
    }

    public void updateScore(int team1Points, int team2Points) {
        team1Score += team1Points;
        team2Score += team2Points;
    }
}

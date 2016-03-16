package com.ncaa.java.basketball;

import java.util.ArrayList;

public class Game {

    private long id;
    private String name;
    private Team team1;
    private Team team2;

    private Team winner;

    private float team1Score;
    private float team2Score;

    public Game() {
    }

    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.generateTeamScores();
    }

    private void generateTeamScores() {
        // Start with the power score of each team
        this.team1Score = this.team1.getPowerScore();
        this.team2Score = this.team2.getPowerScore();

        // Get the head-to-head scoring
        // Shooting from the field drives the score
        if (this.team1.getFgPct() > this.team2.getFgPct()) {
            this.team1Score += .1;
        } else {
            this.team2Score += .1;
        }
        // Free throws can win the game
        if (this.team1.getFtPct() > this.team2.getFtPct()) {
            this.team1Score += .1;
        } else {
            this.team2Score += .1;
        }
        // 3 pointers are a big bonus
        if (this.team1.getThreePntPct() > this.team2.getThreePntPct()) {
            this.team1Score += .1;
        } else {
            this.team2Score += .1;
        }
        // Blocks can really deter the other team
        if (this.team1.getBlocksPerGame() > this.team2.getBlocksPerGame()) {
            this.team1Score += .1;
        } else {
            this.team2Score += .1;
        }
        // Turnovers are killers
        if (this.team2.getTurnoversPerGame() > this.team1.getTurnoversPerGame()) {
            this.team1Score += .1;
        } else {
            this.team2Score += .1;
        }
        // Defense wins championships
        if (this.team2.getPtsAgainstPerGame() > this.team1.getPtsAgainstPerGame()) {
            this.team1Score += .1;
        } else {
            this.team2Score += .1;
        }
        // Rebounds affect possession and shot attempts
        if (this.team1.getReboundsPerGame() > this.team2.getReboundsPerGame()) {
            this.team1Score += .1;
        } else {
            this.team2Score += .1;
        }
        // Set the winner
        if (this.team1Score > this.team2Score) {
            this.winner = this.team1;
        } else {
            this.winner = this.team2;
        }

    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public float getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(float team1Score) {
        this.team1Score = team1Score;
    }

    public float getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(float team2Score) {
        this.team2Score = team2Score;
    }

    @Override
    public String toString() {
        return "Game{" + "Team1=" + team1.getName() + ":" + team1Score +
                " " + "Team2=" + team2.getName() + ":" + team2Score  + '}';
    }

}

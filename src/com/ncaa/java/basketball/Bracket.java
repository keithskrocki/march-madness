package com.ncaa.java.basketball;

import java.util.ArrayList;
import java.util.List;

public class Bracket {

    private String region;
    private Round roundOf16;
    private Round roundOf8;
    private Round roundOf4;
    private Round roundOf2;
    private Team champion;

    private List<Team> teams;

    public static final String FIRSTFOUR = "FIRST FOUR";
    public static final String EAST = "EAST";
    public static final String SOUTH = "SOUTH";
    public static final String WEST = "WEST";
    public static final String MIDWEST = "MIDWEST";
    public static final String FINALFOUR = "FINAL FOUR";

    public Bracket() {
    }

    public Bracket(String region) {
        this.region = region;
    }

    public Bracket(String region, int[] teams) {
        this.region = region;

    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Round getRoundOf16() {
        return roundOf16;
    }

    public void setRoundOf16(Round roundOf16) {
        this.roundOf16 = roundOf16;
    }

    public Round getRoundOf8() {
        return roundOf8;
    }

    public void setRoundOf8(Round roundOf8) {
        this.roundOf8 = roundOf8;
    }

    public Round getRoundOf4() {
        return roundOf4;
    }

    public void setRoundOf4(Round roundOf4) {
        this.roundOf4 = roundOf4;
    }

    public Round getRoundOf2() {
        return roundOf2;
    }

    public void setRoundOf2(Round roundOf2) {
        this.roundOf2 = roundOf2;
    }

    public Team getChampion() {
        return champion;
    }

    public void setChampion(Team champion) {
        this.champion = champion;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Team setupRounds() {
        Team champ = null;

        this.roundOf16 = new Round(this.teams);
        this.roundOf8 = new Round(this.roundOf16.getWinners());
        this.roundOf4 = new Round(this.roundOf8.getWinners());
        this.roundOf2 = new Round(this.roundOf4.getWinners());
        champ = this.roundOf2.getWinners().get(0);
        this.champion = champ;

        return champ;
    }

    public Team setup4Rounds() {
        Team champ = null;

        this.roundOf4 = new Round(this.teams);
        this.roundOf2 = new Round(this.roundOf4.getWinners());
        champ = this.roundOf2.getWinners().get(0);
        this.champion = champ;

        return champ;
    }

    @Override
    public String toString() {
        return "Bracket{" + "region=" + region + "}";
    }

}

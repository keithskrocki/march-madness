package com.ncaa.java.basketball;

import java.util.ArrayList;

/**
 * Created by kskrocki on 2/5/16.
 */
public class Team {

    private long id;
    private String name;
    private String nickname;
    private int games;
    private int wins;
    private int losses;
    private int confWins;
    private int confLosses;
    private int homeWins;
    private int homeLosses;
    private int awayWins;
    private int awayLosses;
    private int pointsFor;
    private int pointsAgainst;
    private float simpleRating;
    private float strengthOfSchedule;
    private float winPct;

    private float fgPct;
    private float threePntPct;
    private float ftPct;
    private int rebounds;
    private int blocks;
    private int turnovers;

    private int seed;

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public float getFgPct() {
        return fgPct;
    }

    public void setFgPct(float fgPct) {
        this.fgPct = fgPct;
    }

    public float getThreePntPct() {
        return threePntPct;
    }

    public void setThreePntPct(float threePntPct) {
        this.threePntPct = threePntPct;
    }

    public float getFtPct() {
        return ftPct;
    }

    public void setFtPct(float ftPct) {
        this.ftPct = ftPct;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getConfWins() {
        return confWins;
    }

    public void setConfWins(int confWins) {
        this.confWins = confWins;
    }

    public int getConfLosses() {
        return confLosses;
    }

    public void setConfLosses(int confLosses) {
        this.confLosses = confLosses;
    }

    public int getHomeWins() {
        return homeWins;
    }

    public void setHomeWins(int homeWins) {
        this.homeWins = homeWins;
    }

    public int getHomeLosses() {
        return homeLosses;
    }

    public void setHomeLosses(int homeLosses) {
        this.homeLosses = homeLosses;
    }

    public int getAwayWins() {
        return awayWins;
    }

    public void setAwayWins(int awayWins) {
        this.awayWins = awayWins;
    }

    public int getAwayLosses() {
        return awayLosses;
    }

    public void setAwayLosses(int awayLosses) {
        this.awayLosses = awayLosses;
    }

    public int getPointsFor() {
        return pointsFor;
    }

    public void setPointsFor(int pointsFor) {
        this.pointsFor = pointsFor;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public void setPointsAgainst(int pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }

    public float getSimpleRating() {
        return simpleRating;
    }

    public void setSimpleRating(float simpleRating) {
        this.simpleRating = simpleRating;
    }

    public float getStrengthOfSchedule() {
        return strengthOfSchedule;
    }

    public void setStrengthOfSchedule(float strengthOfSchedule) {
        this.strengthOfSchedule = strengthOfSchedule;
    }

    public float getWinPct() {
        return winPct;
    }

    public void setWinPct(float winPct) {
        this.winPct = winPct;
    }

    public Team() {
    }

    public Team(ArrayList<String> list) {

        try {
            long l = Long.parseLong(list.get(0));

            this.id = l;
            this.name = list.get(1);
            this.games = Integer.parseInt(list.get(2));
            this.wins = Integer.parseInt(list.get(3));
            this.losses = Integer.parseInt(list.get(4));

            this.winPct = Float.parseFloat(list.get(5));
            this.simpleRating = Float.parseFloat(list.get(6));
            this.strengthOfSchedule = Float.parseFloat(list.get(7));

            this.confWins = Integer.parseInt(list.get(8));
            this.confLosses = Integer.parseInt(list.get(9));
            this.homeWins = Integer.parseInt(list.get(10));
            this.homeLosses = Integer.parseInt(list.get(11));
            this.awayWins = Integer.parseInt(list.get(12));
            this.awayLosses = Integer.parseInt(list.get(13));
            this.pointsFor = Integer.parseInt(list.get(14));
            this.pointsAgainst = Integer.parseInt(list.get(15));

            this.fgPct = Float.parseFloat(list.get(20));
            this.threePntPct = Float.parseFloat(list.get(23));
            this.ftPct = Float.parseFloat(list.get(26));

            this.rebounds = Integer.parseInt(list.get(28));
            this.blocks = Integer.parseInt(list.get(31));
            this.turnovers = Integer.parseInt(list.get(32));

        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

    }

    public Team(String name, String nickname, long id) {
        this.name = name;
        this.nickname = nickname;
        this.id = id;
    }

    public Team(String name, String nickname, Object obj) {
        this.name = name;
        this.nickname = nickname;
        if (obj != null) {
            Long longObj = new Long(obj.toString());
            this.setId(longObj);
        }
    }

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", name=" + name +
                ", nickname=" + nickname + '}';
    }

    public float getPtsAgainstPerGame() {
        return ((float)this.pointsAgainst / this.games);
    }

    public float getReboundsPerGame() {
        return ((float)this.rebounds / this.games);
    }

    public float getBlocksPerGame() {
        return ((float)this.blocks / this.games);
    }

    public float getTurnoversPerGame() {
        return ((float)this.turnovers / this.games);
    }

    public float getPowerScore() {
        float ps = 0;

        // Win Percentage is the most important power indicator
        ps = this.winPct;

        // Road wins are much tougher than home wins
        ps+= ((float)this.awayWins / (this.awayWins + this.awayLosses));

        // This rating takes into account strength of schedule and point differential
        ps+= (simpleRating / 50);

        return ps;

    }

    public String getShortname() {
        String shortname = this.name;
        if (this.name.equals("Stephen F. Austin")) {
            shortname = "SF Austin";
        }
        if (this.name.startsWith("Saint")) {
            shortname = shortname.replaceAll("Saint", "St");
        }
        if (this.name.contains("State")) {
            shortname = shortname.replaceAll("State", "St");
        }
        if (this.name.contains("(")) {
            shortname = shortname.replaceAll("[)(]", "");
        }
        if (this.name.startsWith("Arkansas-")) {
            shortname = shortname.replaceAll("Arkansas-", "Ark ");
        }
        if (this.name.startsWith("South") && this.name.contains("State")) {
            shortname = shortname.replaceAll("South", "S ");
        }
        if (this.name.equals("Saint Joseph's")) {
            shortname = "St Joseph's PA";
        }
        if (this.name.equals("Virginia Commonwealth")) {
            shortname = "VA Commonwealth";
        }

        return shortname;
    }

}

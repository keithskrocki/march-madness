package com.ncaa.java.basketball;

import java.util.*;

public class BracketService {

    private List<Team> teamList;

    private Bracket firstFourBracket = new Bracket(Bracket.FINALFOUR);

    private Bracket midwestBracket = new Bracket(Bracket.MIDWEST);
    private Bracket eastBracket = new Bracket(Bracket.EAST);
    private Bracket southBracket = new Bracket(Bracket.SOUTH);
    private Bracket westBracket = new Bracket(Bracket.WEST);

    private Bracket finalFourBracket = new Bracket(Bracket.FINALFOUR);

    public void setupBrackets() throws Exception {
        int[] firstTeamIds = new int[]{119, 290, 178, 319};
        firstFourBracket.setTeams(getTeams(firstTeamIds));
        firstFourBracket.setup4Rounds();
        Team t1 = firstFourBracket.getRoundOf4().getGames().get(0).getWinner();
        Team t2 = firstFourBracket.getRoundOf4().getGames().get(1).getWinner();

        int[] midwestTeamIds = new int[]{331, 177, 323, 132, 248, 273, 72, 313, 36, 298, 109, 14, 131, 99, 179, 113};
        int[] eastTeamIds = new int[]{214, 349, 337, 144, 130, 227, 345, 284,247, 241, (int)t2.getId(), 54, 297, 295, 336, 94};
        int[] southTeamIds = new int[]{141, 327, 175, 45, 169, 13, 133, 64, 66, 299, 342, 279, 116, 35, 208, 20};
        int[] westTeamIds = new int[]{236, 232, 305, 80, 22, 314, 235, 260, 56, 328, 223, 350, 213, 112, 38, (int)t1.getId()};

        // Setup the region brackets
        List<Team> midwestBracketTeams = getTeams(midwestTeamIds);
        List<Team> eastBracketTeams = getTeams(eastTeamIds);
        List<Team> southBracketTeams = getTeams(southTeamIds);
        List<Team> westBracketTeams = getTeams(westTeamIds);
        midwestBracket.setTeams(midwestBracketTeams);
        eastBracket.setTeams(eastBracketTeams);
        southBracket.setTeams(southBracketTeams);
        westBracket.setTeams(westBracketTeams);
        midwestBracket.setupRounds();
        eastBracket.setupRounds();
        southBracket.setupRounds();
        westBracket.setupRounds();

        // Setup the final four bracket
        List<Team> finalfour = new ArrayList<Team>();
        finalfour.add(midwestBracket.getChampion());
        finalfour.add(southBracket.getChampion());
        finalfour.add(westBracket.getChampion());
        finalfour.add(eastBracket.getChampion());
        finalFourBracket.setTeams(finalfour);
        finalFourBracket.setup4Rounds();
    }

    public List<Team> getTeams(int[] ids) throws Exception {
        List<Team> teams = new ArrayList<Team>();
        int index=0;
        for (int id : ids) {
            index++;
            Team team = getTeam(id);
            team.setSeed(index);
            teams.add(getTeam(id));
        }
        return teams;
    }

    public Team getTeam(long id) throws Exception {

        for (Team team: this.getTeamList()) {

            if (team.getId() == id) {
                return team;
            }

        }

        return null;
    }

    // Utility which converts CSV to ArrayList using Split Operation
    public static ArrayList<String> crunchifyCSVtoArrayList(String crunchifyCSV) {
        ArrayList<String> crunchifyResult = new ArrayList<String>();

        if (crunchifyCSV != null) {
            String[] splitData = crunchifyCSV.split("\\s*,\\s*");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    crunchifyResult.add(splitData[i].trim());
                }
            }
        }

        return crunchifyResult;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public Bracket getFirstFourBracket() {
        return firstFourBracket;
    }

    public void setFirstFourBracket(Bracket firstFourBracket) {
        this.firstFourBracket = firstFourBracket;
    }

    public Bracket getMidwestBracket() {
        return midwestBracket;
    }

    public void setMidwestBracket(Bracket midwestBracket) {
        this.midwestBracket = midwestBracket;
    }

    public Bracket getEastBracket() {
        return eastBracket;
    }

    public void setEastBracket(Bracket eastBracket) {
        this.eastBracket = eastBracket;
    }

    public Bracket getSouthBracket() {
        return southBracket;
    }

    public void setSouthBracket(Bracket southBracket) {
        this.southBracket = southBracket;
    }

    public Bracket getWestBracket() {
        return westBracket;
    }

    public void setWestBracket(Bracket westBracket) {
        this.westBracket = westBracket;
    }


    public Bracket getFinalFourBracket() {
        return finalFourBracket;
    }

    public void setFinalFourBracket(Bracket finalFourBracket) {
        this.finalFourBracket = finalFourBracket;
    }
}

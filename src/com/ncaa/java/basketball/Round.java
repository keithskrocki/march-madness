package com.ncaa.java.basketball;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private List<Game> games;

    private List<Team> winners;

    public Round() {
    }

    public Round(List<Team> teams) {
        games = new ArrayList<Game>();
        winners = new ArrayList<Team>();
        for (int x=0; x < (teams.size()/2); x++) {
            Game game = new Game(teams.get(x),teams.get(teams.size()-x-1));
            games.add(game);
            winners.add(game.getWinner());
        }
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Team> getWinners() {
        return winners;
    }

    public void setWinners(List<Team> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return "Round{" + "games=" + games.size() + "}";
    }

}

package com.ncaa.java.basketball;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
        name = "BracketServlet",
        urlPatterns = {"/team"}
)

/**
 * Created by kskrocki on 2/5/16.
 */
public class BracketServlet extends HttpServlet {
    
    BracketService bracketService = new BracketService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            List<Team> teamList = readData();

            req.setAttribute("teamList", teamList);
            bracketService.setTeamList(teamList);
            bracketService.setupBrackets();
            this.writeData();

            req.setAttribute("midwestBracket", bracketService.getMidwestBracket());
            req.setAttribute("southBracket", bracketService.getSouthBracket());
            req.setAttribute("eastBracket", bracketService.getEastBracket());
            req.setAttribute("westBracket", bracketService.getWestBracket());
            req.setAttribute("finalFourBracket", bracketService.getFinalFourBracket());

            String nextJSP = "/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger.getLogger(BracketServlet.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public List<Team> readData() {

        ArrayList<Team> teamList = new ArrayList<Team>();
        BufferedReader crunchifyBuffer = null;

        try {
            String crunchifyLine;
            InputStream is = getServletContext().getResourceAsStream("/data/2016-stats.csv");
            crunchifyBuffer = new BufferedReader(new InputStreamReader(is));

            // Read the stats file line by line
            while ((crunchifyLine = crunchifyBuffer.readLine()) != null) {
                Team team = new Team(bracketService.crunchifyCSVtoArrayList(crunchifyLine));
                teamList.add(team);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (crunchifyBuffer != null) crunchifyBuffer.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }

        return teamList;
    }

    public void writeData() {

        try {
            // Create a local file to add the data to
            FileWriter writer = new FileWriter("/tmp/final-four-results.csv");

            this.writeTeams(writer, bracketService.getMidwestBracket().getRoundOf16().getWinners());
            this.writeTeams(writer, bracketService.getWestBracket().getRoundOf16().getWinners());
            this.writeTeams(writer, bracketService.getEastBracket().getRoundOf16().getWinners());
            this.writeTeams(writer, bracketService.getSouthBracket().getRoundOf16().getWinners());
            writer.append('\n');
            this.writeTeams(writer, bracketService.getMidwestBracket().getRoundOf8().getWinners());
            this.writeTeams(writer, bracketService.getWestBracket().getRoundOf8().getWinners());
            this.writeTeams(writer, bracketService.getEastBracket().getRoundOf8().getWinners());
            this.writeTeams(writer, bracketService.getSouthBracket().getRoundOf8().getWinners());
            writer.append('\n');
            this.writeTeams(writer, bracketService.getMidwestBracket().getRoundOf4().getWinners());
            this.writeTeams(writer, bracketService.getWestBracket().getRoundOf4().getWinners());
            this.writeTeams(writer, bracketService.getEastBracket().getRoundOf4().getWinners());
            this.writeTeams(writer, bracketService.getSouthBracket().getRoundOf4().getWinners());
            writer.append('\n');
            this.writeTeams(writer, bracketService.getMidwestBracket().getRoundOf2().getWinners());
            this.writeTeams(writer, bracketService.getWestBracket().getRoundOf2().getWinners());
            this.writeTeams(writer, bracketService.getEastBracket().getRoundOf2().getWinners());
            this.writeTeams(writer, bracketService.getSouthBracket().getRoundOf2().getWinners());
            writer.append('\n');
            this.writeTeams(writer, bracketService.getFinalFourBracket().getRoundOf4().getWinners());
            writer.append('\n');
            this.writeTeams(writer, bracketService.getFinalFourBracket().getRoundOf2().getWinners());
            writer.append('\n');

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeTeams(FileWriter writer, List<Team> teams) throws IOException {
        for (Team tm : teams) {
            writer.append(tm.getShortname().replaceAll("&amp;", "&"));
            writer.append(',');
        }
    }

}

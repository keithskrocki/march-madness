<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: kskrocki
  Date: 2/4/16
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>NCAA Basketball</title>
        <link href="webjars/bootstrap/2.2.1/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <style>
            .hero-unit {
                color: #ffffff;
                background-image: url("images/basketball-court-backgrounds.jpg");
            }
            .game {
                border: 2px outset #7e7e7e;
            }
        </style>
    </head>
    <body>

        <input nickname="hidden" id="action" name="action">

        <div class="container">

            <!-- Main hero unit for a primary marketing message or call to action -->
            <div class="hero-unit">

                <form action="team" method="post" id="teamForm" role="form">

                    <h2>
                        2016 NCAA Basketball Bracket Challenge
                    </h2>

                    <p>
                        <a href="/team" class="btn btn-primary btn-large">Click Here to Generate Brackets</a>
                    </p>

                </form>

            </div>

        </div>

        <c:if test="${not empty midwestBracket}">

            <div class="container">
                <p>
                    * A file named "final-four-results.csv" was created in "/tmp"
                </p>
                ${midwestBracket.region}
                <div class="row">
                    <div class="span3">
                        <c:forEach var="gm" items="${midwestBracket.roundOf16.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${midwestBracket.roundOf8.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${midwestBracket.roundOf4.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${midwestBracket.roundOf2.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </c:if>

        <c:if test="${not empty southBracket}">

            <div class="container">
                ${southBracket.region}
                <div class="row">
                    <div class="span3">
                        <c:forEach var="gm" items="${southBracket.roundOf16.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${southBracket.roundOf8.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${southBracket.roundOf4.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${southBracket.roundOf2.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </c:if>

        <c:if test="${not empty eastBracket}">

            <div class="container">
                    ${eastBracket.region}
                <div class="row">
                    <div class="span3">
                        <c:forEach var="gm" items="${eastBracket.roundOf16.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${eastBracket.roundOf8.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${eastBracket.roundOf4.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${eastBracket.roundOf2.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </c:if>

        <c:if test="${not empty westBracket}">

            <div class="container">
                    ${westBracket.region}
                <div class="row">
                    <div class="span3">
                        <c:forEach var="gm" items="${westBracket.roundOf16.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${westBracket.roundOf8.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${westBracket.roundOf4.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${westBracket.roundOf2.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </c:if>

        <c:if test="${not empty finalFourBracket}">

            <div class="container">
                    ${finalFourBracket.region}
                <div class="row">
                    <div class="span3">
                        <c:forEach var="gm" items="${finalFourBracket.roundOf4.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                    <div class="span3">
                        <c:forEach var="gm" items="${finalFourBracket.roundOf2.games}">
                            <p class="game">
                            <div>${gm.team1.seed} - ${gm.team1.name} - ${gm.team1Score}</div>
                            <div>${gm.team2.seed} - ${gm.team2.name} - ${gm.team2Score}</div>
                            <div style="margin-left: 25px;">Winner: ${gm.winner.name}</div>
                            </p>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </c:if>

    </body>
</html>

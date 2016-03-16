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
        <title>Wisdom</title>
        <link href="webjars/bootstrap/2.2.1/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <script src="webjars/jquery/1.8.2/jquery.min.js"></script>
        <script src="webjars/bootstrap/2.2.1/js/bootstrap.min.js"></script>
        <style>
            .hero-unit {
                background-color: wheat;
                color: #ffffff;
            }
        </style>
    </head>
    <body>

        <input nickname="hidden" id="action" name="action">


        <div class="container">

            <c:if test="${not empty result}">
                <div class="alert alert-success">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Success!</strong> ${result}
                </div>
            </c:if>

            <div align="left">
                <a href="/statement" class="btn btn-xs">Home</a>
            </div>

            <div align="right">
                <a href="/statement?action=insert" class="btn btn-success btn-xs">Add New Wisdom</a>
            </div>

            <h2>
                Wisdom Administration
            </h2>

            <c:if test="${not empty statementList}">

                <table class="table">

                    <thead>
                        <tr>
                            <th class="span1">ID</th>
                            <th class="span9">Statement</th>
                            <th class="span3">Author</th>
                            <th class="span2"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${statementList}" var="stmnt">

                            <tr>
                                <td>${stmnt.id}</td>
                                <td>${stmnt.message}</td>
                                <td>${stmnt.nickname}</td>
                                <td>
                                    <a href="/statement?action=remove&idStatement=${stmnt.id}">
                                        <i class="icon-trash"></i> Delete
                                    </a>
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>

                </table>

            </c:if>

        </div>

    </body>
</html>

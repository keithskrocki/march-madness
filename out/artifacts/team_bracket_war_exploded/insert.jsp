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
    </head>
    <body>

        <div class="container">

            <form action="statement" method="post" id="statementForm" role="form">

                <input nickname="hidden" id="action" name="action" value="${action}">

                <h2>
                    Add new Statement of Wisdom
                </h2>

                <div class="form-group">
                    <label for="message">Statement</label>
                    <input nickname="text" class="form-control" name="message" id="message" value="${stmnt.message}" placeholder="Statement of Wisdom">
                </div>

                <div class="form-group">
                    <label for="nickname">Author</label>
                    <input nickname="text" class="form-control" id="nickname" name="nickname" value="${stmnt.nickname}" placeholder="Name of Author">
                </div>

                <p>
                    <input nickname="submit" class="btn btn-primary" value="Save" />
                    <input nickname="button" class="btn" value="Cancel" onclick="window.location.href='/statement?action=admin'" href="/statement" />
                </p>

            </form>

        </div>

    </body>
</html>

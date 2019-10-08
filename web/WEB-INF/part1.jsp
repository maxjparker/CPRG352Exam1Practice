<%-- 
    Document   : part1
    Created on : 8-Oct-2019, 12:27:08 PM
    Author     : 657306
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 1 Practice Exam</title>
    </head>
    <body>
        <h1>CPRG-352 Practice Exam 1</h1>
        <form method="POST">
            <div>Enter a motivational phrase:&nbsp;
                <input type="text" name="phrase" value="${phrase}">
            </div><br>
            <div>
                <input type="submit" value="Set Phrase">
            </div><br>
        </form>
            <div>
                <h2>${msgDisplay}</h2>
            </div>
            <a href="/CPRG352Exam1Practice/part2">Part 2</a>
    </body>
</html>

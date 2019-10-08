<%-- 
    Document   : part2
    Created on : 8-Oct-2019, 12:48:20 PM
    Author     : 657306
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 2</title>
    </head>
    <body>
        <h1>CPRG-352 Practice Exam 1</h1>
        <h2>${msgDisplay}</h2>
        <form method="POST">
            <div>
                Name: <input type="text" name="name" value="">
            </div><br>
            <div>
                Age: <input type="text" name="age" value="">
            </div><br>
            <input type="submit" value="Add">
        </form>
        <div>
            Average age: ${avgAge}
        </div>
    </body>
</html>

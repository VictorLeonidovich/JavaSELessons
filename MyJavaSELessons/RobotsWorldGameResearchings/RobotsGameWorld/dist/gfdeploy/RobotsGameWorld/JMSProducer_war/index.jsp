<%-- 
    Document   : index
    Created on : 27.12.2017, 22:20:53
    Author     : Victor
--%>

<%@ page language="java" contentType="text/html; 
         charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script src="js/jquery-3.2.1.js"
        type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                receiveLogMessages();
                setInterval('receiveLogMessages()', 5000);
            });
            function receiveLogMessages() {
                $.ajax({
                    url: "loggerfacade",
                    success: function (response) {
                        $('#receiveJMS').html(response);
                    }
                })

            }
            ;

        </script>

        <title>TODO supply a title</title>
        <meta http-equiv="Content-Type" 
              content="text/html; UTF-8">
    </head>
    <body>
        <p></p>
        <form method="POST" action="taskservletdispatcher">
            <input type="text" name="task"/>
            <select name="type">
                <option>Queue</option>
                <option>Topic</option>
            </select>
            <input type="submit"/>

        </form>
        <%--<form method="POST" action="loggerfacade">
            <p>Получите сообщения из очереди:</p>
            <input type="submit" value="Получить" onclick="receiveLogMessages()"><p/>
        </form>--%>
        <span id="receiveJMS" style="color: #7349a4;"> here </span>
    </body>
</html>

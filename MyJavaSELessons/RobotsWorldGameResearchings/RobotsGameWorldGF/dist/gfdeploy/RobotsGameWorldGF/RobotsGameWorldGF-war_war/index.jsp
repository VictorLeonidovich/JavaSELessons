<%-- 
    Document   : index
    Created on : 06.01.2018, 14:32:10
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                        $('#receiveLog').html(response);
                    }
                })
            }
            ;
        </script>

        <title>Robots Game World main page</title>
    </head>
    <body>
        <a href="index2.jspx">index2</a>
        <p></p>
        <form method="POST" action="servlettaskreciever">
            <input type="text" name="task"/>
            <select name="type">
                <option>Queue</option>
                <option>Topic</option>
            </select>
            <input type="submit"/>
        </form>
        <span id="receiveLog" style="color: #7349a4;"> here </span>
    </body>
</html>

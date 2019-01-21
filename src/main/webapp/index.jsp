<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" type="text/css" href="/style" media="all">
<html>
<head>
    <title>Train App</title>
    <form action="LoginServlet" method="post">
        <table align="center" >
            <caption>Admin panel</caption>
            <tr>
                <td>Login: </td>
                <td><input type="text" name = "login" style="width: 100%"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password" style="width: 100%"></td>
            </tr>
            <tr>
                <td>Submit:</td>
                <td><input type="submit" value="Login" style="width: 100%"></td>
            </tr>

        </table>
    </form>
    <form action="FirstServlet">
        <table align="center">
            <caption>Buy Panel</caption>
            <tr>
                <td style="width: 35%">Buy Ticket:</td>
                <td><input type="submit" value="Buy!" style="width: 100%"></td>
            </tr>

        </table>
    </form>
</head>
<body>

</body>
</html>

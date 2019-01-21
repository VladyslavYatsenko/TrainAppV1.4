<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/style" media="all">
<html>
<head>
    <title>Choose Ticket</title>
</head>
<body>
<form action="UsersTrainsServlet">
    <table align="center" border="2">
        <caption>Choose Train</caption>
        <tr>
            <td>Choose Initial Station :</td>
            <td>
                <select name="initialStation" style="width: 100%">
                    <c:forEach var="trainsInitialStation" items="${trainsInitialStation}">
                        <option>${trainsInitialStation.toString()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Choose End Station :</td>
            <td>
                <select name="endStation" style="width: 100%" >
                    <c:forEach var="trainsEndStation" items="${trainsEndStation}">
                        <option>${trainsEndStation.toString()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td >Choose Date:</td>
            <td><input type="date" name="date" style="width: 100%"></td>
        </tr>
        <tr>
            <td >Choose Time:</td>
            <td><input type="time" name="time" style="width: 100%"></td>
        </tr>
        <tr>
            <td >Confirm</td>
            <td><input type="submit" value="Find" style="width: 100%">
        </tr>

    </table>
</form>

</body>
</html>

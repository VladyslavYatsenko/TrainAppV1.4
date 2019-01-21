<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/style" media="all">

<html>
<head>
    <title>Registration of Ticket</title>
</head>

<body>

<form action="TicketRegistrationServlet">
    <table align="center">
        <br>
        <thead>
        <tr>
            <th>#Train Id</th>
            <th>Train Number</th>
            <th>Initial Station</th>
            <th>End Station</th>
            <th>Cost</th>
            <th>Departure Date</th>
            <th>Departure Time</th>
            <th>Arrival Date</th>
            <th>Arrival Time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="t" items="${trainsList}">
            <tr>
                <td align="center">${t.trainId}</td>
                <td align="center">${t.trainNumber}</td>
                <td align="center">${t.initialStation}</td>
                <td align="center">${t.endStation}</td>
                <td align="center">${t.cost} UAH</td>
                <td align="center">${t.departureDate}</td>
                <td align="center">${t.departureTime}</td>
                <td align="center">${t.arrivalDate}</td>
                <td align="center">${t.arrivalTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <table align="center">
        <caption>Choose your ticket</caption>
        <tr>
            <td>Choose Train id:</td>
            <td>
                <select name="trainId" style="width: 100%">
                    <c:forEach var="t" items="${trainsList}">
                        <option>${t.trainId}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td align="center">Input your name:</td>
            <td align="center"><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td align="center">Input your last name:</td>
            <td align="center"><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td>Send</td>
            <td align="center"><input type="submit" value="Send" style="width: 100%"></td>
        </tr>
    </table>


</form>
</table>

</body>

</html>

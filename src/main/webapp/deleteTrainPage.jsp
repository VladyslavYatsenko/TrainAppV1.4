<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/style" media="all">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creation Ticket</title>
</head>
<body>
<form action="DeleteTrainServlet" method="get">
    <table align="center">
        <caption>Delete Train Panel</caption>
        <tr>
            <td>Input Train Id:</td>
            <td>
                <select name="chooseTrainId" style="width: 100%">
                    <c:forEach var="train" items="${trainsId}">
                        <option>${train}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="submit" value="delete"></td>
        </tr>
    </table>
    <table align="center">
        <H3 align="center">Trains List:</H3>
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
        <c:forEach var="train" items="${trainsList}">
            <tr>
                <td align="center">${train.trainId}</td>
                <td align="center">${train.trainNumber}</td>
                <td align="center">${train.initialStation}</td>
                <td align="center">${train.endStation}</td>
                <td align="center">${train.cost}</td>
                <td align="center">${train.departureDate}</td>
                <td align="center">${train.departureTime}</td>
                <td align="center">${train.arrivalDate}</td>
                <td align="center">${train.arrivalTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>

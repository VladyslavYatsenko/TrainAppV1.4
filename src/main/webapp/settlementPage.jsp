<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/style" media="all">
<html>
<head>
    <title>Settlement Page</title>
</head>
<body>

<form action="SettlementServlet " method="get">
    <p align="center">Dear <strong>${firstName} ${lastName}</strong>, your ticket is</p>
    <table border="2" bgcolor="#dc143c" cellpadding="2" cellspacing="0" align="center">
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
            <th>#</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td align="center">${userTrain.trainId}</td>
            <td align="center">${userTrain.trainNumber}</td>
            <td align="center">${userTrain.initialStation}</td>
            <td align="center">${userTrain.endStation}</td>
            <td align="center">${userTrain.cost}</td>
            <td align="center">${userTrain.departureDate}</td>
            <td align="center">${userTrain.departureTime}</td>
            <td align="center">${userTrain.arrivalDate}</td>
            <td align="center">${userTrain.arrivalTime}</td>
            <td align="center"><input type="submit" value="Pay?" style="width: 100%;"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>

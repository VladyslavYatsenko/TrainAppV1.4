<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/style" media="all">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creation Ticket</title>
</head>
<body>
<form action="DeleteTrainServlet">
    <table align="center">
        <caption>Create Passenger Panel</caption>
        <tr>
            <td>Input Passenger Id:</td>
            <td>
                <select name="passengerId" style="width: 100%">
                    <c:forEach var="passengerId" items="${passengersId}">
                        <option>${passengerId}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Delete</td>
            <td>
                <input type="submit" value="Delete Passanger" style="width: 100%">
            </td>
        </tr>
    </table>
    <table align="center">
        <H3 align="center">Passangers List</H3>
        <thead>
        <tr>
            <th>#Passenger Id</th>
            <th>Passenger First Name</th>
            <th>Passenger Last Name</th>
            <th>Number Of Train(Train_id)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="passanger" items="${passengersList}">
            <tr>
                <td align="center">${passanger.passangerId}</td>
                <td align="center">${passanger.firstName}</td>
                <td align="center">${passanger.lastName}</td>
                <td align="center">${passanger.trainId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>

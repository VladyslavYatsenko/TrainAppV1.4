<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/style" media="all">
<html>
<head>
    <title>Admin page</title>
</head>
<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/index.jsp");
    }
%>
Welcome ${username}
<table align="center">
    <tr>
        <td><a href="index.jsp" type="">Initial Page</a></td>
        <td><a href="adminPage.jsp">Admin Page</a></td>
        <td><a href="registrationPage.jsp">Registration Page</a></td>
        <td><a href="settlementPage.jsp">Settlement Page</a></td>
        <td><a href="chooseTrainPage.jsp">Choose Train Page</a></td>
    </tr>
</table>
<form action="AdminTrainsServlet" method="post">
    <input type="submit" value="Create Train">
</form>
<form action="LogoutServlet">
    <input type="submit" value="Logout">
</form>
<form action="AdminTrainsServlet">
    <input type="submit" value="Show Project Information" align="center">
    <table>
        <H3>Trains List:</H3>
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
        <c:forEach var="train" items="${fullTrainsList}">
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
    <table>
        <H3>Passangers List</H3>
        <thead>
        <tr>
            <th>#Passanger Id</th>
            <th>Passanger First Name</th>
            <th>Passanger Last Name</th>
            <th>Number Of Train(Train_id)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="passanger" items="${fullPassangersList}">
            <tr>
                <td align="center">${passanger.passangerId}</td>
                <td align="center">${passanger.firstName}</td>
                <td align="center">${passanger.lastName}</td>
                <td align="center">${passanger.trainId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <H3>Orders List</H3>
        <thead>
        <tr>
            <th>#Order ID</th>
            <th>Train ID</th>
            <th>Passanger ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${fullOrdersList}">
            <tr>
                <td align="center">${order.orderId}</td>
                <td align="center">${order.trainId}</td>
                <td align="center">${order.passangerId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>


</body>
</html>

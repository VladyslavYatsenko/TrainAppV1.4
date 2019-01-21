<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/style" media="all">
<html>
<head>
    <title>Creation Ticket</title>
</head>
<body>
<form action="CreateTrainServlet" method="post">
    <table align="center">
        <caption>Create Train Panel</caption>
        <tr>
            <td>Input Train Number:</td>
            <td> <input type="number" name="trainNumber" style="width: 100%"></td>
        </tr>
        <tr>
            <td>Input Initial Station:</td>
            <td> <input type="text" name="initialStation" style="width: 100%"></td>
        </tr>
        <tr>
            <td>Input End Station:</td>
            <td> <input type="text" name="endStation" style="width: 100%"></td>
        </tr>
        <tr>
            <td>Input Cost:</td>
            <td> <input type="text" name="cost" style="width: 100%"></td>
        </tr>
        <tr>
            <td>Departure Date:</td>
            <td> <input type="date" name="departureDate" style="width: 100%"></td>
        </tr>
        <tr>
            <td>Departure Time:</td>
            <td> <input type="time" name="departureTime" style="width: 100%"></td>
        </tr>
        <tr>
            <td>Arrival Date:</td>
            <td> <input type="date" name="arrivalDate" style="width: 100%"></td>
        </tr>
        <tr>
            <td>Arrival Time:</td>
            <td> <input type="time" name="arrivalTime" style="width: 100%"></td>

        </tr>
        <tr>
            <td>Create</td>
            <td>
                <input type="submit" value="Create Train" style="width: 100%">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

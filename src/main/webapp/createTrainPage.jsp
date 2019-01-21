<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creation Ticket</title>
</head>
<body>
<form action="CreateTrainServlet" method="post">
    <table border="2" bgcolor="#dc143c" cellpadding="2" cellspacing="0">

        <tr>
            <td><H3>Create Train</H3></td>
        </tr>
        <tr>
            <td>Input train Number:</td>
            <td> <input type="number" name="trainNumber"></td>
        </tr>
        <tr>
            <td>Input initial Station:</td>
            <td> <input type="text" name="initialStation"></td>
        </tr>
        <tr>
            <td>Input end Station:</td>
            <td> <input type="text" name="endStation"></td>
        </tr>
        <tr>
            <td>Input Cost:</td>
            <td> <input type="text" name="cost"></td>
        </tr>
        <tr>
            <td>Departure Date:</td>
            <td> <input type="date" name="departureDate"></td>
        </tr>
        <tr>
            <td>Departure Time:</td>
            <td> <input type="time" name="departureTime"></td>
        </tr>
        <tr>
            <td>Arrival Date:</td>
            <td> <input type="date" name="arrivalDate"></td>
        </tr>
        <tr>
            <td>Arrival Time:</td>
            <td> <input type="time" name="arrivalTime"></td>

        </tr>
        <tr>
            <td>
                <input type="submit" name="Create Train">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

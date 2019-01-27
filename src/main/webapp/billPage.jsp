<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Check</title>
    <style>
        table{
            margin: auto;

        }
    </style>
</head>
<body>
<table border="1"  bgcolor="yellow" cellpadding="2" cellspacing="3">
    <h3 align="center">Here your Ticket(You can print it)</h3></p>
    <tr>
        <td>First Name</td>
        <td>${passangerFirstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${passangerLastName}</td>
    </tr>
    <tr>
        <td>Train Number</td>
        <td> ${trainNumber}</td>
    </tr>

    <tr>
        <td>Initial Station</td>
        <td>${initialStation} </td>
    </tr>
    <tr>
        <td>End Station</td>
        <td>${endStation} </td>
    </tr>
    <tr>
        <td>Departure Date</td>
        <td>${departureDate} </td>
    </tr>
    <tr>
        <td>Departure Time</td>
        <td>${departureTime} </td>
    </tr>
    <tr>
        <td>Arrival Date</td>
        <td>${arrivalDate} </td>
    </tr>
    <tr>
        <td>Arrival Time</td>
        <td>${arrivalTime} </td>
    </tr>
    <tr>
        <td>Cost</td>
        <td>${cost} UAH</td>
    </tr>
    <tr>
        <td ><input style="width: 100%" type="button" value="Print Ticket" onclick="window.print();"></td>
        <td   width="130px" height="130px" >
            <img  src="1.jpg" alt="Bar-Code"
                  height="130px" width="100%"  ></td>
    </tr>

</table>
</table>
</body>
</html>
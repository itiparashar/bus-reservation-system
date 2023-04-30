<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>BUSBooking</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h4><font color="red">${errorMessage}</font></h4>
	<h4><font color="green">${successMessgae}</font></h4>
	<c:if test="${not empty  ticketBookingDTO}">
	<div id="bookedTicketDiv" style="border: 5px; border-color: black; height: 50%; width:30%;">
	<button type="button" value="Back" id="backButton" onclick="goBackUrl()"> Back </button>
	<table class="table table-striped table-bordered" cellspacing="0" width="100%">
		<caption>Booked Ticket Details</caption>
		<tr>
			<th>Passenger Name </th>
			<th>Passenger ID </th>
			<th>Payment Mode </th>
			 <th>Bus No.</th>
			 <th>Bus Name</th>
			 <th>From City </th>
			 <th>To City </th>
             <th>Journey Date</th>
             <th>Travel Duration </th>
             <th>Ticket Price </th>
		</tr>
		<c:if test="${not empty  ticketBookingDTO}">
			<tr>
				<td>${ticketBookingDTO.passengerFirstName}</td>
				<td>${ticketBookingDTO.passengerId}</td>
				<td>${ticketBookingDTO.paymentMode}</td>
				<td>${ticketBookingDTO.busNo}</td>
				<td>${ticketBookingDTO.busName}</td>
				<td>${ticketBookingDTO.fromCity}</td>
				<td>${ticketBookingDTO.toCity}</td>
				<td>${ticketBookingDTO.journeyDate}</td>
				<td>${ticketBookingDTO.travelDuration}</td>
				<td>${ticketBookingDTO.ticketPrice}</td>
			</tr>
		</c:if>
	</table>
</div>
</c:if>
<script>
function goBackUrl() {
	  window.location='/busReport';
	}
</script>
 <!-- Footer Start -->
                    <jsp:include page="footer.jsp" />
                    <!-- Footer End -->
</body>
</html>
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
                    <font color="red">${errorMessage}</font>
                    <c:if test="${not empty  ticketBookingDTOList}">
                        <div id="ticketHistoryDiv">
                            <table id="tableTicketHistory" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <caption>Booked Ticket List</caption>
                                <thead>
                                    <tr>
                                        <th>Bus No.</th>
                                        <th>Passenger ID </th>
                                        <th>Payment Mode </th>
                                        <th>To City </th>
                                        <th>Journey Date</th>
                                        <th>Travel Duration </th>
                                        <th>Ticket Price </th>
                                        <th>Total Seats </th>
                                        <th>Available Seats </th>
                                       <!--  <th>Action </th> -->
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="ticketBookingDTOList" items="${ticketBookingDTOList}">
                                        <tr>
                                            <td>${ticketBookingDTOList.bus.busNo}</td>
                                            <td>${ticketBookingDTOList.passengerId}</td>
                                            <td>${ticketBookingDTOList.payment.paymentMode}</td>
                                            <td>${ticketBookingDTOList.bus.toCity}</td>
                                            <td>${ticketBookingDTOList.bus.journeyDate}</td>
                                            <td>${ticketBookingDTOList.bus.travelDuration}</td>
                                            <td>${ticketBookingDTOList.bus.ticketPrice}</td>
                                            <td>${ticketBookingDTOList.bus.totalSeats}</td>
                                            <td>${ticketBookingDTOList.bus.availableSeats}</td>
                                            <%-- <c:choose>
                                                <c:when test="${userDtl.userType eq 'Admin'}">
                                                    <td> <button type="button" class="btn button-wine" style="margin-right:16px;">
													<a  class="text-white" href="/deleteBus?busId=${busList.id}">Delete Product</a>
												</button></td>
                                                </c:when>
                                                <c:when test="${userDtl.userType eq 'Customer'}">
                                                    <c:if test="${busList.availableSeats==0 }">
                                                        <td>
                                                            <font color="red">Sorry, No seats Available.</font>
                                                        </td>
                                                    </c:if>
                                                    <c:if test="${busList.availableSeats>0 }">
                                                        <td> <button type="button" class="btn button-wine" style="margin-right:16px;">
														<a  class="text-white" href="/bookTicket?busId=${busList.id}">Book Ticket</a>
													</button></td>
                                                    </c:if>

                                                </c:when>
                                                <c:otherwise>
                                                    <td>-</td>
                                                </c:otherwise>
                                            </c:choose> --%>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                    <!-- Footer Start -->
                    <jsp:include page="footer.jsp" />
                    <!-- Footer End -->
                </body>

                </html>
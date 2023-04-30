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
                    <c:if test="${ not empty busList}">
                        <div id="busReportDiv">
                            <table id="tableBusReport" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <caption>Bus Report List</caption>
                                <thead>
                                    <tr>
                                        <th>Bus No.</th>
                                        <th>Bus Name </th>
                                        <th>From City </th>
                                        <th>To City </th>
                                        <th>Journey Date</th>
                                        <th>Travel Duration </th>
                                        <th>Ticket Price </th>
                                        <th>Total Seats </th>
                                        <th>Available Seats </th>
                                        <c:if test="${userDtl.userType eq 'Admin'}">
                                            <th>Driver Detail </th>
                                        </c:if>

                                        <th>Action </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="busList" items="${busList}">
                                        <tr>
                                            <td>${busList.busNo}</td>
                                            <td>${busList.busName}</td>
                                            <td>${busList.fromCity}</td>
                                            <td>${busList.toCity}</td>
                                            <td>${busList.journeyDate}</td>
                                            <td>${busList.travelDuration}</td>
                                            <td>${busList.ticketPrice}</td>
                                            <td>${busList.totalSeats}</td>
                                            <td>${busList.availableSeats}</td>
                                            <c:if test="${userDtl.userType eq 'Admin'}">
                                                <td><a href="/driverDetail?busId=${busList.id}">show</a></td>
                                            </c:if>
                                            <c:choose>
                                                <%-- <c:when  test ="${userDtl.userType eq 'Admin'}">
					<td><a
					href="/deleteBus?busId=${busList.id}">Delete Bus</a></td>
					</c:when> --%>
                                                    <%-- <c:when  test ="${userDtl.userType eq 'Customer'}"> --%>
                                                        <c:when test="${not empty userDtl}">
                                                            <c:if test="${busList.availableSeats==0 }">
                                                                <td>
                                                                    <font color="red">Sorry, No seats Available.</font>
                                                                </td>
                                                            </c:if>
                                                            <c:if test="${busList.availableSeats>0 }">
                                                                <td>
                                                                    <button type="button" class="btn button-wine" style="margin-right:16px;">
																		<a class="text-white" href="/bookTicket?busId=${busList.id}">Book Ticket</a>
																	</button>
                                                                </td>
                                                            </c:if>
                                                        </c:when>
                                                        <c:otherwise>
                                                         	<c:if test="${busList.availableSeats==0 }">
                                                                <td>
                                                                    <font color="red">Sorry, No seats Available.</font>
                                                                </td>
                                                            </c:if>
                                                            <c:if test="${busList.availableSeats>0 }">
                                                                <td>
                                                                    <button type="button" class="btn button-wine" style="margin-right:16px;">
																		<a class="text-white" href="/login">Book Ticket</a>
																	</button>
                                                                </td>
                                                            </c:if>
                                                        </c:otherwise>
                                            </c:choose>
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
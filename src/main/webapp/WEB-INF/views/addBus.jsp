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
                    <!-- Add BUS NEW DESIGN START-->
                    <div class="container containerAddBus">
                        <form:form id="addBusDtl" class="formBox" action="addBusDetail" method="post" modelAttribute="bus">
                            <h3>Add Bus</h3>
                            <h4>Fill the form to add Bus</h4>
                            <fieldset>
                                <form:input placeholder="Bus Number" type="text" path="busNo" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <fieldset>
                                <form:input placeholder="Bus Name" type="text" path="busName" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <fieldset>
                                <form:input placeholder="From City" type="text" path="fromCity" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <fieldset>
                                <form:input placeholder="To City" type="text" path="toCity" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <fieldset>
                                <p>Journey Date</p>
                                <form:input placeholder="Journey Date" type="date" path="journeyDate" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <fieldset>
                                <form:input placeholder="Travel Duration" type="text" path="travelDuration" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <fieldset>
                                <form:input placeholder="Ticket Price" type="text" path="ticketPrice" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <fieldset>
                                <form:input placeholder="Total Seats" type="text" path="totalSeats" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <fieldset>
                                <form:input placeholder="Available Seats" type="text" path="availableSeats" maxlength="255" autocomplete="off" />
                            </fieldset>
                            
                            <fieldset>
                                <button name="submit" type="submit" value="submit" id="contact-submit" data-submit="...Sending">Submit</button>
                            </fieldset>
                            </form>
                        </form:form>
                    </div>
                    <!-- Add BUS NEW DESIGN END -->

                    <!-- Footer Start -->
                    <jsp:include page="footer.jsp" />
                    <!-- Footer End -->
                </body>

                </html>
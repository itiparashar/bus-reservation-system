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
                    <!-- Add BUS NEW DESIGN START -->
                    <div class="container containerAddBus">
                        <form:form id="addDriverDetail" class="formBox" action="addDriverDetail" method="post" modelAttribute="driver">
                            <h3>Add Driver</h3>
                            <h4>Fill the form to Add Drivers for Bus</h4>
                            <fieldset>
                                <p>Select Bus</p>
                                <div class="select">
                                    <form:select placeholder="Select Bus" type="text" path="busId">
                                        <c:forEach var="busList" items="${busList}">
                                            <option value="${busList.id}"> ${busList.busName} </option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </fieldset>
                            <fieldset>
                                <form:input type="text" placeholder="Driver First Name" path="driverFirstName" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <fieldset>
                                <form:input type="text" placeholder="Driver Last Name" path="driverLastName" maxlength="255" autocomplete="off" />
                            </fieldset>
                            <%-- <fieldset>
                                <form:input type="text" placeholder="Driver Email" path="passengerEmail" maxlength="255" autocomplete="off" />
                            </fieldset>--%>
                                <fieldset>
                                    <form:input type="text" placeholder="Driver ID" path="driverId" maxlength="255" autocomplete="off" />
                                </fieldset>
                                <fieldset>
                                    <p> Select Driver Gender</p>
                                    <div class="select">
                                        <form:select placeholder="Driver Gender" type="text" path="driverGender">
                                            <option value="male"> Male </option>
                                            <option value="female"> Female </option>
                                            <option value="other"> Other </option>
                                        </form:select>
                                    </div>
                                </fieldset>
                                <fieldset>
                                    <form:input type="number" placeholder="Driver Age" path="driverAge" maxlength="3" autocomplete="off" />
                                </fieldset>
                                <fieldset>
                                    <button name="submit" type="submit" value="submit" id="contact-submit" data-submit="...Sending">Submit</button>
                                </fieldset>
                        </form:form>
                    </div>
                    <!-- Add BUS NEW DESIGN END -->
                    <jsp:include page="footer.jsp" />
                </body>

                </html>
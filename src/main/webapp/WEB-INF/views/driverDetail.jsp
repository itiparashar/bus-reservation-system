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
                    <c:if test="${not empty  driverList}">
                        <div id="driverDetailDiv">
                            <table id="tableDriverDetails" style="margin: auto;" border="1">
                                <caption>Bus Report List</caption>
                                <thead>
                                    <tr>
                                        <th>Driver Id</th>
                                        <th>Driver First Name</th>
                                        <th>Driver Last Name</th>
                                        <th>Driver Gender</th>
                                        <th>Driver Age</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="driverList" items="${driverList}">
                                        <tr>
                                            <td>${driverList.driverId}</td>
                                            <td>${driverList.driverFirstName}</td>
                                            <td>${driverList.driverLastName}</td>
                                            <td>${driverList.driverGender}</td>
                                            <td>${driverList.driverAge}</td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                    <c:if test="${empty  driverList}">
                        <p>No Records Found</p>
                    </c:if>
                    <!-- Footer Start -->
                    <jsp:include page="footer.jsp" />
                    <!-- Footer End -->
                </body>

                </html>
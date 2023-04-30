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
                    <div class="container containerAddBus">
                        <form:form id="addUserDtl" class="formBox" action="saveUser" method="post" modelAttribute="user">
                            <div id="registerDiv">
                                <h3>Register User Form</h3>
                                <fieldset>
                                    <input placeholder="First Name" type="text" id="firstName" name="firstName" />
                                </fieldset>
                                <fieldset>
                                    <input placeholder="Last Name" type="text" id="lastName" name="lastName" />
                                </fieldset>
                                <fieldset>
                                    <input placeholder="Email" type="email" id="email" name="email" />
                                </fieldset>
                                <fieldset>
                                    <input placeholder="Password" type="password" id="password" name="password" />
                                </fieldset>
                                <input type="hidden" id="userType" name="userType" value="Customer" />
                                <fieldset>
                                    <button name="submit" type="submit" value="submit" data-submit="...Sending">Submit</button>
                                </fieldset>
                            </div>
                        </form:form>
                    </div>
                    <!-- Footer Start -->
                    <jsp:include page="footer.jsp" />
                    <!-- Footer End -->
                </body>

                </html>
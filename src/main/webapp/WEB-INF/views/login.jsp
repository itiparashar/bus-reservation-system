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
                <!-- https://codepen.io/danielarlert/pen/LYNVyPL -->

                <body>
                    <jsp:include page="header.jsp" />
                    <font color="red">${errorMessage}</font>
                    <font color="green">${successMessgae}</font>
                    <div class="container containerAddBus">
                        <form action="checkLogIn" class="formBox" method="post">
                            <h3>Login Form</h3>
                            <fieldset>
                                <input placeholder="Login Id" type="text" id="userid" name="userid" />
                            </fieldset>
                            <fieldset>
                                <input placeholder="Password" type="password" id="pass" name="pass" />
                            </fieldset>
                            <fieldset>
                                <button name="submit" type="submit" value="submit" data-submit="...Sending">Submit</button>
                            </fieldset>
                            <fieldset>
                                <button type="button" style="background-color: aqua; color: black;" id="register" name="register" onclick="registerHere()">Register</button>
                            </fieldset>
                        </form>
                    </div>

                    <!-- Footer Start -->
                    <jsp:include page="footer.jsp" />
                    <!-- Footer End -->
                    <script>
                        function registerHere() {
                            window.location = '/register';
                        }
                    </script>
                </body>

                </html>
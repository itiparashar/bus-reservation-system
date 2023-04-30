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

                <body style="background-image: url('assets/busBooking2.png'); background-repeat: no-repeat; background-size: 100% 100%;">
                    <jsp:include page="header.jsp" />
                    <h3 style="width:100%; height:20%; background-color: Black; padding-left:35%; margin:0px; "><font color="white">Hey, ${userName} Welcome To busBooking...!</font> </h3>
                    <font color="red">${errorMessage}</font>
                    
                    
                    <script>
                    </script>

                    <!-- Footer Start -->
                    <jsp:include page="footer.jsp" />
                    <!-- Footer End -->
                </body>

                </html>
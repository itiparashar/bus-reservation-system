<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

                <html>

                <head>
                    <meta charset="ISO-8859-1">
                    <!-- BEGIN: Custom CSS-->
                    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
                    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css">
                    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.2.2/css/buttons.bootstrap.min.css">
                    <link rel="stylesheet" type="text/css" href="https://fontawesome.com/v4/assets/font-awesome/css/font-awesome.css">
                    <link rel="stylesheet" href="https://codepen.io/gymratpacks/pen/VKzBEp#0">
                    <!-- END: Custom CSS-->
                    <style>
                        body {
                            margin: 2em;
                        }
                        
                        #page-container {
                            position: relative;
                            min-height: 100vh;
                            display: flex;
                            flex-direction: column;
                        }
                        
                        td:last-child {
                            text-align: center;
                        }
                    </style>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
                    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
                    <script src="https://cdn.datatables.net/buttons/1.2.2/js/dataTables.buttons.min.js"></script>
                    <script src="https://cdn.datatables.net/buttons/1.2.2/js/buttons.colVis.min.js"></script>
                    <script src="https://cdn.datatables.net/buttons/1.2.2/js/buttons.html5.min.js"></script>
                    <script src="https://cdn.datatables.net/buttons/1.2.2/js/buttons.print.min.js"></script>
                    <script src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
                    <script src="https://cdn.datatables.net/buttons/1.2.2/js/buttons.bootstrap.min.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
                    <script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
                    <script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
                    <script src="https://use.fontawesome.com/12b98c8558.js"></script>
                    <link rel="stylesheet" href="styles/header.css">

                </head>

                <body>
                    <div id="page-container">
                        <header>
                            <div class="container">
                                <div class="logo-box">
                                    <a href="/">
                                        <img src="assets/logo1.png">
                                    </a>
                                </div>
                                <nav>
                                    <ul>
                                        <c:if test="${not empty  userDtl}">
                                            <li><a href="/">Home</a></li>
                                            <c:choose>
                                                <c:when test="${userDtl.userType eq 'Admin'}">
                                                    <li><a href="/addBus">Add Bus</a></li>
                                                    <li><a href="/addDriver">Add Driver</a></li>
                                                    <li><a href="/busReport">Bus Report</a></li>
                                                    <li><a href="/ticketHistory">Ticket History</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="/busReport">Bus Report</a></li>
                                                    <li><a href="/bookTicket">Book Ticket</a></li>
                                                    <li><a href="/ticketHistory?userId=${userDtl.userId}">Ticket History</a>
                                                    </li>
                                                </c:otherwise>
                                            </c:choose>
                                            <li>
                                                <div class="dropdown">
                                                    <button class="dropbtn">
													<i class="fa fa-user" aria-hidden="true"></i>
												</button>
                                                    <div class="dropdown-content">
                                                        <a href="/changePassword">Change Password</a>
                                                        <a href="/logout">Log Out</a>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:if>
                                        <c:if test="${empty  userDtl}">
                                            <li><a href="/">Home</a></li>
                                            <li><a href="/busReport">Bus Report</a></li>
                                            <li><a href="/login">Log In</a></li>
                                        </c:if>
                                    </ul>
                                </nav>
                            </div>
                        </header>
                </body>

                </html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

                <html>

                <head>
                    <meta charset="ISO-8859-1">
                    <!-- BEGIN: Custom CSS-->
                    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
                    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.0/bootstrap-table.min.css">
                    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css">
                    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
                    <!-- END: Custom CSS-->
                    <link rel="stylesheet" href="styles/header.css">
                    <style>
                        footer {
                            position: absolute;
                            bottom: 0;
                            left: 0;
                        }
                        
                        section {
                            width: 100%;
                            display: inline-block;
                            background: #ccc;
                            height: 60vh;
                            text-align: center;
                            font-size: 22px;
                            font-weight: 700;
                            text-decoration: underline;
                        }
                        
                        .footer-distributed {
                            background-color: #292c2f;
                            box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
                            box-sizing: border-box;
                            width: 100%;
                            text-align: left;
                            font: normal 16px sans-serif;
                            padding: 20px 50px;
                        }
                        
                        .footer-distributed .footer-left p {
                            color: #8f9296;
                            font-size: 14px;
                            margin: 0;
                        }
                        /* Footer links */
                        
                        .footer-distributed p.footer-links {
                            font-size: 12px;
                            font-weight: bold;
                            color: #ffffff;
                            margin: 0 0 10px;
                            padding: 0;
                            transition: ease .25s;
                            padding-right: 21em;
                        }
                        
                        .footer-distributed p.footer-links a {
                            display: inline-block;
                            line-height: 1.8;
                            text-decoration: none;
                            color: inherit;
                            transition: ease .25s;
                        }
                        
                        .footer-distributed .footer-links a:before {
                            content: "·";
                            font-size: 20px;
                            left: 0;
                            color: #fff;
                            display: inline-block;
                            padding-right: 5px;
                        }
                        
                        .footer-distributed .footer-links .link-1:before {
                            content: none;
                        }
                        
                        .footer-distributed .footer-right {
                            float: right;
                            margin-top: 6px;
                            max-width: 180px;
                        }
                        
                        .footer-distributed .footer-right a {
                            display: inline-block;
                            width: 35px;
                            height: 35px;
                            background-color: #33383b;
                            border-radius: 2px;
                            font-size: 20px;
                            color: #ffffff;
                            text-align: center;
                            line-height: 35px;
                            margin-left: 3px;
                            transition: all .25s;
                        }
                        
                        .footer-distributed .footer-right a:hover {
                            transform: scale(1.1);
                            -webkit-transform: scale(1.1);
                        }
                        
                        .footer-distributed p.footer-links a:hover {
                            text-decoration: underline;
                        }
                        /* Media Queries */
                        
                        @media (max-width: 600px) {
                            .footer-distributed .footer-left,
                            .footer-distributed .footer-right {
                                text-align: center;
                            }
                            .footer-distributed .footer-right {
                                float: none;
                                margin: 0 auto 20px;
                            }
                            .footer-distributed .footer-left p.footer-links {
                                line-height: 1.8;
                            }
                        }
                    </style>
                </head>

                <body>
                    <br/>
                    <footer class="footer-distributed">
                        <div class="footerBox">
                            <!-- <div class="footer-right">

                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>

                            </div> -->

                            <div class="footer-left">

                                <p class="footer-links">
                                    busBooking is the world's largest online bus ticket booking service trusted by over 25 million happy customers globally. redBus offers bus ticket booking through its website,iOS and Android mobile apps for all major routes.
                                </p>

                                <p>busBooking &copy; 2022</p>
                            </div>
                        </div>
                    </footer>
                    </div>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
                    <script>
//                         $(document).ready(function() {
//                             //Only needed for the filename of export files.
//                             //Normally set in the title tag of your page.
//                             document.title = 'Simple DataTable';
//                             // DataTable initialisation
//                             $('#tableBusReport').DataTable({
//                                 "dom": '<"dt-buttons"Bf><"clear">lirtp',
//                                 "paging": true,
//                                 "autoWidth": true,
//                                 "columnDefs": [{
//                                     "orderable": false,
//                                     "targets": 5
//                                 }],
//                                 "info": false,
//                                 "searching": false,
//                                 "lengthChange": false,
//                                 "scrollX": true,
//                             });

//                             $('#tableTicketHistory').DataTable({
//                                 "dom": '<"dt-buttons"Bf><"clear">lirtp',
//                                 "paging": true,
//                                 "autoWidth": true,
//                                 "columnDefs": [{
//                                     "orderable": false,
//                                     "targets": 5
//                                 }],
//                                 "scrollX": true,
//                                 "info": false,
//                                 "searching": false,
//                                 "lengthChange": false,
//                             });
//                             $('#tableDriverDetails').DataTable({
//                                 "dom": '<"dt-buttons"Bf><"clear">lirtp',
//                                 "paging": false,
//                                 "autoWidth": true,
//                                 "info": false,
//                                 "searching": false,
//                                 "scrollX": true,
//                                 "lengthChange": false,
//                             });
//                         });
                    </script>
                </body>

                </html>
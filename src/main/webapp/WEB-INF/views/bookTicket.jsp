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

                <body onload="loadBody()">
                    <jsp:include page="header.jsp" />
                    <font color="red">${errorMessage}</font>
                    <div class="container containerAddBus">
                        <form:form id="bookTicketDtl" style="width: 50%;" action="bookTicketDtl" method="post" modelAttribute="ticketBookingDTO">
                            <div id="ticketBookingDiv">
                                <div id="passengerDetail" class="formBox">
                                    <!-- <table style="margin: auto;" border="1"> -->
                                    <%-- <tr>
				<td> Bus Name. </td>
				<td>
				
					
				</td>
			</tr> --%>
                                        <h3>Bus Name</h3>
                                        <h4>Fill the form to Book Ticket</h4>
                                        <c:choose>
                                            <c:when test="${not empty selectedBusId}"><!-- FROM Bus Report -->
                                                <form:hidden id="selectedBusId" name="selectedBusId" path="selectedBusId" value="${selectedBusId}" />
                                            </c:when>
                                            <c:otherwise><!-- Direct Book Ticket -->
                                                <fieldset>
                                                    <div class="select">
                                                        <form:select path="selectedBusId">
                                                            <c:forEach var="busList" items="${busList}">
                                                                <option value="${busList.id}"> ${busList.busName} </option>
                                                            </c:forEach>
                                                        </form:select>
                                                    </div>
                                                </fieldset>
                                            </c:otherwise>
                                        </c:choose>
                                        <fieldset>
                                            <form:input placeholder="Passenger First Name" type="text" path="passengerFirstName" maxlength="255" autocomplete="off" />
                                        </fieldset>
                                        <fieldset>
                                            <form:input placeholder="Passenger Last Name" type="text" path="passengerLastName" maxlength="255" autocomplete="off" />
                                        </fieldset>
                                        <fieldset>
                                            <form:input placeholder="Passenger Email" type="text" path="passengerEmail" maxlength="255" autocomplete="off" />
                                        </fieldset>
                                        <fieldset>
                                            <form:input placeholder="Passenger ID" type="text" path="passengerId" maxlength="255" autocomplete="off" />
                                        </fieldset>

                                        <fieldset>
                                            <p>Passenger Gender</p>
                                            <div class="select">
                                                <form:select path="passengerGender">
                                                    <option value="male"> Male </option>
                                                    <option value="female"> Female </option>
                                                    <option value="other"> Other </option>
                                                </form:select>
                                            </div>
                                        </fieldset>
                                        <fieldset>
                                            <form:input placeholder="Passenger Age" type="number" path="passengerAge" maxlength="255" autocomplete="off" />
                                        </fieldset>
                                        <fieldset>
                                            <form:input placeholder="passenger Count" type="number" path="passengerCount" maxlength="3" autocomplete="off" />
                                        </fieldset>



                                        <%-- <fieldset>
                                        <form:input placeholder="Journey Date" type="date" path="" autocomplete="off" />
                                    </fieldset> --%>
                                            <fieldset>
                                                <form:input placeholder="Address" type="text" path="passengerAddress" rows="5" cols="30" autocomplete="off" />
                                            </fieldset>
                                            <fieldset>
                                                <button onclick="passengerSubmit()" type="button" value="submit" id="passengerDetailsSubmit" data-submit="...Sending">Submit</button>
                                            </fieldset>
                                </div>
                                <div id="passengerPaymentDtl" class="formBox" style="margin: auto;" border="1">
                                    <h3>Pay Here</h3>
                                    <h4>Fill the Payment Details</h4>
                                    <fieldset>
                                        <p>Payment Mode</p>
                                        <div class="select">
                                            <form:select id="paymentMode" path="paymentMode" onchange="changePaymentMode()">
                                                <option value="debitCard"> Debit Card </option>
                                                <option value="vpa"> vpa </option>
                                            </form:select>
                                        </div>
                                    </fieldset>
                                    <br>
                                    <div id="debitCardPayDiv">
                                        <fieldset>
                                            <form:input type="text" placeholder="Card Number" path="cardNo" maxlength="16" autocomplete="off" />
                                        </fieldset>
                                        <fieldset>
                                            <form:input placeholder="Card Holder Name" type="text" path="cardHolderName" maxlength="255" autocomplete="off" />
                                        </fieldset>
                                        <fieldset>
                                            <form:input placeholder="Card Expiry Year" type="number" path="cardExpiryYear" maxlength="4" autocomplete="off" />
                                        </fieldset>
                                        <fieldset>
                                            <form:input placeholder="Card Expiry Month" type="number" path="cardExpiryMonth" maxlength="2" autocomplete="off" />
                                        </fieldset>
                                        <fieldset>
                                            <form:input placeholder="Card CVV" type="number" path="cardCvv" maxlength="3" autocomplete="off" />
                                        </fieldset>
                                    </div>
                                    <div id="vpaPayDiv">
                                        <fieldset>
                                            <form:input placeholder="Virtual Address" type="text" path="paymentVPA" maxlength="255" autocomplete="off" />
                                        </fieldset>
                                    </div>

                                    <fieldset>
                                        <button name="submit" type="submit" value="submit" data-submit="...Sending">Submit</button>
                                    </fieldset>
                                    <fieldset>
                                        <button type="button" style="background-color: aqua; color: black;" id="register" name="register" onclick="backPay()">Back</button>
                                    </fieldset>
                                </div>
                            </div>
                    </div>
                    </form:form>
                    <!-- Footer Start -->
                    <jsp:include page="footer.jsp" />
                    <!-- Footer End -->
                    <script type="text/javascript">
                        function loadBody() {
                            document.getElementById("passengerPaymentDtl").style.display = "none";

                            document.getElementById("debitCardPayDiv").style.display = "block";
                            document.getElementById("vpaPayDiv").style.display = "none";
                        }

                        function passengerSubmit() {
                            document.getElementById("passengerDetail").style.display = "none";
                            document.getElementById("passengerPaymentDtl").style.display = "block";
                        }

                        function backPay() {
                            document.getElementById("passengerPaymentDtl").style.display = "none";
                            document.getElementById("passengerDetail").style.display = "block";
                        }

                        function changePaymentMode() {
                            var paymentMode = document.getElementById("paymentMode").value;
                            if (paymentMode == 'debitCard') {
                                document.getElementById("debitCardPayDiv").style.display = "block";
                                document.getElementById("vpaPayDiv").style.display = "none";

                            }

                            if (paymentMode == 'vpa') {
                                document.getElementById("debitCardPayDiv").style.display = "none";
                                document.getElementById("vpaPayDiv").style.display = "block";

                            }

                        }
                    </script>
                </body>

                </html>
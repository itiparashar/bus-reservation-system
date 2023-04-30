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
                    <div class="container containerAddBus">
                        <form:form id="changePasswordDtl" class="formBox" action="changePasswordDtl" method="post" modelAttribute="changePasswordDTO">
                            <div id="changePasswordDiv">
                                <h3>Change Password</h3>
                                <h4>Fill the form to Change Password</h4>
                                <fieldset>
                                    <form:input placeholder="Old Password" type="password" id="oldPassword" name="oldPassword" path="oldPassword" />
                                </fieldset>
                                <fieldset>
                                    <form:input placeholder="new Password" type="password" id="newPassword" name="newPassword" path="newPassword" />
                                </fieldset>
                                <fieldset>
                                    <form:input placeholder="Confirm Password" type="password" id="confirmPassword" name="confirmPassword" path="confirmPassword" />
                                    <p class="isa_error" id="errorCodeConfirmPass"></p>
                                </fieldset>
                                <fieldset>
                                    <p class="isa_error serverErrorMsgs">${errorMessage}</p>
                                </fieldset>
                                <fieldset>
                                    <button name="submit" type="submit" value="submit" id="changePass-submit" data-submit="...Sending">Submit</button>
                                </fieldset>

                                <form:hidden id="changePasswordUserId" name="changePasswordUserId" path="changePasswordUserId" value="${changePasswordUserId}" />
                            </div>
                        </form:form>
                    </div>
                    <script>
                        $(document).ready(() => {
                            $("#confirmPassword").on('change', function() {
                                if (this.value !== $("#newPassword").val()) {
                                    $("#errorCodeConfirmPass").html("New Password and Confirm Password Should Match")
                                    $(".serverErrorMsgs").html("")
                                }
                            });
                            $('#changePasswordDtl').on('submit', function(e) {
                                $(".serverErrorMsgs").html("")
                                if ($("#confirmPassword").val() !== $("#newPassword").val()) {
                                    $("#changePass-submit").addClass("disabledBtn")
                                    $(".serverErrorMsgs").html("")
                                    $("#errorCodeConfirmPass").html("New Password and Confirm Password Should Match")
                                    e.preventDefault();
                                } else {
                                    $("#errorCodeConfirmPass").html("");
                                    $(".serverErrorMsgs").html("")
                                    $('#changePasswordDtl').submit();
                                }
                            })
                        })
                    </script>
                    <!-- Footer Start -->
                    <jsp:include page="footer.jsp" />
                    <!-- Footer End -->
                </body>

                </html>
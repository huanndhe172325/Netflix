<%-- 
    Document   : update
    Created on : Mar 12, 2024, 10:08:14 PM
    Author     : FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>${error}</p>
        <form action="updateProfile" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${user.name}" required></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>
                        Male <input type="radio" name="gender" value="true" <c:if test="${user.gender == true}">checked</c:if> required>
                        Female <input type="radio" name="gender" value="false" <c:if test="${user.gender == false}">checked</c:if> required>
                        </td>

                    </tr>
                    <tr>
                        <td>Enter date of birth:</td>
                        <td><input type="date" name="dob" value="${user.dateOfBirth}" required></td>
                </tr>

                </tr>
                <tr>
                    <td>
                        <input type="submit" value="SAVE">
                    </td>
                    <td>
                        <button onclick="location.href = 'browse'">Cancel</button>
                    </td>
                </tr>
            </table>
            <h1 style="color: ${status}">${requestScope.notification}</h1>
        </form>
    </body>
</html>

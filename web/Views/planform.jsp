<%-- 
    Document   : planform
    Created on : Mar 5, 2024, 11:10:14 PM
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
        <h1>Status Pricing Form</h1>
        <p>${noti}</p>
        <p style="font-size: 30px">Current plan : ${currenPri.pricingName}</p>
        <form method="POST" action="planform">
            <table border="1">
                <thead>
                    <tr>
                        <th>Pricing Name</th>
                        <th>Price</th>
                        <th>Resolution</th>
                        <th>Description</th>
                        <th>Option</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pri" items="${listPricing}">
                        <tr>
                            <td><c:out value="${pri.pricingName}" /></td>
                            <td><c:out value="${pri.price}" /></td>
                            <td><c:out value="${pri.resolution}" /></td>
                            <td><c:out value="${pri.describe}" /></td>
                            <c:if test="${currenPri.pricingID < pri.pricingID or currenPri == null}">
                                <td><input type="radio" name="selectedPricingID" value="${pri.pricingID}" required="">
                                </c:if> 
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <input type="submit" value="Buy">
            <br>
        </form>
        <br>
        <button onclick="location.href = 'browse'">Back</button>
    </body>
</html>

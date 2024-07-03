<%-- 
    Document   : profile
    Created on : Mar 12, 2024, 11:38:44 AM
    Author     : FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 600px;
                margin: 20px auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .user-info {
                margin-top: 20px;
            }

            .user-info p {
                margin: 10px 0;
            }

            .user-info strong {
                font-weight: bold;
                margin-right: 10px;
            }

        </style>
    </head>
    <body>

        <div class="container">
            <h2>User Information</h2>
            <div class="user-info">
                <p><strong>Name:</strong> <span id="name">${user.name}</span></p>
                <p><strong>Email:</strong> <span id="email">${user.email}</span></p>
                <p><strong>Gender:</strong> <span id="gender">
                        <c:choose>
                            <c:when test="${user.gender == null}">
                                
                            </c:when>
                            <c:when test="${user.gender == true}">
                                Male
                            </c:when>
                            <c:otherwise>
                                Female
                            </c:otherwise>
                        </c:choose>
                    </span></p>
                <p><strong>Date of Birth:</strong> <span id="dob">${user.dateOfBirth}</span></p>
            </div>
            <button onclick="location.href = 'planform'">Up grade Plan</button>
            <br>
            <br>
            <button onclick="location.href = 'browse'">Back to Browse</button>
            <button onclick="location.href = 'updateProfile'">Update</button>
        </div>

    </body>
</html>

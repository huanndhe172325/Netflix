<%-- 
    Document   : addMovies
    Created on : Mar 16, 2024, 3:49:11 PM
    Author     : FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Film</title>
        <style>
            form {
                max-width: 500px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            input[type="text"],
            input[type="number"],
            input[type="file"],
            select,
            textarea {
                width: 100%;
                padding: 10px;
                margin: 5px 0;
                border: 1px solid #ccc;
                border-radius: 3px;
                box-sizing: border-box;
            }

            input[type="submit"] {
                width: 100%;
                background-color: #007bff;
                color: #fff;
                padding: 10px;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <h2 style="text-align: center;">ADD NEW FILM  <button onclick="location.href = 'manageMovies'">Back</button></h2>
        <h2 style="text-align: center;">${success}</h2>
        
        <form action="addMovies" method="post" enctype="multipart/form-data">
            <label for="name">Film Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="time">Duration (minutes):</label>
            <input type="number" id="time" name="time" required>

            <label for="year">Year:</label>
            <input type="number" id="year" name="year" required>

            <label for="imgPath">Image:</label>
            <input type="file" id="imgPath" name="imgPath" accept="image/*" required>

            <label for="moviePath">Movie:</label>
            <input type="file" id="moviePath" name="moviePath" accept="video/*" required>

            <label for="age">Age Restriction:</label>
            <input type="number" id="age" name="age" required>

            <label for="Detail">Film Detail:</label>
            <textarea id="Detail" name="Detail" required></textarea>

            <label for="country">Country:</label>
            <select id="country" name="country" required>
                <c:forEach items="${listCountry}" var="cou">
                    <option value="${cou.countryID},${cou.name}">${cou.name}</option>
                </c:forEach>
            </select>

            <label for="moviePath">Trailer</label>
            <input type="file" id="trailerPath" name="trailerPath" accept="video/*" required>

            <input type="submit" value="Add Film">
        </form>
    </body>
</html>

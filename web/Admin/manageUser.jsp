<%-- 
    Document   : dashboard
    Created on : Mar 16, 2024, 1:24:49 AM
    Author     : FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
        <link rel="stylesheet" href="css/style_1.css">
        <title>Dashboard</title>
        <style>
            .search-form {
                display: flex;
                justify-content: center;
                align-items: center;
                margin-bottom: 20px;
            }

            .search-form input[type="text"] {
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                margin-right: 5px;
            }

            .search-form input[type="submit"] {
                padding: 8px 15px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            .search-form input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <!-- Sidebar Section -->
            <aside>
                <div class="toggle">
                    <div class="logo">
                        <img src="images/logo_1.png">
                        <h2>Dash<span class="danger">Board</span></h2>
                    </div>
                    <div class="close" id="close-btn">
                        <span class="material-icons-sharp">
                            close
                        </span>
                    </div>
                </div>

                <div class="sidebar">
                    <a href="dashboard">
                        <span class="material-icons-sharp">
                            dashboard
                        </span>
                        <h3>Dashboard</h3>
                    </a>
                    <a href="manageUser">
                        <span class="material-icons-sharp">
                            person_outline
                        </span>
                        <h3>Users</h3>
                    </a>
                    <a href="manageMovies">
                        <span class="material-icons-sharp">
                            insights
                        </span>
                        <h3>Movies</h3>
                    </a>
                    <a href="saleList">
                        <span class="material-icons-sharp">
                            inventory
                        </span>
                        <h3>Sale List</h3>
                    </a>
                    <a href="updatePricing">
                        <span class="material-icons-sharp">
                            report_gmailerrorred
                        </span>
                        <h3>Update Pricing</h3>
                    </a>
                    <a href="#">
                        <span class="material-icons-sharp">
                            settings
                        </span>
                        <h3>Settings</h3>
                    </a>
                    <a href="addAdmin">
                        <span class="material-icons-sharp">
                            add
                        </span>
                        <h3>New Admin</h3>
                    </a>
                    <form id="logoutForm" action="logout" method="post" style="display: none;"></form>
                    <a href="javascript:void(0);" onclick="document.getElementById('logoutForm').submit();">
                        <span class="material-icons-sharp">
                            logout
                        </span>
                        <h3>Logout</h3>
                    </a>
                </div>
            </aside>
            <!-- End of Sidebar Section -->

            <!-- Main Content -->
            <main>

                <div class="recent-orders">
                    <h2>Manage User</h2>
                    <form action="manageUser" class="search-form">
                        <input type="text" name="inputSearch" placeholder="Email...">
                        <input type="submit" value="Find">
                    </form>
                    <p style="text-align: center; font-size: 20px;">${noti}</p>
                    <table>
                        <thead>
                            <tr>
                                <th>Email</th>
                                <th>Name</th>
                                <th>Password</th>
                                <th>Gender</th>
                                <th>Date of birth</th>
                                <th>Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="us" items="${listUser}"> 
                                <tr>
                                    <td>${us.email}</td>
                                    <td>${us.name}</td>
                                    <td>*********</td>
                                    <td>${us.gender ? 'Male' : 'Female'}</td>
                                    <td>${us.dateOfBirth}</td>
                                    <c:choose>
                                        <c:when test="${us.role == 1}">
                                            <td style="color: blue;"> User </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td style="color: red; font-weight: 600;"> Admin </td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td>
                                        <c:choose>
                                            <c:when test="${us.status == true}">
                                                <form action="manageUser" method="post">
                                                    <input type="hidden" name="userId" value="${us.idUser}">
                                                    <input type="submit" onclick="return confirmDelete();" style="    background: none;
                                                           border: none;
                                                           color: red;
                                                           text-decoration: none;
                                                           cursor: pointer;
                                                           padding: 0;" value="Disable">
                                                </form>
                                            </c:when>
                                            <c:otherwise>
                                                <form action="manageUser" method="post">
                                                    <input type="hidden" name="userId" value="${us.idUser}">
                                                    <input type="submit" onclick="return confirmDelete();" style="    background: none;
                                                           border: none;
                                                           color: blue;
                                                           text-decoration: none;
                                                           cursor: pointer;
                                                           padding: 0;" value="Enable">

                                                </c:otherwise>
                                            </c:choose>
                                            </td>
                                            </tr>
                                        </c:forEach>  
                                        </tbody>
                                        </table>
                                        <!--<a href="#">Show All</a>-->
                                        </div>
                                        <!-- End of Recent Orders -->

                                        </main>
                                        <!-- End of Main Content -->

                                        <!-- Right Section -->
                                        <div class="right-section">
                                            <div class="nav">
                                                <button id="menu-btn">
                                                    <span class="material-icons-sharp">
                                                        menu
                                                    </span>
                                                </button>
                                                <div class="dark-mode">
                                                    <span class="material-icons-sharp active">
                                                        light_mode
                                                    </span>
                                                    <span class="material-icons-sharp">
                                                        dark_mode
                                                    </span>
                                                </div>

                                                <div class="profile">
                                                    <div class="info">
                                                        <!--<p>Hey, <b>Reza</b></p>-->
                                                        <small class="text-muted">Admin</small>
                                                    </div>
                                                    <div class="profile-photo">
                                                        <img src="images/user/user.png">
                                                    </div>
                                                </div>

                                            </div>
                                            <!-- End of Nav -->

                                            <div class="user-profile" onclick="window.location.href = 'browse';">
                                                <div class="logo">
                                                    <img src="images/logo.png">

                                                </div>
                                            </div>


                                        </div>


                                        </div>
                                        <script>
                                            function confirmDelete() {
                                                return confirm("Are you sure you want to delete?");
                                            }
                                        </script>
                                        <script src="js/index.js"></script>
                                        </body>
                                        </html>

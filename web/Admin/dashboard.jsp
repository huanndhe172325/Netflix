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
                    <a href="javascript:void(0);" onclick="document.getElementById('logoutForm').submit();" >
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
                <h1>Analytics</h1>
                <!-- Analyses -->
                <div class="analyse">
                    <div class="sales">
                        <div class="status">
                            <div class="info">
                                <h3 style="margin-left: 0px;">Total Sales</h3>
                                <h1>$ ${toTalsale}</h1>
                            </div>
                            <!--                            <div class="progresss">
                                                            <svg>
                                                            <circle cx="38" cy="38" r="36"></circle>
                                                            </svg>
                                                            <div class="percentage">
                                                                <p>+81%</p>
                                                            </div>
                                                        </div>-->
                        </div>
                    </div>
                    <div class="visits">
                        <div class="status">
                            <div class="info">
                                <h3 style="margin-left: 0px;">Total Order</h3>
                                <h1>${totalOrder}</h1>
                            </div>
                            <!--                            <div class="progresss">
                                                            <svg>
                                                            <circle cx="38" cy="38" r="36"></circle>
                                                            </svg>
                                                            <div class="percentage">
                                                                <p>-48%</p>
                                                            </div>
                                                        </div>-->
                        </div>
                    </div>
                    <div class="searches">
                        <div class="status">
                            <div class="info">
                                <h3 style="margin-left: 0px;">Sale Today</h3>
                                <h1>$ ${saleToday}</h1>
                            </div>
                            <!--                            <div class="progresss">
                                                            <svg>
                                                            <circle cx="38" cy="38" r="36"></circle>
                                                            </svg>
                                                            <div class="percentage">
                                                                <p>+21%</p>
                                                            </div>
                                                        </div>-->
                        </div>
                    </div>
                </div>
                <!-- End of Analyses -->

                <!-- New Users Section -->
                <!--                <div class="new-users">
                                    <h2>New Users</h2>
                                    <div class="user-list">
                                        <div class="user">
                                            <img src="images/profile-2.jpg">
                                            <h2>Jack</h2>
                                            <p>54 Min Ago</p>
                                        </div>
                                        <div class="user">
                                            <img src="images/profile-3.jpg">
                                            <h2>Amir</h2>
                                            <p>3 Hours Ago</p>
                                        </div>
                                        <div class="user">
                                            <img src="images/profile-4.jpg">
                                            <h2>Ember</h2>
                                            <p>6 Hours Ago</p>
                                        </div>
                                        <div class="user">
                                            <img src="images/plus.png">
                                            <h2>More</h2>
                                            <p>New User</p>
                                        </div>
                                    </div>
                                </div>-->
                <!-- End of New Users Section -->

                <!-- Recent Orders Table -->
                <div class="recent-orders">
                    <h2>Recent Orders</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Customer</th>
                                <th>Date</th>
                                <th>Name Item</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ord" items="${listOrder}"> 
                                <tr>
                                    <td>${ord.emailCustomer}</th>
                                    <td>${ord.date}</th>
                                    <td>${ord.namePricing}</th>
                                    <td>${ord.totalOrder}</th>
                                </tr>
                            </c:forEach>  
                        </tbody>
                    </table>
                    <a href="saleList">Show All</a>
                </div>
                <div class="recent-orders">
                    <h2>New User</h2>
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
                                    <td>${us.role}</td>
                                </tr>
                            </c:forEach>  
                        </tbody>
                    </table>
                    <a href="manageUser">Show All</a>
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

        <script src="js/index.js"></script>
    </body>
</html>

<%-- 
    Document   : login
    Created on : Mar 5, 2024, 10:58:22 PM
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
            @import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;600;700&display=swap");

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Roboto', sans-serif;
            }

            body {
                background: #000;
            }

            body::before {
                content: "";
                position: absolute;
                left: 0;
                top: 0;
                opacity: 0.5;
                width: 100%;
                height: 100%;
                background: url("images/hero-img.jpg");
                background-position: center;
            }

            nav {
                position: fixed;
                padding: 25px 60px;
                z-index: 1;
            }

            nav a img {
                width: 167px;
            }

            .form-wrapper {
                position: absolute;
                left: 50%;
                top: 50%;
                border-radius: 4px;
                padding: 70px;
                width: 450px;
                transform: translate(-50%, -50%);
                background: rgba(0, 0, 0, .75);
            }

            .form-wrapper h2 {
                color: #fff;
                font-size: 2rem;
            }

            .form-wrapper form {
                margin: 25px 0 65px;
            }

            form .form-control {
                height: 50px;
                position: relative;
                margin-bottom: 16px;
            }

            .form-control input {
                height: 100%;
                width: 100%;
                background: #333;
                border: none;
                outline: none;
                border-radius: 4px;
                color: #fff;
                font-size: 1rem;
                padding: 0 20px;
            }

            .form-control input:is(:focus, :valid) {
                background: #444;
                padding: 16px 20px 0;
            }

            .form-control label {
                position: absolute;
                left: 20px;
                top: 50%;
                transform: translateY(-50%);
                font-size: 1rem;
                pointer-events: none;
                color: #8c8c8c;
                transition: all 0.1s ease;
            }

            .form-control input:is(:focus, :valid)~label {
                font-size: 0.75rem;
                transform: translateY(-130%);
            }

            form button {
                width: 100%;
                padding: 16px 0;
                font-size: 1rem;
                background: #e50914;
                color: #fff;
                font-weight: 500;
                border-radius: 4px;
                border: none;
                outline: none;
                margin: 25px 0 10px;
                cursor: pointer;
                transition: 0.1s ease;
            }

            form button:hover {
                background: #c40812;
            }

            .form-wrapper a {
                text-decoration: none;
            }

            .form-wrapper a:hover {
                text-decoration: underline;
            }

            .form-wrapper :where(label, p, small, a) {
                color: #b3b3b3;
            }

            form .form-help {
                display: flex;
                justify-content: space-between;
            }

            form .remember-me {
                display: flex;
            }

            form .remember-me input {
                margin-right: 5px;
                accent-color: #b3b3b3;
            }

            form .form-help :where(label, a) {
                font-size: 0.9rem;
            }

            .form-wrapper p a {
                color: #fff;
            }

            .form-wrapper small {
                display: block;
                margin-top: 15px;
                color: #b3b3b3;
            }

            .form-wrapper small a {
                color: #0071eb;
            }

            @media (max-width: 740px) {
                body::before {
                    display: none;
                }

                nav, .form-wrapper {
                    padding: 20px;
                }

                nav a img {
                    width: 140px;
                }

                .form-wrapper {
                    width: 100%;
                    top: 43%;
                }

                .form-wrapper form {
                    margin: 25px 0 40px;
                }
            }
        </style>
    </head>
    <body>
        <nav>
            <a href="javascript:void(0);" onclick="window.location.href = 'preview';"><img src="./images/logo.png" alt="logo"></a>
        </nav>
        <div class="form-wrapper">
            <h2>Sign In</h2>
            <form action="login" method="post">
                <p style="color: red;  padding-bottom: 5px">${error}</p>
                <div class="form-control">
                    <input type="text" name="username" value="${userName}" required>
                    <label>Email or phone number</label>
                </div>
                <div class="form-control">
                    <input type="password" name="password" required>
                    <label>Password</label>
                </div>
                <button type="submit">Login</button>
                <div class="form-help"> 
                    <a href="javascript:void(0);" onclick="window.location.href = 'fogetPassWord';">Forget password</a>
                </div>
            </form>
            <p>New to Netflix? <a href="javascript:void(0);" onclick="window.location.href = 'createAccount';">Sign up now</a></p>
        </div>
    </body>

</html>

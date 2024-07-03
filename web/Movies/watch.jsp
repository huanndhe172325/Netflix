<%-- 
    Document   : watch
    Created on : Mar 15, 2024, 12:51:01 AM
    Author     : FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Netflix</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
        <!-- i will provide this in description  -->
        <link rel="stylesheet" href="css/slick.css" />
        <link rel="stylesheet" href="css/slick-theme.css" />
        <link rel="stylesheet" href="css/owl.carousel.min.css" />
        <link rel="stylesheet" href="css/animate.min.css" />
        <link rel="stylesheet" href="css/magnific-popup.css" />
        <link rel="stylesheet" href="css/select2.min.css" />
        <link rel="stylesheet" href="css/select2-bootstrap4.min.css" />
        <link rel="stylesheet" href="css/slick-animation.css" />
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <header id="main-header">
            <div class="main-header">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-12">
                            <nav class="navbar navbar-expand-lg navbar-light p-0">
                                <a href="#" class="navbar-toggler c-toggler" data-toggle="collapse" data-target="#navbarSupportedContent"
                                   aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <div class="navbar-toggler-icon" data-toggle="collapse">
                                        <span class="navbar-menu-icon navbar-menu-icon--top"></span>
                                        <span class="navbar-menu-icon navbar-menu-icon--middle"></span>
                                        <span class="navbar-menu-icon navbar-menu-icon--bottom"></span>
                                    </div>
                                </a>
                                <a href="javascript:void(0);" onclick="window.location.href = 'browse';" class="navbar-brand">
                                    <img src="images/logo.png" class="img-fluid logo" alt="" />
                                </a>
                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                    <div class="menu-main-menu-container">
                                        <ul id="top-menu" class="navbar-nav ml-auto">
                                            <li class="menu-item"><a href="browse">Home</a></li>
                                            <li class="menu-item"><a ref="javascript:void(0);" onclick="window.location.href = 'movies';">Movies</a></li>
                                            <li class="menu-item"><a href="myList">My List</a></li>
                                            <li class="menu-item"><a href="likeList">Liked</a></li>
                                            <li class="menu-item">
                                                <a href="#">Contact Us</a>
                                                <ul class="sub-menu">
                                                    <li class="menu-item"><a href="#">About Us</a></li>
                                                    <li class="menu-item"><a href="#">Contact</a></li>
                                                    <li class="menu-item"><a href="#">FAQ</a></li>
                                                    <li class="menu-item">
                                                        <a href="#">Privacy-Policy</a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a href="javascript:void(0);" onclick="window.location.href = 'planform';">Pricing</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="mobile-more-menu">
                                    <a href="javascript:void(0);" class="more-toggle" id="dropdownMenuButton" data-toggle="more-toggle"
                                       aria-haspopup="true" aria-expanded="false">
                                        <i class="fa fa-ellipsis-h"></i>
                                    </a>
                                    <div class="more-menu" aria-labelledby="dropdownMenuButton">
                                        <div class="navbar-right position-relative">
                                            <ul class="d-flex align-items-center justify-content-end list-inline m-0">
                                                <li>
                                                    <a href="#" class="search-toggle">
                                                        <i class="fa fa-search"></i>
                                                    </a>
                                                    <div class="search-box iq-search-bar">
                                                        <form action="search" class="searchbox" method="post">
                                                            <div class="form-group position-relative">
                                                                <input required pattern="^(?! +$).+" type="text" class="text search-input font-size-12"
                                                                       placeholder="Titles, people, genres" />
                                                                <i class="search-link fa fa-search" style="padding-top: 6px;"></i>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </li>
                                                <li class="nav-item nav-icon">
                                                    <a href="#" class="search-toggle position-relative">
                                                        <i class="fa fa-bell"></i>
                                                        <span class="bg-danger dots"></span>
                                                    </a>
                                                    <div class="iq-sub-dropdown">
                                                        <div class="iq-card shadow-none m-0">
                                                            <div class="iq-card-body">
                                                                <a href="#" class="iq-sub-card">
                                                                    <div class="media align-items-center">
                                                                        <img src="images/notify/thumb-1.jpg" alt="" class="img-fluid mr-3" />
                                                                        <div class="media-body">
                                                                            <h6 class="mb-0">Captain Marvel</h6>
                                                                            <small class="font-size-12">just now</small>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                                <a href="#" class="iq-sub-card">
                                                                    <div class="media align-items-center">
                                                                        <img src="images/notify/thumb-2.jpg" alt="" class="img-fluid mr-3" />
                                                                        <div class="media-body">
                                                                            <h6 class="mb-0">
                                                                                Dora and The Lost City of Gold
                                                                            </h6>
                                                                            <small class="font-size-12">25 mins ago</small>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                                <a href="#" class="iq-sub-card">
                                                                    <div class="media align-items-center">
                                                                        <img src="images/notify/thumb-3.jpg" alt="" class="img-fluid mr-3" />
                                                                        <div class="media-body">
                                                                            <h6 class="mb-0">Mulan</h6>
                                                                            <small class="font-size-12">1h 30 mins ago</small>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <a href="#" class="iq-user-dropdown search-toggle d-flex align-items-center">
                                                        <img src="images/user/user.png" class="img-fluid user-m rounded-circle" alt="" />
                                                    </a>
                                                    <div class="iq-sub-dropdown iq-user-dropdown">
                                                        <div class="iq-card shadow-none m-0">
                                                            <div class="iq-card-body p-0 pl-3 pr-3">
                                                                <a href="javascript:void(0);" onclick="window.location.href = 'profile';" class="iq-sub-card setting-dropdown">
                                                                    <div class="media align-items-center">
                                                                        <div class="right-icon">
                                                                            <i class="fa fa-user text-primary"></i>
                                                                        </div>
                                                                        <div class="media-body ml-3">
                                                                            <h6 class="mb-0">Manage Profile</h6>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                                <a href="historyWatch" class="iq-sub-card setting-dropdown">
                                                                    <div class="media align-items-center">
                                                                        <div class="right-icon">
                                                                            <i class="fa fa-cog text-primary"></i>
                                                                        </div>
                                                                        <div class="media-body ml-3">
                                                                            <h6 class="mb-0">History Watch</h6>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                                <a href="javascript:void(0);" onclick="window.location.href = 'planform';" class="iq-sub-card setting-dropdown">
                                                                    <div class="media align-items-center">
                                                                        <div class="right-icon">
                                                                            <i class="fa fa-inr text-primary"></i>
                                                                        </div>
                                                                        <div class="media-body ml-3">
                                                                            <h6 class="mb-0">Pricing Plan</h6>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                                <form id="logoutForm" action="logout" method="post" style="display: none;"></form>
                                                                <a href="javascript:void(0);" onclick="document.getElementById('logoutForm').submit();" class="iq-sub-card setting-dropdown">
                                                                    <div class="media align-items-center">
                                                                        <div class="right-icon">
                                                                            <i class="fa fa-sign-out text-primary"></i>
                                                                        </div>
                                                                        <div class="media-body ml-3">
                                                                            <h6 class="mb-0">Logout</h6>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <div class="navbar-right menu-right">
                                    <ul class="d-flex align-items-center list-inline m-0">
                                        <li class="nav-item nav-icon">
                                            <a href="#" class="search-toggle device-search">
                                                <i class="fa fa-search"></i>
                                            </a>
                                            <div class="search-box iq-search-bar d-search">
                                                <form action="search" class="searchbox" method="post">

                                                    <div class="form-group position-relative">
                                                        <input required pattern="^(?! +$).+" type="text" name="inputSearch" class="text search-input font-size-12"
                                                               placeholder="Titles, people, genres" />
                                                        <i style="padding-top: 6px;" class="search-link fa fa-search"></i>
                                                    </div>
                                                </form>
                                            </div>
                                        </li>
                                        <li class="nav-item nav-icon">
                                            <a href="#" class="search-toggle" data-toggle="search-toggle">
                                                <i class="fa fa-bell"></i>
                                                <span class="bg-danger dots"></span>
                                            </a>
                                            <div class="iq-sub-dropdown">
                                                <div class="iq-card shadow-none m-0">
                                                    <div class="iq-card-body">
                                                        <a href="#" class="iq-sub-card">
                                                            <div class="media align-items-center">
                                                                <img src="images/notify/thumb-1.jpg" alt="" class="img-fluid mr-3" />
                                                                <div class="media-body">
                                                                    <h6 class="mb-0">Captain Marvel</h6>
                                                                    <small class="font-size-12">just now</small>
                                                                </div>
                                                            </div>
                                                        </a>
                                                        <a href="#" class="iq-sub-card">
                                                            <div class="media align-items-center">
                                                                <img src="images/notify/thumb-2.jpg" alt="" class="img-fluid mr-3" />
                                                                <div class="media-body">
                                                                    <h6 class="mb-0">
                                                                        Dora and The Lost City of Gold
                                                                    </h6>
                                                                    <small class="font-size-12">25 mins ago</small>
                                                                </div>
                                                            </div>
                                                        </a>
                                                        <a href="#" class="iq-sub-card">
                                                            <div class="media align-items-center">
                                                                <img src="images/notify/thumb-3.jpg" alt="" class="img-fluid mr-3" />
                                                                <div class="media-body">
                                                                    <h6 class="mb-0">Mulan</h6>
                                                                    <small class="font-size-12">1h 30 mins ago</small>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="nav-item nav-icon">
                                            <a href="#" class="iq-user-dropdown search-toggle d-flex align-items-center p-0">
                                                <img src="images/user/user.png" class="img-fluid user-m rounded-circle" alt="" />
                                            </a>
                                            <div class="iq-sub-dropdown iq-user-dropdown">
                                                <div class="iq-card shadow-none m-0">
                                                    <div class="iq-card-body p-0 pl-3 pr-3">
                                                        <a href="javascript:void(0);" onclick="window.location.href = 'profile';" class="iq-sub-card setting-dropdown">
                                                            <div class="media align-items-center">
                                                                <div class="right-icon">
                                                                    <i class="fa fa-user text-primary"></i>
                                                                </div>
                                                                <div class="media-body ml-3">
                                                                    <h6 class="mb-0">Manage Profile</h6>
                                                                </div>
                                                            </div>
                                                        </a>
                                                        <a href="historyWatch" class="iq-sub-card setting-dropdown">
                                                            <div class="media align-items-center">
                                                                <div class="right-icon">
                                                                    <i class="fa fa-cog text-primary"></i>
                                                                </div>
                                                                <div class="media-body ml-3">
                                                                    <h6 class="mb-0">History Watch</h6>
                                                                </div>
                                                            </div>
                                                        </a>
                                                        <a  href="javascript:void(0);" onclick="window.location.href = 'planform';" class="iq-sub-card setting-dropdown">
                                                            <div class="media align-items-center">
                                                                <div class="right-icon">
                                                                    <i class="fa fa-inr text-primary"></i>
                                                                </div>
                                                                <div class="media-body ml-3">
                                                                    <h6 class="mb-0">Pricing Plan</h6>
                                                                </div>
                                                            </div>
                                                        </a>
                                                        <form id="logoutForm" action="logout" method="post" style="display: none;"></form>
                                                        <a href="javascript:void(0);" onclick="document.getElementById('logoutForm').submit();" class="iq-sub-card setting-dropdown">
                                                            <div class="media align-items-center">
                                                                <div class="right-icon">
                                                                    <i class="fa fa-sign-out text-primary"></i>
                                                                </div>
                                                                <div class="media-body ml-3">
                                                                    <h6 class="mb-0">Logout</h6>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </nav>
                            <div class="nav-overlay"></div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- parallax section  -->
        <div style="padding-top: 100px">
            <section id="parallex" class="parallax-window" style="background: url(${film.imgPath}) center center;">
                <div class="container-fluid h-100">
                    <div class="row align-items-center justify-content-center h-100 parallaxt-details">
                        <div class="col-lg-4 r-mb-23">
                            <div class="text-left">
                                <a href="javascript:void(0)">
                                    <h1 class="parallax-heading">${film.name}</h1>
                                </a>
                                <div class="parallax-ratting d-flex align-items-center mt-3 mb-3">
                                    <ul
                                        class="ratting-start p-o m-0 list-inline text-primary d-flex align-items-center justify-content-left">
                                        <li>
                                            <a href="#" class="text-primary"><i class="fa fa-star"></i></a>
                                        </li>
                                        <li>
                                            <a href="#" class="text-primary"><i class="pl-2 fa fa-star"></i></a>
                                        </li>
                                        <li>
                                            <a href="#" class="text-primary"><i class="pl-2 fa fa-star"></i></a>
                                        </li>
                                        <li>
                                            <a href="#" class="text-primary"><i class="pl-2 fa fa-star"></i></a>
                                        </li>
                                        <li>
                                            <a href="#" class="text-primary"><i class="pl-2 fa fa-star"></i></a>
                                        </li>
                                    </ul>
                                    <span class="text-white ml-3">${film.getLike()}</span>
                                </div>
                                <div class="movie-time d-flex align-items-center mb-3">
                                    <div class="badge badge-secondary p-1 mr-2">${film.age}+</div>
                                    <span class="text-white">${film.time}</span>
                                </div>
                                <p>
                                    ${film.detail}
                                </p>
                                <div class="trending-list mt-4">
                                    <div class="text-primary title">
                                        Starring : 
                                        <span class="text-body">
                                            ${film.getActor()}
                                        </span>
                                    </div>
                                    <div class="text-primary title">
                                        Genres :
                                        <span class="text-body">
                                            ${film.getGenres()}
                                        </span>
                                    </div>
                                    <div class="text-primary title">
                                        Tags :
                                        <span class="text-body">
                                            ${film.getTags()}
                                        </span>
                                    </div>
                                </div>
                                <div class="parallax-buttons">
                                    <c:choose>
                                        <c:when test="${film.checkFilmInList(idList)}">
                                            <a style="text-decoration: none;" class="btn btn-link myListButton added" data-film-id="${film.IDFilm}" tabindex="0" onclick="toggleMyList(event, '${film.IDFilm}')">
                                                <i class="fa fa-minus pr-2"></i>
                                                <span class="myListText">Remove from My List</span>
                                            </a>
                                        </c:when>   
                                        <c:otherwise>
                                            <a style="text-decoration: none;" class="btn btn-link myListButton" data-film-id="${film.IDFilm}" tabindex="0" onclick="toggleMyList(event, '${film.IDFilm}')">
                                                <i class="fa fa-plus pr-2"></i>
                                                <span class="myListText">Add to My List</span>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                </div>       
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="parallax-img">
                                <a href="#">
                                    <video src="${film.moviePath}" type="video/mp4" autoplay="autoplay" controls alt="" class="img-fluid w-100"></video>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <footer class="iq-bg-dark">
            <div class="footer-top">
                <div class="container-fluid">
                    <div class="row footer-standard">
                        <div class="col-lg-5">
                            <div class="widget text-left">
                                <div>
                                    <ul class="menu p-0">
                                        <li><a href="#">Terms of Use</a></li>
                                        <li><a href="#">Privacy-Policy</a></li>
                                        <li><a href="#">FAQ</a></li>
                                        <li><a href="#">Watch List</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="widget text-left">
                                <div class="textwidget">
                                    <p><small>This is Lorem, ipsum dolor sit amet consectetur adipisicing elit. Obcaecati, quo tempore. Quasi rem rerum est in nulla atque quibusdam illo. this is footer and simple tsesxij is writen jkd. fsek hello how are you. please like and subscribe. footer ends .</small></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 mt-4 mt-lg-0">
                            <h6 class="footer-link-title">
                                Follow Us:
                            </h6>
                            <ul class="info-share">
                                <li>
                                    <a href="#">
                                        <i>
                                            <fa class="fa fa-facebook"></fa>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i>
                                            <fa class="fa fa-youtube"></fa>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i>
                                            <fa class="fa fa-instagram"></fa>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-3 col-md-6 mt-4 mt-lg-0">
                            <div class="widget text-left">
                                <div class="textwidget">
                                    <h6 class="footer-link-title">
                                        NetFlix App 
                                    </h6>
                                    <div class="d-flex align-items-center">
                                        <a href="#"><img src="images/footer/01.jpg" alt=""></a>
                                        <br>
                                        <a href="#" class="ml-3"><img src="images/footer/02.jpg" alt=""></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!-- js files  -->
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/select2.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/slick-animation.min.js"></script>

        <script src="js/main.js"></script>
        <script>
                                                function toggleMyList(event, filmId) {
                                                    event.preventDefault();
                                                    var buttons = document.querySelectorAll('[data-film-id="' + filmId + '"]');

                                                    buttons.forEach(function (button) {
                                                        var addIcon = button.querySelector('.fa');
                                                        var addText = button.querySelector('.myListText');
                                                        if (button.classList.contains('added')) {
                                                            removeFromMyList(filmId, button, addIcon, addText);
                                                        } else {
                                                            addToMyList(filmId, button, addIcon, addText);
                                                        }
                                                    });
                                                }

                                                function addToMyList(filmId, addButton, addIcon, addText) {
                                                    $.ajax({
                                                        url: 'addMyList',
                                                        type: 'POST',
                                                        data: {filmId: filmId},
                                                        success: function (response) {
                                                            console.log('Film added to My List successfully. Film ID: ' + response);
                                                            updateMyListButton(addButton, addIcon, addText, true);
                                                        },
                                                        error: function (xhr, status, error) {
                                                            console.error('Error:', error);
                                                        }
                                                    });
                                                }

                                                function removeFromMyList(filmId, addButton, addIcon, addText) {
                                                    $.ajax({
                                                        url: 'removeMyList',
                                                        type: 'POST',
                                                        data: {filmId: filmId},
                                                        success: function (response) {
                                                            console.log('Film removed from My List successfully. Film ID: ' + response);
                                                            updateMyListButton(addButton, addIcon, addText, false);
                                                        },
                                                        error: function (xhr, status, error) {
                                                            console.error('Error:', error);
                                                        }
                                                    });
                                                }

                                                function updateMyListButton(addButton, addIcon, addText, added) {
                                                    if (added) {
                                                        addButton.classList.add('added');
                                                        addIcon.classList.remove('fa-plus');
                                                        addIcon.classList.add('fa-minus');
                                                        addText.textContent = 'Remove from My List';
                                                    } else {
                                                        addButton.classList.remove('added');
                                                        addIcon.classList.remove('fa-minus');
                                                        addIcon.classList.add('fa-plus');
                                                        addText.textContent = 'Add to My List';
                                                    }
                                                }


        </script>
    </body>
</html>

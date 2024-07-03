<%-- 
    Document   : preview
    Created on : Mar 6, 2024, 1:51:34 AM
    Author     : FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css" />
        <style>
            *{
                padding:0;
                margin:0;
                box-sizing: border-box;
            }
            img{
                max-width: 100%;
            }
            body{
                font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif;
                background-color: #000;
                color:#fff;
            }
            header{
                display: grid;
                grid-template-columns: max-content 1fr;
                padding: 26px 20px;
                position:absolute;
                width: 100%;
                z-index: 5;
            }
            @media screen and (min-width:550px) {
                header{
                    padding: 26px 56px;
                }
            }

            header a.logo{
                display: block;
            }
            header .logo svg{
                fill: #e50914;
                height: 27px;
            }
            @media screen and (min-width:550px) {
                header .logo svg{
                    height: 37px;
                }

            }
            header div+div {
                text-align: right;
            }
            header a.button{
                display: inline-block;
                background-color: #e50914;
                color: #fff;
                text-decoration: none;
                padding: 7px 17px;
                border-radius: 3px;
            }
            header select{
                background: transparent;
                color:#fff;
                padding: 6px 0 6px 20px;
                border-radius: 3px;
            }
            header div.select{
                display:inline-block;
                margin-right: 10px;
            }
            @media screen and (min-width:550px) {
                header div.select{
                    margin-right: 30px;
                }
            }
            header div.select svg{
                height:20px;
                fill: #fff;
                position:absolute;
                margin-top:5px;
                margin-left: 4px;
            }

            div.splash{
                position:relative;
            }
            div.splash div.gradient{
                background-image: linear-gradient(to top,rgba(0,0,0,.8) 0,rgba(0,0,0,0) 60%,rgba(0,0,0,.8) 100%);
                position:absolute;
                inset:0;
            }
            div.splash div.background{
                position:absolute;
                z-index:1;
                inset:0;
            }
            div.splash div.background img{
                height:100%;
                opacity: 0.6;
                object-fit: cover;
            }
            div.splash div.content{
                padding: 95px 20px;
                max-width: 655px;
                margin: 0 auto;
                display: grid;
                align-items: center;
                text-align: center;
                position:relative;
                z-index:3;
            }
            @media screen and (min-width:550px) {
                div.splash div.content{
                    padding-top: 235px;
                    padding-bottom: 185px;
                }
            }
            div.splash h1, div.splash h2, div.splash h3{
                font-weight: normal;
            }
            div.splash h1{
                font-size: 1.75rem;
                font-weight: normal;
            }
            div.splash h2{
                font-size: 1.125rem;
                margin-top: 13px;
                margin-bottom: 29px;
            }
            div.splash h3{
                font-size: 1.125rem;
            }
            @media screen and (min-width: 550px) {
                div.splash h1{
                    font-size: 3.125rem;
                    font-weight: bold;
                }
                div.splash h2{
                    font-size: 1.625rem;
                    margin-top: 13px;
                    margin-bottom: 29px;
                }
                div.splash h3{
                    font-size: 1.2rem;
                }
            }

            div.cta form{
                position:relative;
                display:grid;
                grid-template-columns: 1fr;
                margin: 20px 20px 0;
                row-gap: 15px;
            }
            @media screen and (min-width:550px) {
                div.cta form{
                    display:grid;
                    grid-template-columns: 1fr max-content;
                }
            }
            div.cta input{
                padding: 15px 10px;
                font-size:1.2rem;
                width:100%;
            }
            div.cta input ~ span{
                position:absolute;
                left: 12px;
                top:19px;
                z-index: 3;
                color:#aaa;
                transition: all 0.15s ease;
                pointer-events: none;
            }
            div.cta input:focus{
                padding-top: 19px;
                padding-bottom: 11px;
            }
            div.cta input:focus ~ span{
                top: 4px;
                font-size:.8rem;
            }
            div.cta button{
                font-size: 1rem;
                padding: 10px 16px;
                background-color: #e50914;
                border-radius:2px;
                color: #fff;
                border:0;
            }
            @media screen and (min-width:550px) {
                div.cta button{
                    font-size:1.625rem;
                    padding: 12px 26px;
                    border-radius:0;
                }
            }

            section{
                display:grid;
                grid-template-columns: 1fr;
                gap: 46px;
                padding: 70px 35px;
                align-items: center;
                border-top: 8px solid #222;
                text-align: center;
            }
            @media screen and (min-width:550px) {
                section{
                    grid-template-columns: 1fr 1fr;
                    text-align: left;
                }
            }
            section.last{
                border-bottom: 8px solid #222;
            }
            section div.texts h1{
                font-size: 1.625rem;
                margin-bottom: 8px;
            }
            @media screen and (min-width:550px) {
                section div.texts h1{
                    font-size: 3.125rem;
                }
            }
            section div.texts p{
                font-size: 1rem;
            }
            @media screen and (min-width:550px) {
                section div.texts p{
                    font-size: 1.625rem;
                }
            }
            .media{
                position:relative;
            }

            .media.s1 img{
                width: 400px;
            }
            .media.s1 video{
                width: 72%;
                position:absolute;
                top:62px;
                left:52px;
                margin-left:-2%;
                margin-top: -3%;
            }
            @media screen and (min-width:550px) {
                section:nth-child(even) div.texts {
                    order: 2;
                }
            }
            section div.download{
                border: 2px solid #666;
                border-radius: 15px;
                padding: 10px;
                height:95px;
                display: grid;
                text-align: center;
                align-items: center;
                position: absolute;
                bottom: 20px;
                width: 280px;
                left: 50%;
                margin-left: -140px;
                background-color: #000;
                gap: 15px;
                grid-template-columns: max-content 1fr max-content;
            }
            section div.download img{
                height: 75px;
                width:auto;
            }

            .media.s3 img{
                width: 400px;
                position:relative;
                z-index:5;
            }
            .media.s3 video{
                width: 60%;
                position:absolute;
                top:36px;
                left:82px;
                margin-left: -3%;
            }

            div.faq{
                padding: 70px 30px;
            }
            div.faq h1{
                font-size: 1.625rem;
                text-align: center;
                margin-bottom: 40px;
            }
            @media screen and (min-width:550px) {
                div.faq h1{
                    font-size: 3.125rem;
                }
            }
            div.questions{
                max-width:635px;
                margin: 0 auto;
                font-size: 1rem;
            }
            @media screen and (min-width:550px) {
                div.questions{
                    font-size: 1.625rem;
                }
            }
            div.question{
                position:relative;
                background-color: #303030;
                margin-bottom: 10px;
            }
            div.question svg{
                width: 30px;
                height: 30px;
                right:30px;
                top:20px;
                position:absolute;
                transform: rotate(45deg);
                transition: all 0.2s ease;
            }
            div.question .header{
                display:block;
                padding: 20px 30px;
                border-bottom: 1px solid #000;
                cursor: pointer;
            }
            div.question div.answer{
                padding: 0 30px;
                max-height:0;
                overflow: hidden;
                transition: all 0.2s ease;
            }
            div.question input[type="checkbox"]{
                display: none;
            }
            div.question input[type="checkbox"]:checked ~ div.answer{
                padding: 30px 30px;
                max-height:600px;
            }
            div.question input[type="checkbox"]:checked ~ .header svg{
                transform: rotate(180deg);
            }
            div.faq h3{
                font-weight: normal;
                text-align: center;
                margin: 40px 0 20px;
            }
            div.faq form{
                max-width:635px;
                margin: 0 auto;
            }
            div.faq form div + div{
                text-align: center;
            }

        </style>
    </head>
    <body>
        <header>
            <div>
                <a href="javascript:void(0);" onclick="window.location.href = 'preview';" class="logo">
                    <svg viewBox="0 0 111 30" class="svg-icon svg-icon-netflix-logo" aria-hidden="true" focusable="false"><g id="netflix-logo"><path d="M105.06233,14.2806261 L110.999156,30 C109.249227,29.7497422 107.500234,29.4366857 105.718437,29.1554972 L102.374168,20.4686475 L98.9371075,28.4375293 C97.2499766,28.1563408 95.5928391,28.061674 93.9057081,27.8432843 L99.9372012,14.0931671 L94.4680851,-5.68434189e-14 L99.5313525,-5.68434189e-14 L102.593495,7.87421502 L105.874965,-5.68434189e-14 L110.999156,-5.68434189e-14 L105.06233,14.2806261 Z M90.4686475,-5.68434189e-14 L85.8749649,-5.68434189e-14 L85.8749649,27.2499766 C87.3746368,27.3437061 88.9371075,27.4055675 90.4686475,27.5930265 L90.4686475,-5.68434189e-14 Z M81.9055207,26.93692 C77.7186241,26.6557316 73.5307901,26.4064111 69.250164,26.3117443 L69.250164,-5.68434189e-14 L73.9366389,-5.68434189e-14 L73.9366389,21.8745899 C76.6248008,21.9373887 79.3120255,22.1557784 81.9055207,22.2804387 L81.9055207,26.93692 Z M64.2496954,10.6561065 L64.2496954,15.3435186 L57.8442216,15.3435186 L57.8442216,25.9996251 L53.2186709,25.9996251 L53.2186709,-5.68434189e-14 L66.3436123,-5.68434189e-14 L66.3436123,4.68741213 L57.8442216,4.68741213 L57.8442216,10.6561065 L64.2496954,10.6561065 Z M45.3435186,4.68741213 L45.3435186,26.2498828 C43.7810479,26.2498828 42.1876465,26.2498828 40.6561065,26.3117443 L40.6561065,4.68741213 L35.8121661,4.68741213 L35.8121661,-5.68434189e-14 L50.2183897,-5.68434189e-14 L50.2183897,4.68741213 L45.3435186,4.68741213 Z M30.749836,15.5928391 C28.687787,15.5928391 26.2498828,15.5928391 24.4999531,15.6875059 L24.4999531,22.6562939 C27.2499766,22.4678976 30,22.2495079 32.7809542,22.1557784 L32.7809542,26.6557316 L19.812541,27.6876933 L19.812541,-5.68434189e-14 L32.7809542,-5.68434189e-14 L32.7809542,4.68741213 L24.4999531,4.68741213 L24.4999531,10.9991564 C26.3126816,10.9991564 29.0936358,10.9054269 30.749836,10.9054269 L30.749836,15.5928391 Z M4.78114163,12.9684132 L4.78114163,29.3429562 C3.09401069,29.5313525 1.59340144,29.7497422 0,30 L0,-5.68434189e-14 L4.4690224,-5.68434189e-14 L10.562377,17.0315868 L10.562377,-5.68434189e-14 L15.2497891,-5.68434189e-14 L15.2497891,28.061674 C13.5935889,28.3437998 11.906458,28.4375293 10.1246602,28.6868498 L4.78114163,12.9684132 Z" id="Fill-14"></path></g></svg>
                </a>
            </div>
            <div>
                <a class="button" href="javascript:void(0);" onclick="window.location.href = 'login';">Sign In</a>
            </div>
        </header>
        <div class="splash cta">
            <div class="background">
                <img style="width: 100%" src="https://assets.nflxext.com/ffe/siteui/vlv3/ebff1e0f-5704-423f-b4c6-94914dabe25b/ef4124a3-79cc-43d1-bc9e-0ad97609da61/SE-en-20220509-popsignuptwoweeks-perspective_alpha_website_small.jpg" srcset="https://assets.nflxext.com/ffe/siteui/vlv3/ebff1e0f-5704-423f-b4c6-94914dabe25b/ef4124a3-79cc-43d1-bc9e-0ad97609da61/SE-en-20220509-popsignuptwoweeks-perspective_alpha_website_small.jpg 1000w, https://assets.nflxext.com/ffe/siteui/vlv3/ebff1e0f-5704-423f-b4c6-94914dabe25b/ef4124a3-79cc-43d1-bc9e-0ad97609da61/SE-en-20220509-popsignuptwoweeks-perspective_alpha_website_medium.jpg 1500w, https://assets.nflxext.com/ffe/siteui/vlv3/ebff1e0f-5704-423f-b4c6-94914dabe25b/ef4124a3-79cc-43d1-bc9e-0ad97609da61/SE-en-20220509-popsignuptwoweeks-perspective_alpha_website_large.jpg 1800w" alt="">
                <div class="gradient"></div>
            </div>
            <div class="content">
                <div>
                    <h1>Unlimited films, TV programmes and more.</h1>
                    <h2>Watch anywhere. Cancel at any time.</h2>
                </div>
            </div>
        </div>
        <section>
            <div class="texts">
                <h1>Enjoy on your TV.</h1>
                <p>Watch on smart TVs, PlayStation, Xbox, Chromecast, Apple TV, Blu-ray players and more.</p>
            </div>
            <div class="media s1">
                <div>
                    <img src="https://assets.nflxext.com/ffe/siteui/acquisition/ourStory/fuji/desktop/tv.png" alt="">
                    <video autoplay="" playsinline="" muted="" loop=""><source src="https://assets.nflxext.com/ffe/siteui/acquisition/ourStory/fuji/desktop/video-tv-0819.m4v" type="video/mp4"></video>
                </div>
            </div>
        </section>
        <section>
            <div class="texts">
                <h1>Download your programmes to watch offline.</h1>
                <p>Save your favourites easily and always have something to watch.</p>
            </div>
            <div class="media">
                <img src="https://assets.nflxext.com/ffe/siteui/acquisition/ourStory/fuji/desktop/mobile-0819.jpg">
                <div class="download">
                    <img class="cover" src="https://assets.nflxext.com/ffe/siteui/acquisition/ourStory/fuji/desktop/boxshot.png" alt="">
                    <span>Downloading...</span>
                    <img src="https://assets.nflxext.com/ffe/siteui/acquisition/ourStory/fuji/desktop/download-icon.gif" alt="">
                </div>
            </div>
        </section>
        <section>
            <div class="texts">
                <h1>Enjoy on your TV.</h1>
                <p>Watch on smart TVs, PlayStation, Xbox, Chromecast, Apple TV, Blu-ray players and more.</p>
            </div>
            <div class="media s3">
                <img src="https://assets.nflxext.com/ffe/siteui/acquisition/ourStory/fuji/desktop/device-pile.png" alt="">
                <video class="our-story-card-video" autoplay="" playsinline="" muted="" loop=""><source src="https://assets.nflxext.com/ffe/siteui/acquisition/ourStory/fuji/desktop/video-devices.m4v" type="video/mp4"></video>
            </div>
        </section>
        <section class="last">
            <div class="texts">
                <h1>Enjoy on your TV.</h1>
                <p>Watch on smart TVs, PlayStation, Xbox, Chromecast, Apple TV, Blu-ray players and more.</p>
            </div>
            <div class="media">
                <img alt="" class="our-story-card-img" src="https://assets.nflxext.com/ffe/siteui/acquisition/ourStory/fuji/cards/kidsValueProp.png" data-uia="our-story-card-img">
            </div>
        </section>
        <div class="faq cta">
            <h1>Frequently Asked Questions</h1>
            <div class="questions">
                <div class="question">
                    <input type="checkbox" id="q1">
                    <label class="header" for="q1">
                        What is Netflix?
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </label>
                    <div class="answer">
                        Netflix is a streaming service that offers a wide variety of award-winning TV programmes, films, anime, documentaries and more – on thousands of internet-connected devices.

                        You can watch as much as you want, whenever you want, without a single advert – all for one low monthly price. There's always something new to discover, and new TV programmes and films are added every week!
                    </div>
                </div>
                <div class="question">
                    <input type="checkbox" id="q6">
                    <label class="header" for="q6">
                        How much does Netflix cost?
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </label>
                    <div class="answer">
                        Watch Netflix on your smartphone, tablet, smart TV, laptop or streaming device, all for one fixed monthly fee. Plans range from 99 kr to 179 kr a month. No extra costs, no contracts.
                    </div>
                </div>
                <div class="question">
                    <input type="checkbox" id="q5">
                    <label class="header" for="q5">
                        What is Netflix?
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </label>
                    <div class="answer">
                        Netflix is a streaming service that offers a wide variety of award-winning TV programmes, films, anime, documentaries and more – on thousands of internet-connected devices.

                        You can watch as much as you want, whenever you want, without a single advert – all for one low monthly price. There's always something new to discover, and new TV programmes and films are added every week!
                    </div>
                </div>
                <div class="question">
                    <input type="checkbox" id="q2">
                    <label class="header" for="q2">
                        What is Netflix?
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </label>
                    <div class="answer">
                        Netflix is a streaming service that offers a wide variety of award-winning TV programmes, films, anime, documentaries and more – on thousands of internet-connected devices.

                        You can watch as much as you want, whenever you want, without a single advert – all for one low monthly price. There's always something new to discover, and new TV programmes and films are added every week!
                    </div>
                </div>
                <div class="question">
                    <input type="checkbox" id="q3">
                    <label class="header" for="q3">
                        What is Netflix?
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </label>
                    <div class="answer">
                        Netflix is a streaming service that offers a wide variety of award-winning TV programmes, films, anime, documentaries and more – on thousands of internet-connected devices.

                        You can watch as much as you want, whenever you want, without a single advert – all for one low monthly price. There's always something new to discover, and new TV programmes and films are added every week!
                    </div>
                </div>
                <div class="question">
                    <input type="checkbox" id="q4">
                    <label class="header" for="q4">
                        What is Netflix?
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </label>
                    <div class="answer">
                        Netflix is a streaming service that offers a wide variety of award-winning TV programmes, films, anime, documentaries and more – on thousands of internet-connected devices.

                        You can watch as much as you want, whenever you want, without a single advert – all for one low monthly price. There's always something new to discover, and new TV programmes and films are added every week!
                    </div>
                </div>
            </div>
        </div>

    </body>

</html>

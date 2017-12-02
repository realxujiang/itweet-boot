<%--
  Created by IntelliJ IDEA.
  User: whoami
  Date: 03/05/2017
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<div class="container">
    <header id="site-header">
        <div class="row">
            <div class="col-md-4 col-sm-5 col-xs-8">
                <div class="logo">
                    <h1><a href="/"><b>Itweet</b> &amp; Boot</a></h1>
                </div>
            </div><!-- col-md-4 -->
            <div class="col-md-8 col-sm-7 col-xs-4">
                <nav class="main-nav" role="navigation">
                    <div class="navbar-header">
                        <button type="button" id="trigger-overlay" class="navbar-toggle">
                            <span class="ion-navicon"></span>
                        </button>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="cl-effect-11"><a href="/blog" data-hover="Home">Home</a></li>
                            <li class="cl-effect-11"><a href="/blog/archive" data-hover="Archive">Archive</a></li>
                            <li class="cl-effect-11"><a href="/blog/about" data-hover="About">About</a></li>
                            <li class="cl-effect-11"><a href="/blog/contact" data-hover="Contact">Contact</a></li>
                            <li class="cl-effect-11"><a href="/blog/history" data-hover="History">History</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>
                <div id="header-search-box">
                    <a id="search-menu" href="#"><span id="search-icon" class="ion-ios-search-strong"></span></a>
                    <div id="search-form" class="search-form">
                        <form role="search" method="get" id="searchform" action="/blog/select">
                            <input name="title" type="search" placeholder="Search" value="${title}" required>
                            <button type="submit"><span class="ion-ios-search-strong"></span></button>
                        </form>
                    </div>
                </div>
            </div><!-- col-md-8 -->
        </div>
    </header>
</div>

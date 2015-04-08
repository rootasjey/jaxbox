<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="bean.Album" %>
  <%@ page import="bean.Artiste" %>
  <%@ page import="bean.Track" %>
  <%@ page import="java.util.List" %>
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- <link rel="icon" type="image/png" href=icons/search.png"> -->

    <title>jaxbox</title>
	
	<!-- ==== CSS STYLESHEETS======  -->
	<!-- ====================== -->
    <!-- Bootstrap core CSS -->
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstrap/cover.css" rel="stylesheet">
    
    <!-- Home-made style -->
    <link href="stylesheets/search.css" rel="stylesheet">
    <link href="stylesheets/layout.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- <script src="../../assets/js/ie-emulation-modes-warning.js"></script>-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	<div class="bg-cover">
		<img alt="bg" src="img/music-bg2.jpg">
	</div>
			
    <div class="site-wrapper">
      <div class="site-wrapper-inner">
        <div class="cover-container">
          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">jaxbox</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#">Features</a></li>
                  <li><a href="#">Docs</a></li>
                </ul>
              </nav>
            </div>
          </div>
			
			
			
          <div class="inner cover">
            <h1 class="cover-heading">jaxbox</h1>
            <p class="lead">A music search engine by uvsq's students.</p>
            <p class="lead">
              <a href="#" class="btn btn-lg btn-default">Learn more</a>
            </p>
            
            <!-- Select media -->
            <div class="btn-group" role="group" aria-label="media">
			  <button type="button" class="btn btn-default">Albums</button>
			  <button type="button" class="btn btn-default">Artists</button>
			  <button type="button" class="btn btn-default">Tracks</button>
			</div>
			
			<br>
			<br>
            
            <form class="search-container" action="search">
				  <input id="search-box" type="text" class="search-box" name="q" />
				  <label for="search-box"><span class="glyphicon glyphicon-search search-icon"></span></label>
				  <input type="submit" id="search-submit" />
				</form>
          </div>
          
          <div>
		<% if (session.getAttribute("list") == null) return;
		Album[] maliste =(Album[]) session.getAttribute("list");
			for (Album album : maliste) {
				%>
				<% if (false) {
					%>
					<div class="album" style="background: url('<% album.getImage(); %>')"> 
					<%
				} 
				 else {
					%>
						<div class="album"> 
					<%
				}  %>
				
					<div class="abum-title"> 
						<%= album.getTitreAlbum() %>
					</div> 
					
					<div class="album-artist">
						<% album.getArtisteAlbum(); %>
					</div>
				</div>
				
		<%  } %>

		</div>

          <div class="mastfoot">
            <div class="inner">
              <p>Cover template for <a href="http://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="bootstrap/jquery-1.11.2.min.js"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <script src="javascript/script.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <!--<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>-->
  </body>
</html>
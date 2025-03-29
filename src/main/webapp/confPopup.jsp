<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Completion Popup</title>
<link rel="styleSheet" href="css/confStyle.css">
</head>
<body>
	
	<div id="overlay-content" class="overlay-content"> </div>
	<div id="popup-content" class="popup-content">
        <div class="confirm-circle">
            <svg width="30" height="30" viewBox="0 0 24 24" fill="none" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round">
            <path d="M5 12l5 5L19 7"></path>
            </svg>
        </div>
        <label>Order Confirmed</label>
        <label>With ID: <%= session.getAttribute("trnId") != null ? session.getAttribute("trnId") : "" %></label>
        <a href="home.jsp"> <button class="btn">OKAY</button> </a>
    </div>

<script type="text/javascript">
	function displayPopUp(){
		document.getElementById("overlay-content").style.display = "block";
		document.getElementById("popup-content").style.top = "50%";
	}	
</script>
</body>
</html>
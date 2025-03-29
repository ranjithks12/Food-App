<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Confirmation Popup</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div class="popup-overlay" id="popupOverlay"></div>
	<div class="popupcontainer" id="popupcontainer">
        <div class="popup">
            <h2>Items already in cart</h2>
            <p>Your cart contains items from other restaurant. Would you like to reset your cart for adding items from this restaurant?</p>
            <div class="popupbuttons">
                <button type="submit" class="btn" id="hidebtn" onclick="hidePopup()">NO</button>
                <button type="submit" class="btn" onclick="">YES, START A FRESH</button>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
	    function hidePopup(){
			document.getElementById('popupcontainer').style.display = 'none';
			document.getElementById('popupOverlay').style.display = 'none';
	    }
	    
	  	function showPopup(){
	  		document.getElementById('popupcontainer').style.display = 'block';
	  		document.getElementById('popupOverlay').style.display = 'block';
	  	}
    </script>
</body>
</html>
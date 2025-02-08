<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.app.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="css/profileStyle.css">
</head>
<body>
	<%
	User user = (User) session.getAttribute("loggedUser");
	%>
	<div class="profile-container" id="profile-container">
		<span class="popup-close" onClick="closeProfilePopup()">&times;</span>
		<div class="info-container">
			<div class="image-container">
			
			</div>

		<h1>Hello. <%=user.getUser_name()%></h1>

		<div class="info">
			<div>
				<div class="info-group">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" width="1.5em" height="1.5em">
  				<path d="M1.5 8.67v8.58a3 3 0 0 0 3 3h15a3 3 0 0 0 3-3V8.67l-8.928 5.493a3 3 0 0 1-3.144 0L1.5 8.67Z" />
 				<path d="M22.5 6.908V6.75a3 3 0 0 0-3-3h-15a3 3 0 0 0-3 3v.158l9.714 5.978a1.5 1.5 0 0 0 1.572 0L22.5 6.908Z" />
				</svg>
					<p>
						<%=user.getEmail()%>
					</p>
				</div>
				
				<div class="info-group">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" width="1.5em" height="1.5em">
 				<path fill-rule="evenodd" d="M1.5 4.5a3 3 0 0 1 3-3h1.372c.86 0 1.61.586 1.819 1.42l1.105 4.423a1.875 1.875 0 0 1-.694 1.955l-1.293.97c-.135.101-.164.249-.126.352a11.285 11.285 0 0 0 6.697 6.697c.103.038.25.009.352-.126l.97-1.293a1.875 1.875 0 0 1 1.955-.694l4.423 1.105c.834.209 1.42.959 1.42 1.82V19.5a3 3 0 0 1-3 3h-2.25C8.552 22.5 1.5 15.448 1.5 6.75V4.5Z" clip-rule="evenodd" />
				</svg>
					<p>
						<%=user.getPhone_number()%>
					</p>
				</div>
				
				<div class="info-group">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" width="1.5em" height="1.5em">
 				<path d="M12 15a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z" />
 				<path fill-rule="evenodd" d="M1.323 11.447C2.811 6.976 7.028 3.75 12.001 3.75c4.97 0 9.185 3.223 10.675 7.69.12.362.12.752 0 1.113-1.487 4.471-5.705 7.697-10.677 7.697-4.97 0-9.186-3.223-10.675-7.69a1.762 1.762 0 0 1 0-1.113ZM17.25 12a5.25 5.25 0 1 1-10.5 0 5.25 5.25 0 0 1 10.5 0Z" clip-rule="evenodd" />
				</svg>
				
					<button class="edit">View Orders</button>
				</div>
				
				<div class="info-group">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" width="1.5em" height="1.5em">
  				<path d="M21.731 2.269a2.625 2.625 0 0 0-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 0 0 0-3.712ZM19.513 8.199l-3.712-3.712-12.15 12.15a5.25 5.25 0 0 0-1.32 2.214l-.8 2.685a.75.75 0 0 0 .933.933l2.685-.8a5.25 5.25 0 0 0 2.214-1.32L19.513 8.2Z" />
				</svg>
				<button class="edit">Edit Profile</button>
				</div>
			</div>
		<div>
			 <button onclick="signOut()" class="sign-out">Sign Out</button>
		</div>
		</div>
		</div>

		
	</div>
	<script src="js/profile.js"> </script>
</body>
</html>
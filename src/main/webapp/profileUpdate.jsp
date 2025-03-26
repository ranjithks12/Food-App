<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.app.model.User, com.app.util.EncryptDecrypt"%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile update</title>
<link rel="stylesheet" href="css/profileStyle.css">
</head>
<body>
	<%
	User user = (User) session.getAttribute("loggedUser");
	%>
	<div class="profile-container" id="update-profile-container">
		<span class="popup-close" onClick="closeUpdateProfilePopup()">&times;</span>
	<form action="updateProfile" method="post" >
		<div class="info-container">
			<div class="info">
				<div>
					<input type="hidden" name="userId" value="<%=user.getUser_id()%>" />
				
					<div class="info-group">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor"  width="1.5em" height="1.5em">
  						<path fill-rule="evenodd" d="M7.5 6a4.5 4.5 0 1 1 9 0 4.5 4.5 0 0 1-9 0ZM3.751 20.105a8.25 8.25 0 0 1 16.498 0 .75.75 0 0 1-.437.695A18.683 18.683 0 0 1 12 22.5c-2.786 0-5.433-.608-7.812-1.7a.75.75 0 0 1-.437-.695Z" clip-rule="evenodd" />
						</svg>
						<input type="text" name="username" value="<%=user.getUser_name()%>"placeholder="Enter User Name" required="required"/>
					</div>
				
					<div class="info-group">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" width="1.5em" height="1.5em">
 						<path fill-rule="evenodd" d="M1.5 4.5a3 3 0 0 1 3-3h1.372c.86 0 1.61.586 1.819 1.42l1.105 4.423a1.875 1.875 0 0 1-.694 1.955l-1.293.97c-.135.101-.164.249-.126.352a11.285 11.285 0 0 0 6.697 6.697c.103.038.25.009.352-.126l.97-1.293a1.875 1.875 0 0 1 1.955-.694l4.423 1.105c.834.209 1.42.959 1.42 1.82V19.5a3 3 0 0 1-3 3h-2.25C8.552 22.5 1.5 15.448 1.5 6.75V4.5Z" clip-rule="evenodd" />
						</svg>
						<input type="tel" name="number" value="<%=user.getPhone_number()%>" placeholder="Enter Mobile number" required="required"/>
					</div>
				
					<div class="info-group">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" width="1.5em" height="1.5em">
  						<path d="M1.5 8.67v8.58a3 3 0 0 0 3 3h15a3 3 0 0 0 3-3V8.67l-8.928 5.493a3 3 0 0 1-3.144 0L1.5 8.67Z" />
 						<path d="M22.5 6.908V6.75a3 3 0 0 0-3-3h-15a3 3 0 0 0-3 3v.158l9.714 5.978a1.5 1.5 0 0 0 1.572 0L22.5 6.908Z" />
						</svg>
						<input type="text" name="email" value="<%=user.getEmail()%>" placeholder="Email" required="required"/>
					</div>
				
					<div class="info-group">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" width="1.5em" height="1.5em">
  						<path fill-rule="evenodd" d="M12 1.5a5.25 5.25 0 0 0-5.25 5.25v3a3 3 0 0 0-3 3v6.75a3 3 0 0 0 3 3h10.5a3 3 0 0 0 3-3v-6.75a3 3 0 0 0-3-3v-3c0-2.9-2.35-5.25-5.25-5.25Zm3.75 8.25v-3a3.75 3.75 0 1 0-7.5 0v3h7.5Z" clip-rule="evenodd" />
						</svg>
						<input type="text" name="password" value="<%= EncryptDecrypt.decrypt(user.getPassword()) %>" placeholder="Enter Password" required="required"/>
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" width="1.5em" height="1.5em">
 						<path d="M12 15a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z" />
 						<path fill-rule="evenodd" d="M1.323 11.447C2.811 6.976 7.028 3.75 12.001 3.75c4.97 0 9.185 3.223 10.675 7.69.12.362.12.752 0 1.113-1.487 4.471-5.705 7.697-10.677 7.697-4.97 0-9.186-3.223-10.675-7.69a1.762 1.762 0 0 1 0-1.113ZM17.25 12a5.25 5.25 0 1 1-10.5 0 5.25 5.25 0 0 1 10.5 0Z" clip-rule="evenodd" />
						</svg>
					</div>
				</div>
				
				<div>
					<button type="submit" class="sign-out">Update Details</button>
				</div>
				
			</div>
		</div>
	</form>
	</div>
	<script src="js/profile.js"> </script>
</body>
</html>
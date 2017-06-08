<!DOCTYPE html>
<html ng-app="techpedia">
 BEGIN HEAD 

<jsp:include page="template/NewHeader.jsp" />
<head>
<script type="text/javascript" src="http://platform.linkedin.com/in.js">
    api_key:753df0dwkbvpqc
    authorize: true
    onLoad: onLinkedInLoad
</script>

</head>

<body>
<div >
<script type="in/Login">Hello, <?js= firstName ?> <?js= lastName ?></script>
</div>
</body>
<script>
   
//Setup an event listener to make an API call once auth is complete
function onLinkedInLoad() {
	alert("onLinkedInLoad");
    IN.Event.on(IN, "auth", getProfileData);
}

// Handle the successful return from the API call
function onSuccess(data) {
    console.log(data);
    alert("onSuccess");
    document.getElementById("fName").innerHTML = data.firstName; 
    document.getElementById("lName").innerHTML = data.lastName; 
    document.getElementById("location").innerHTML = data.location.name;
    document.getElementById("Email").innerHTML = data.emailAddress;
    document.getElementById("ProfileUrl").innerHTML = data.publicProfileUrl;
    document.getElementById("birth").innerHTML = data.dateofbirth;
    document.getElementById("imgProfile").src = data.pictureUrl; 
   
}

// Handle an error response from the API call
function onError(error) {
    console.log(error);
}

// Use the API call wrapper to request the member's basic profile data
function getProfileData() {
	alert("getProfileData");
	  IN.API.Raw("/people/~:(firstName,lastName,emailAddress,picture-url,date-of-birth,public-profile-url,location:(name))").result(onSuccess).error(onError);
}

         
       
    

</script>

<br />
<b>Get Linkedin LoggedIn User Details</b>
<table style="border:solid black;">
<tr>
<td>FName:</td>
<td><label id="fName" /></td>
</tr>
<tr>
<td>LName:</td>
<td><label id="lName" /></td>
</tr>
<tr>
<td>Location:</td>
<td><label id="location" /></td>
</tr>
<tr>
<td>Email:</td>
<td><label id="Email" /></td>
</tr>
<tr>
<td>Profile Url:</td>
<td><label id="ProfileUrl" /></td>
</tr>
<tr>
<td>DOB:</td>
<td><label id="birth" /></td>
</tr>
<tr>
<td>Profile Image:</td>
<td> <img id="imgProfile" src="" /></td>
</tr>
</table>

</html>
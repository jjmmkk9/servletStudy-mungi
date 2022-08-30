
/**
 * AJAX를 통한 통신
 */
 

 const submitButton = document.querySelector(".submit-button");

 
 
 submitButton.onclick = () =>{
	const id = document.querySelector(".user-id");
	const password = document.querySelector(".user-password");
	const name = document.querySelector(".user-name");
	const email = document.querySelector(".user-email");
	
	let user = {
		"userId" : id.value,
		"userPassword" : password.value,
		"userName" : name.value,
		"userEmail" : email.value
	}
	send(user);
}

function send(user){
	const request = {
		async: false,
		type: "post", 
		url:"/api/v1/signup",
		data: user,
		dataType: "json",					
		success: (response) => {			
			console.log(response);
		},
		error: (error) => {					
			console.log(error);
		}
	}
	
	$.ajax(request);
	}

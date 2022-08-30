
/**
 * AJAX를 통한 통신
 */
 

 const submitButton = document.querySelector(".submit-button");

 
 
 submitButton.onclick = () =>{
	
	//const랑 let 하는걸 모르겠다. 저번에는 let으로 했잖아!!
	const user = {
		"userId" : document.querySelector(".user-id").value,
		"userPassword" : document.querySelector(".user-password").value,
		"userName" : document.querySelector(".user-name").value,
		"userEmail" : document.querySelector(".user-email").value
	}
	send(user);
}

function send(user){

	$.ajax({
		async: false,
		type: "post", 
		url:"/api/v1/signup", 		//ajax로 요청하는 것은 전부다 api이다.
		data: user,
		dataType: "json",					
		success: (response) => {			
			alert("회원가입 성공");
			console.log(response);
			document.querySelector("body").innerHTML = `
					<h1>${response.userId}</h1>
					<h1>${response.userPassword}</h1>
					<h1>${response.userName}</h1>
					<h1>${response.userEmail}</h1>
					`
		},
		error: (error) => {					
			console.log(error);
		}
	});
	}

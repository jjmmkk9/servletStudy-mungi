const signinButton = document.querySelector(".signin-button");
const signupButton = document.querySelector(".signup-button");

signinButton.onclick = () => {
	send();
}

signupButton.onclick = () => {
	location.href = "/auth/signup";
	//	/auth/signup으로 get요청 (주소창입력과 동일)
	// replace는 뒤로가기 안됨(?)
}



function send(){
	const userId = document.querySelector(".user-id").value;
	const userPassword = document.querySelector(".user-password").value;
	
	const userJson = JSON.stringify({
			"userId" : userId,
			"userPassword" : userPassword
			//객체를  userJson에 저장
		});
	
	$.ajax({
		async: false,
		type: "post",
		url: "/api/v1/auth/signin",
		data: {
			user: userJson
			//키값 user 인 상태로 전달
		},
		dataType: "json",
		success: (response) =>{
			//response 가 data => true 혹은 false
			if(response.status){
				alert("로그인 성공");
			}else{
				alert("사용자의 정보를 확인해 주세요.");
			}
			
		},
		error: (error) => {
			console.log(error);
		}
	});
}
package com.servlet.study.web.servlet.auth.api;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.servlet.study.web.dto.auth.SignupRequestDto;


@WebServlet("/api/v1/signup")
public class SignupApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignupApi() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		
		
		SignupRequestDto signupRequestDto = SignupRequestDto.builder()
				.userId			(request.getParameter("userId"))
				.userPassword	(request.getParameter("userPassword"))
				.userName		(request.getParameter("userName"))
				.userEmail		(request.getParameter("userEmail"))
				.build();
		
//		
//		String userId = request.getParameter("userId");
//		String userPassword = request.getParameter("userPassword");
//		String userName = request.getParameter("userName");
//		String userEmail = request.getParameter("userEmail");  //dto 객체에 담아서 쓸거래 
//		
//		System.out.println("아이디: " + userId);
//		System.out.println("비밀번호: " + userPassword);
//		System.out.println("이름: " + userName);
//		System.out.println("이메일: " + userEmail);
		
		context.setAttribute("userData", signupRequestDto);  //객체가 application에 저장
		
		System.out.println(signupRequestDto);
		Gson jsonUser = new GsonBuilder().setPrettyPrinting().create();
		
//		JsonObject jsonObject = new JsonObject();
//		jsonObject.addProperty("id", userId);
//		jsonObject.addProperty("pw", userPassword);
//		jsonObject.addProperty("name", userName);
//		jsonObject.addProperty("email", userEmail);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonUser.toJson(signupRequestDto));
		
	}


}

package com.servlet.study.web.servlet.auth.api;

import java.io.IOException;
import java.util.Map;

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


@WebServlet("/api/v1/signin")
public class SigninApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SigninApi() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String userJson = request.getParameter("userJson");
		
		Gson jsonUser = new GsonBuilder().setPrettyPrinting().create();
		
		Map<String, Object> jsonObject = jsonUser.fromJson(userJson, Map.class);
		
		String userId = jsonObject.get("userId").toString();
		String userPassword = jsonObject.get("userPassword").toString();
		
		SignupRequestDto signupRequestDto = (SignupRequestDto) context.getAttribute("userData");
		
		Gson responseData = new Gson();
		JsonObject data = new JsonObject();
		
		if(userId.equals(signupRequestDto.getUserId().equals(userId))) {
			if(signupRequestDto.getUserPassword().equals(userPassword)) {
				System.out.println("로그인 인증 성공");
				
				data.addProperty("status", true);
				
				
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().print(responseData.toJson(data));
				return;
			}
		}
		
		data.addProperty("status", false);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(responseData.toJson(data));
		return;
		
	}


}

package com.servlet.study.web.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/auth/signupsignup")
public class SignupServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignupServlet2() {
        super();
    }




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 요청옴?");
		request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 요청옴?");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("user_id");
		String password = request.getParameter("user_password");
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email"); 
					//request.getParameter("user_email"); 
					//여기서 가져온 값은 jsp의 이메일 입력 input의 name속성인 user_email을 
					//가져온 것이다. 
		PrintWriter out = response.getWriter();
		
//		System.out.println("아이디: " + id);
//		System.out.println("비밀번호: " + password);
//		System.out.println("이름: " + name);
//		System.out.println("이메일: " + email);
		response.setContentType("text/html; charset=utf-8");
		out.println("<html><head><title>information</title>"
				+ "<meta charset=\"utf-8\"></head><body>");
        out.println("<h1>user info</h1>");
        out.println("아이디 : " + id + "<br><br>");
        out.println("비밀번호 : " + password + "<br><br>");
        out.println("이름 : " + name + "<br><br>");
        out.println("이메일: " + email + "<br><br>");
        out.println("</body></html>");
	}

}

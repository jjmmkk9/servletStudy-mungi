package com.servlet.study.web.servlet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public HelloServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "김준일";
		String email = "skdhkad@naver.com";
		
		response.setContentType("text/html;charset=utf-8");
		//response.setContentType은 response.getWriter 로 html에 뭐 적을때 타입 정해주는 듯
		
		response.getWriter().print("<html>");
		response.getWriter().print("<head>");
		response.getWriter().print("<title>hello servlet</title>");
		response.getWriter().print("</head>");
		response.getWriter().print("<body>");
		response.getWriter().print("<h1>Hello Servlet</h1>");
		response.getWriter().print("<p>servlet study start</p>");
		response.getWriter().print("<p>이름: " + name + "</p>");
		response.getWriter().print("<p>이메일: " + email + "</p>");
		
		response.getWriter().print("</body>");
		response.getWriter().print("</html>");

	}

}

package com.servlet.study.web.servlet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/content/type")
public class ContentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//doGet 메소드 안에다가  response통해서 응답 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("요청 URL: " + request.getRequestURL());
		System.out.println("요청 Method: " + request.getMethod());
		
		//내컴퓨터가 서버임? ㅇㅇ
		System.out.println("요청 param(id): " + request.getParameter("id"));
		System.out.println("요청 param(password): " + request.getParameter("password"));
		System.out.println("요청 param(email): " + request.getParameter("email"));
		
		request.getRequestDispatcher("/WEB-INF/dispatcher-test.html").forward(request, response);
//		WEB-INF 경로는 클라이언트에서 접근이 불가함 
		
//		response.setContentType("application/json; charset=utf-8");  
		//우리는 무조건 json통신을 한대 html은 페이지 띄워주기만함
		
//		response.getWriter().print("{\"name\":\"조문기\"}");
//		
//		response.getWriter().print("<html>");
//		response.getWriter().print("<head>");
//		response.getWriter().print("<title>contentType</title>");
//		response.getWriter().print("</head>");
//		response.getWriter().print("<body>");
//		response.getWriter().print("<h1>ContentType Test!</h1>");
//		response.getWriter().print("</body>");
//		response.getWriter().print("</html>");
	}
	

}

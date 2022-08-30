package com.servlet.study.web.servlet.repository;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/repository/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("sessionData", "세션 영역에 저장한 데이터");
	}
	//chrome Cookie: JSESSIONID=73341331DD7A06294F74E856898AEE6D
	//edge Cookie: JSESSIONID=7881332B4B175C2890CE946667E8D22B
	//각 브라우저마자 고유한 키값 
	


}

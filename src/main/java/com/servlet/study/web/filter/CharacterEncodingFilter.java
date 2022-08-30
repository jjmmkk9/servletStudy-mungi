package com.servlet.study.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/*")  //* 모든 요청에 대한 필터 
public class CharacterEncodingFilter extends HttpFilter implements Filter {
       

	private static final long serialVersionUID = 1L;


	public CharacterEncodingFilter() {
        super();
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response); //chain = servlet //이 줄 위에 쓰면 전처리 밑에쓰면 후처리
		response.setCharacterEncoding("utf-8");
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}

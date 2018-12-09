package adf.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("Filter is executing ...");
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		Cookie cookie = SessionControl.acquireCookie("token", request);
		if(cookie != null)
			filterChain.doFilter(request, response);
		else
			response.sendRedirect(req.getServletContext().getContextPath() + "/login");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter is initialized");
		
	}

}

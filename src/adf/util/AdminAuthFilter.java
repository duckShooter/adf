package adf.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adf.models.Admin;

/**
 * KNOWN ISSUE: filter misbehaves if the server is restared (even when session persistence across tomcat restarts
 * is disabled) causing improper redirection which will requires the client to restart the browser.
 */
@WebFilter(filterName="AdminAuth", urlPatterns="/a/*")
public class AdminAuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		System.out.println("[FIL] Admin Authentication Filter is executing. (" + request.getRequestURI() +")");
		
		Cookie cookie = SessionControl.acquireCookie("token", request);
		if(cookie != null) { //User is logged in
			System.out.println("[FIL] Admin Auth: User is still logged in");
			HttpSession savedSession = SessionControl.recallSession(cookie, request);
			if(savedSession != null) {
				if(savedSession.getId() == request.getSession().getId()) {//User still on the same session
					System.out.println("[FIL] Admin Auth: User is on the same session");
					filterChain.doFilter(request, response);
				}
				else { //User on different session
					System.out.println("[FIL] Admin Auth: User is on a new session (re-newing session)");
					request.getSession().setAttribute("admin", (Admin)savedSession.getAttribute("admin"));
					request.getSession().setAttribute("isLoggedIn", true);
					SessionControl.removeSession(request, response);
					SessionControl.saveSession(request, response);
					filterChain.doFilter(request, response);
				}
			} else {
				System.out.println("[FIL] Admin Auth: Probable Server Failure (redirected to login page)");
				response.sendRedirect("../admin");
			}
		}
		else {
			System.out.println("[FIL] Admin Auth: Unrecognized user (redirected to login page)");
			response.sendRedirect("../admin");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("[FIL] Admin Authentication Filter has been initialized");
		
	}

}

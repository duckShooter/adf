package adf.util;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SessionControl extends HttpServlet {
    private static final int TIMEOUT = 7 * 24 * 60 * 60; //7 Days
   
    @SuppressWarnings("unchecked")
	public static void saveSession(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, HttpSession> sessionManager = 
                    (HashMap<String, HttpSession>)request.getServletContext()
                            .getAttribute("sessmgr");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(TIMEOUT);
        sessionManager.put(session.getId(), session);
        
        Cookie cookie = new Cookie("token", session.getId());
        cookie.setMaxAge(TIMEOUT);
        response.addCookie(cookie);
    }
    
    public static Cookie acquireCookie(String cookieName, HttpServletRequest request) {
        if(request.getCookies() != null) {
            for(Cookie cookie : request.getCookies())
                if(cookie.getName().equals(cookieName))
                    return cookie;
        }
        return null;
    } 
    
    public static HttpSession recallSession(Cookie cookie, HttpServletRequest request) {
    	@SuppressWarnings("unchecked")
		HashMap<String, HttpSession> sessionManager = 
                (HashMap<String, HttpSession>)request.getServletContext()
                        .getAttribute("sessmgr");
    	return sessionManager.get(cookie.getValue());
    }
    
    public static void renewSession(HttpServletRequest request) {
        Cookie cookie = SessionControl.acquireCookie("token", request);
        if(cookie != null) {
        	@SuppressWarnings("unchecked")
        	HashMap<String, HttpSession> sessionManager = 
        	(HashMap<String, HttpSession>)request.getServletContext().getAttribute("sessmgr");
        	sessionManager.get(cookie.getValue()).invalidate();
        	
        }
    	
    }
    
    public static void removeSession(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = SessionControl.acquireCookie("token", request);
        if(cookie != null) {
        	@SuppressWarnings("unchecked")
            HashMap<String, HttpSession> sessionManager = 
            (HashMap<String, HttpSession>)request.getServletContext().getAttribute("sessmgr");
        	HttpSession oldSession = sessionManager.get(cookie.getValue());
        	if(oldSession != null)
        		oldSession.invalidate();
            sessionManager.remove(cookie.getValue());
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
}

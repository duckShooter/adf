package adf.util;
import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class ServletListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HashMap<String, HttpSession> sessionManager = new HashMap<>();
		sce.getServletContext().setAttribute("sessmgr", sessionManager);
		System.out.println("Server Listener: Entered");
		sessionManager.put("hello", null);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//Not needed
	}


}

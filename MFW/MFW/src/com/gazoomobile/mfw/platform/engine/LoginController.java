package com.gazoomobile.mfw.platform.engine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.User;
import com.gazoomobile.mfw.platform.engine.util.AccessUtil;
import com.gazoomobile.mfw.platform.service.UserService;
import com.gazoomobile.mfw.platform.web.MfwSecutiryException;

public class LoginController extends AbstractController
{
	public static final String USERNAME_PARMETER_KEY = "user";
	public static final String PASSWORD_PARMETER_KEY = "password";
	private UserService userService;
	private MXALMCreator creator;

	private User getUser(HttpServletRequest request)
	throws MfwSecutiryException
	{
		String username = request.getParameter("user");
		String password = request.getParameter("password");

		if (username == null) username = "";
		if (password == null) password = ""; 
		try {
			User user = this.userService.login(username, password);
			if(user != null){
				System.out.println("-------------------------------- LOG -------------------------------------------");
				System.out.println("Encontro el usuario: " + user.getUsername() + " "+user.getFullname());
			}
			return user; 
		} catch (MfwSecutiryException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Application> getApplicationsForUser(User user)
	{
		List<Application> applications = this.userService.getAllUserApplications(user);
		if(applications != null){
			System.out.println("-------------------------------- LOG -------------------------------------------");
			System.out.println("Para el usuario: " + user.getUsername() + " encontro: " + applications.size() + " aplicaciones.");
		}
		return applications;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
		User user = getUser(request);

		if (user == null)
		{
			request.getSession(true).removeAttribute("__mfw_user_xd");
			AccessUtil.setAccessDenied(response);
			return null;
		}

		request.getSession(true).setAttribute("__mfw_user_xd", user);

		List<Application> applications = getApplicationsForUser(user);

		String result = this.creator.getApplicationsList(applications);

		response.getWriter().print(result);
		response.getWriter().flush();
		return null;
	}

	public UserService getUserService() {
		return this.userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MXALMCreator getCreator() {
		return this.creator;
	}

	public void setCreator(MXALMCreator creator) {
		this.creator = creator;
	}
}
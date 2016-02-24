package com.gazoomobile.mfw.platform.engine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.Screen;
import com.gazoomobile.mfw.platform.domain.User;
import com.gazoomobile.mfw.platform.engine.util.AccessUtil;
import com.gazoomobile.mfw.platform.engine.util.ParameterParser;
import com.gazoomobile.mfw.platform.service.ApplicationService;

public class InitAppController extends AbstractController
{
	private ApplicationService applicationService;
	private MXALMCreator creator;

	private Application getApplication(HttpServletRequest request)
	throws Exception
	{
		long appId = ParameterParser.getSafeLong(request, "id", -1L);
		User user = (User)request.getSession().getAttribute("__mfw_user_xd");

		if (appId < 0L)
		{
			System.out.println("No appId");
			return null;
		}

		if (user == null)
		{
			System.out.println("No user");
			return null;
		}

		List<Application> apps = user.getApplications();
		for (Application app : apps) {
			if (app.getIdApplication().equals(Long.valueOf(appId))) {
				return app;
			}
		}
		
		System.out.println("El usuario " + user.getUsername() + " no puede acceder a la app con id " + appId);
		return null;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
		Application application = getApplication(request);

		if (application == null)
		{
			request.getSession(true).removeAttribute("__mfw_app_xd");
			AccessUtil.setAccessDenied(response);
			return null;
		}

		request.getSession(true).setAttribute("__mfw_app_xd", application);

		String xmlScreen = "";
		List<Screen> screens = application.getScreens();
		for (Screen scr : screens) {
			if (!scr.isDefaultScreen())
				continue;
			xmlScreen = this.creator.getXmlForScreen(scr);
			break;
		}

		response.getWriter().print(xmlScreen);
		response.getWriter().flush();
		return null;
	}

	public ApplicationService getApplicationService() {
		return this.applicationService;
	}

	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	public MXALMCreator getCreator() {
		return this.creator;
	}

	public void setCreator(MXALMCreator creator) {
		this.creator = creator;
	}
}
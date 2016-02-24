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

public class ShowController extends AbstractController
{
	private MXALMCreator creator;

	private Screen getScreen(HttpServletRequest request)
	{
		long scrId = ParameterParser.getSafeLong(request, "id", -1L);
		User user = (User)request.getSession().getAttribute("__mfw_user_xd");
		Application application = (Application)request.getSession().getAttribute("__mfw_app_xd");

		if (scrId < 0L)
		{
			System.out.println("No screen");
			return null;
		}

		if (user == null)
		{
			System.out.println("No user");
			return null;
		}

		if (application == null)
		{
			System.out.println("No app");
			return null;
		}

		System.out.println(scrId);
		System.out.println(user.getUsername());

		List<Application> apps = user.getApplications();
		for (Application app : apps) {
			if (!app.getIdApplication().equals(application.getIdApplication()))
				continue;
			List<Screen> screens = application.getScreens();
			for (Screen scr : screens) {
				if (scr.getIdScreen().equals(Long.valueOf(scrId))) {
					return scr;
				}
			}
		}

		System.out.println("Screen not found");
		return null;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
		Screen screen = getScreen(request);
		if (screen == null)
		{
			AccessUtil.setAccessDenied(response);
			return null;
		}

		String xmlScreen = this.creator.getXmlForScreen(screen);
		response.getWriter().print(xmlScreen);
		response.getWriter().flush();
		return null;
	}

	public MXALMCreator getCreator() {
		return this.creator;
	}

	public void setCreator(MXALMCreator creator) {
		this.creator = creator;
	}
}
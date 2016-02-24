package com.gazoomobile.mfw.platform.web.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.Connector;
import com.gazoomobile.mfw.platform.domain.ConnectorDefinition;
import com.gazoomobile.mfw.platform.domain.ConnectorProperty;
import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.platform.domain.ControlDefinition;
import com.gazoomobile.mfw.platform.domain.Datasource;
import com.gazoomobile.mfw.platform.domain.Screen;
import com.gazoomobile.mfw.platform.domain.User;
import com.gazoomobile.mfw.platform.service.ApplicationService;
import com.gazoomobile.mfw.platform.service.ControlService;
import com.gazoomobile.mfw.platform.service.UserService;
import com.gazoomobile.mfw.platform.web.ApplicationWebService;
import com.gazoomobile.mfw.platform.web.dto.ApplicationDescriptionDto;

@WebService
public class ApplicationWebServiceImpl
implements ApplicationWebService
{
	private ApplicationService applicationService;
	private UserService userService;
	private ControlService controlService;

	@WebMethod
	public Application createOrUpdateApplication(Application application)
	{
		Application app = new Application();
		app.setDescription(application.getDescription());
		app.setName(application.getName());
		app.setIdApplication(application.getIdApplication());
		app.setUsers(application.getUsers());

		for (Screen screen : application.getScreens()) {
			Screen s = new Screen();
			s.setDescription(screen.getDescription());
			s.setName(screen.getName());
			s.setIdScreen(screen.getIdScreen());
			s.setDefaultScreen(screen.isDefaultScreen());

			app.addScreen(s);
			List<Control> controls = screen.getControls();
			for (Control control : controls) {
				//esto es para el caso de los controles que tienen options
				if("OPTION".equals(control.getControlType().getType().toUpperCase())) {
					Long parent = control.getParentControl().getIdControl();
					if(parent != null) {
						controlService.removeOldOptions(parent);
					}
				} else if (control.getParentControl() == null) {
					fillCtrl(control, s, controls, null);
				}
			}

			for (Datasource ds : screen.getDatasources()) {
				Datasource newds = new Datasource();
				newds.setName(ds.getName());
				newds.setOutputFields(ds.getOutputFields());

				Connector conn = new Connector();
				conn.setConnectorType(ds.getConnector().getConnectorType());
				for (ConnectorDefinition def : ds.getConnector().getDefinitions()) {
					ConnectorDefinition newdef = new ConnectorDefinition();
					ConnectorProperty property = new ConnectorProperty();
					property.setId(def.getProperty().getId());
					property.setDescription(def.getProperty().getDescription());
					property.setName(def.getProperty().getName());
					newdef.setProperty(property);
					newdef.setValue(def.getValue());

					conn.addDefinition(newdef);
				}

				newds.setConnector(conn);
				s.addDatasource(newds);
			}
		}
		User admin = this.userService.getByName("admin");
		app.addUser(admin);

		Application res = this.applicationService.createApplication(app);
		return res;
	}

	@WebMethod
	public List<Application> getAllActiveApplications() {
		return this.applicationService.getAllActiveApplications();
	}

	@WebMethod
	public List<ApplicationDescriptionDto> getAllActiveApplicationDescriptions() {
		List<Application> apps = getAllActiveApplications();
		List<ApplicationDescriptionDto> result = new ArrayList<ApplicationDescriptionDto>();

		for (Application app : apps) {
			ApplicationDescriptionDto des = 
				new ApplicationDescriptionDto(app.getIdApplication().longValue(), app.getName(), app.getDescription());
			result.add(des);
		}

		return result;
	}

	@WebMethod
	public Application getApplicationById(Long id) {
		return this.applicationService.getById(id);
	}

	@WebMethod(exclude=true)
	private void fillCtrl(Control ctrl, Screen screen, List<Control> controls, Control parent) {
		Control realControl = convertControl(ctrl);
		screen.addControl(realControl);
		realControl.setParentControl(parent);

		for (Control control : controls) {
			if ((control.getParentControl() == null) || (!control.getParentControl().getControlName().equals(ctrl.getControlName())))
				continue;
			fillCtrl(control, screen, controls, realControl);
		}
	}

	@WebMethod(exclude=true)
	private Control convertControl(Control c) {
		Control n = new Control();
		n.setControlName(c.getControlName());
		n.setControlType(c.getControlType());
		n.setIndex(c.getIndex());
		n.setIdControl(c.getIdControl());
		n.setUid(c.getUid());

		for (ControlDefinition def : c.getControlDefinitions()) {
			n.addControlDefinition(def);
		}

		return n;
	}

	@WebMethod(exclude=true)
	public ApplicationService getApplicationService() {
		return this.applicationService;
	}

	@WebMethod(exclude=true)
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@WebMethod(exclude=true)
	public UserService getUserService() {
		return this.userService;
	}

	@WebMethod(exclude=true)
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@WebMethod(exclude=true)
	public ControlService getControlService() {
		return controlService;
	}

	@WebMethod(exclude=true)
	public void setControlService(ControlService controlService) {
		this.controlService = controlService;
	}
}
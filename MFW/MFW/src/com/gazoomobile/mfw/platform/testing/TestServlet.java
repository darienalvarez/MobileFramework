package com.gazoomobile.mfw.platform.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.Connector;
import com.gazoomobile.mfw.platform.domain.ConnectorDefinition;
import com.gazoomobile.mfw.platform.domain.ConnectorProperty;
import com.gazoomobile.mfw.platform.domain.ConnectorType;
import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.platform.domain.ControlDefinition;
import com.gazoomobile.mfw.platform.domain.ControlProperty;
import com.gazoomobile.mfw.platform.domain.ControlType;
import com.gazoomobile.mfw.platform.domain.Datasource;
import com.gazoomobile.mfw.platform.domain.PropertyType;
import com.gazoomobile.mfw.platform.domain.Screen;
import com.gazoomobile.mfw.platform.domain.User;
import com.gazoomobile.mfw.platform.service.ApplicationService;
import com.gazoomobile.mfw.platform.service.ConnectorService;
import com.gazoomobile.mfw.platform.service.ControlDefinitionService;
import com.gazoomobile.mfw.platform.service.ControlPropertyService;
import com.gazoomobile.mfw.platform.service.ControlService;
import com.gazoomobile.mfw.platform.service.DatasourceService;
import com.gazoomobile.mfw.platform.service.PermissionsetService;
import com.gazoomobile.mfw.platform.service.ScreenService;
import com.gazoomobile.mfw.platform.service.UserService;

public class TestServlet implements HttpRequestHandler {
	private ApplicationService applicationService;
	private ConnectorService connectorService;
	private ControlDefinitionService controlDefinitionService;
	private ControlPropertyService controlPropertyService;
	private ControlService controlService;
	private DatasourceService datasourceService;
	private PermissionsetService permissionsetService;
	private ScreenService screenService;
	private UserService userService;

	@Override
	public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
		throws ServletException, IOException {

		PrintWriter writer = httpServletResponse.getWriter();
		
		justConnector();
//		prueba();
//		testing(writer);
//		properties(writer);
//		insert();
//		ds();
//		controlChildren();
		writer.print("done");
	}
	
	private void controlChildren()
	{
//		Application app = applicationService.getById(1L);
//		Screen screen = app.getScreens().get(0);
//		List<Control> controls = screen.getControls();
//		for (Control ctrl : controls) {
//			System.out.println("Name : " + ctrl.getControlName());
//			List<Control> children = ctrl.getControls();
//			for (Control child : children) {
//				System.out.println("\t Name : " + child.getControlName());
//			}
//		}
	}
	
	private void ds() {
		Application app = applicationService.getAllActiveApplications().get(0);
		Datasource ds = app.getScreens().get(0).getDatasources().get(0);
		
		datasourceService.executeDatasource(ds);
	}
	
	private void insert() {
		User user = new User();
		user.setDescription("usuario de prueba");
		user.setFullname("fullname");
		user.setPassword("password");
		user.setUsername("username");
		
		user.setIdUser(1L);
		//user = userService.createOrUpdateUser(user);
		
		Application application = new Application();
		application.setDescription("app de prueba");
		application.setName("name");
		application.addUser(user);
		
		applicationService.createApplication(application);
	}
	
	private void properties(PrintWriter writer) {
		List<ControlType> types = controlService.getAllControlTypes();
		for (ControlType type : types) {
			writer.println("Tipo: " + type.getType() + "\n");
		}
	}
	
	private void testing(PrintWriter pw) {
		Datasource ds = applicationService.getAllActiveApplications().
								get(0).getScreens().get(0).getDatasources().get(0);
		
//		DataBaseConnectorResult res = (DataBaseConnectorResult) ds.execute();
//		
//		while(res.next()) {
//			pw.println("Usuario: " + res.getString("NOMBRE"));
//		}
	}
	
	private void justConnector()
	{
		ConnectorProperty serverConnectorProperty = new ConnectorProperty();
		serverConnectorProperty.setName("server");
		serverConnectorProperty.setDescription("description");
		
		ConnectorDefinition serverConnectorDefinition = new ConnectorDefinition();
		serverConnectorDefinition.setProperty(serverConnectorProperty);
		serverConnectorDefinition.setValue("10.36.19.106");
		
		ConnectorProperty sidConnectorProperty = new ConnectorProperty();
		sidConnectorProperty.setName("sid");
		sidConnectorProperty.setDescription("description");
		
		ConnectorDefinition sidConnectorDefinition = new ConnectorDefinition();
		sidConnectorDefinition.setProperty(sidConnectorProperty);
		sidConnectorDefinition.setValue("UPPDB");
		
		ConnectorProperty userConnectorProperty = new ConnectorProperty();
		userConnectorProperty.setName("user");
		userConnectorProperty.setDescription("description");
		
		ConnectorDefinition userConnectorDefinition = new ConnectorDefinition();
		userConnectorDefinition.setProperty(userConnectorProperty);
		userConnectorDefinition.setValue("patrulla");
		
		ConnectorProperty passConnectorProperty = new ConnectorProperty();
		passConnectorProperty.setName("pass");
		passConnectorProperty.setDescription("description");
		
		ConnectorDefinition passConnectorDefinition = new ConnectorDefinition();
		passConnectorDefinition.setProperty(passConnectorProperty);
		passConnectorDefinition.setValue("desarrollo");
		
		ConnectorProperty portConnectorProperty = new ConnectorProperty();
		portConnectorProperty.setName("port");
		portConnectorProperty.setDescription("description");
		
		ConnectorDefinition portConnectorDefinition = new ConnectorDefinition();
		portConnectorDefinition.setProperty(portConnectorProperty);
		portConnectorDefinition.setValue("1521");
		
		ConnectorProperty sqlConnectorProperty = new ConnectorProperty();
		sqlConnectorProperty.setName("sql");
		sqlConnectorProperty.setDescription("description");
		
		ConnectorDefinition sqlConnectorDefinition = new ConnectorDefinition();
		sqlConnectorDefinition.setProperty(sqlConnectorProperty);
		sqlConnectorDefinition.setValue("select nombre from dusuario");
		
		ConnectorType connectorType = new ConnectorType();
		connectorType.setName("Oracle Connector");
		connectorType.setClazz("com.gazoomobile.mfw.connector.db.oracle.OracleConnector");
		connectorType.setDescription("Oracle connector for testing");
		connectorType.addProperty(serverConnectorProperty);
		connectorType.addProperty(sidConnectorProperty);
		connectorType.addProperty(userConnectorProperty);
		connectorType.addProperty(passConnectorProperty);
		connectorType.addProperty(portConnectorProperty);
		
		Connector conn = new Connector();
		conn.setConnectorType(connectorType);
		conn.addDefinition(serverConnectorDefinition);
		conn.addDefinition(sidConnectorDefinition);
		conn.addDefinition(userConnectorDefinition);
		conn.addDefinition(passConnectorDefinition);
		conn.addDefinition(portConnectorDefinition);
		
		Datasource ds = new Datasource();
		ds.setConnector(conn);
		ds.setName("2");
		
		Screen screen = new Screen();
		screen.setDescription("screen1");
		screen.setName("screen1");
		screen.setDefaultScreen(Boolean.TRUE);
		screen.addDatasource(ds);

		Application application = new Application();
		application.setDescription("App 1 de prueba");
		application.setName("app1");
		application.addScreen(screen);
		
		try {
			applicationService.createApplication(application);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		datasourceService.createDatasource(ds);
	}

	private void prueba() {
		User user = new User();
		user.setDescription("Usuario 1 para pruebas");
		user.setFullname("Ricardo Corazón de León");
		user.setPassword("");
		user.setUsername("rcorazon");
		
		ConnectorProperty serverConnectorProperty = new ConnectorProperty();
		serverConnectorProperty.setName("server");
		serverConnectorProperty.setDescription("description");
		
		ConnectorDefinition serverConnectorDefinition = new ConnectorDefinition();
		serverConnectorDefinition.setProperty(serverConnectorProperty);
		serverConnectorDefinition.setValue("10.36.19.106");
		
		ConnectorProperty sidConnectorProperty = new ConnectorProperty();
		sidConnectorProperty.setName("sid");
		sidConnectorProperty.setDescription("description");
		
		ConnectorDefinition sidConnectorDefinition = new ConnectorDefinition();
		sidConnectorDefinition.setProperty(sidConnectorProperty);
		sidConnectorDefinition.setValue("UPPDB");
		
		ConnectorProperty userConnectorProperty = new ConnectorProperty();
		userConnectorProperty.setName("user");
		userConnectorProperty.setDescription("description");
		
		ConnectorDefinition userConnectorDefinition = new ConnectorDefinition();
		userConnectorDefinition.setProperty(userConnectorProperty);
		userConnectorDefinition.setValue("patrulla");
		
		ConnectorProperty passConnectorProperty = new ConnectorProperty();
		passConnectorProperty.setName("pass");
		passConnectorProperty.setDescription("description");
		
		ConnectorDefinition passConnectorDefinition = new ConnectorDefinition();
		passConnectorDefinition.setProperty(passConnectorProperty);
		passConnectorDefinition.setValue("desarrollo");
		
		ConnectorProperty portConnectorProperty = new ConnectorProperty();
		portConnectorProperty.setName("port");
		portConnectorProperty.setDescription("description");
		
		ConnectorDefinition portConnectorDefinition = new ConnectorDefinition();
		portConnectorDefinition.setProperty(portConnectorProperty);
		portConnectorDefinition.setValue("1521");
		
		ConnectorProperty sqlConnectorProperty = new ConnectorProperty();
		sqlConnectorProperty.setName("sql");
		sqlConnectorProperty.setDescription("description");
		
		ConnectorDefinition sqlConnectorDefinition = new ConnectorDefinition();
		sqlConnectorDefinition.setProperty(sqlConnectorProperty);
		sqlConnectorDefinition.setValue("select nombre from dusuario");
		
		ConnectorType connectorType = new ConnectorType();
		connectorType.setName("Oracle Connector");
		connectorType.setClazz("com.gazoomobile.mfw.connector.db.oracle.OracleConnector");
		connectorType.setDescription("Oracle connector for testing");
		connectorType.addProperty(serverConnectorProperty);
		connectorType.addProperty(sidConnectorProperty);
		connectorType.addProperty(userConnectorProperty);
		connectorType.addProperty(passConnectorProperty);
		connectorType.addProperty(portConnectorProperty);
		
		Connector conn = new Connector();
		conn.setConnectorType(connectorType);
		conn.addDefinition(serverConnectorDefinition);
		conn.addDefinition(sidConnectorDefinition);
		conn.addDefinition(userConnectorDefinition);
		conn.addDefinition(passConnectorDefinition);
		conn.addDefinition(portConnectorDefinition);
		
		Datasource ds = new Datasource();
		ds.setConnector(conn);
		ds.setName("2");
		
		PropertyType type = new PropertyType();
		type.setType("2");
		
		ControlProperty property = new ControlProperty();
		property.setName("2");
		property.setPropertyType(type);
		
		ControlType controlType = new ControlType();
		controlType.setType("2");
		controlType.addProperty(property);

		ControlDefinition def = new ControlDefinition();
		def.setValue("2");
		def.setControlProperty(property);
		
		Control control = new Control();
		control.setControlName("2");
		control.setControlType(controlType);
		control.addControlDefinition(def);
		
		Screen screen = new Screen();
		screen.setDescription("screen1");
		screen.setName("screen1");
		screen.setDefaultScreen(Boolean.TRUE);
		screen.addDatasource(ds);
		screen.addControl(control);
		
		Application application = new Application();
		application.setDescription("App 1 de prueba");
		application.setName("app1");
		application.addUser(user);
		application.addScreen(screen);
		
		try {
			applicationService.createApplication(application);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ApplicationService getApplicationService() {
		return applicationService;
	}

	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ConnectorService getConnectorService() {
		return connectorService;
	}

	public void setConnectorService(ConnectorService connectorService) {
		this.connectorService = connectorService;
	}

	public ControlDefinitionService getControlDefinitionService() {
		return controlDefinitionService;
	}

	public void setControlDefinitionService(
			ControlDefinitionService controlDefinitionService) {
		this.controlDefinitionService = controlDefinitionService;
	}

	public ControlPropertyService getControlPropertyService() {
		return controlPropertyService;
	}

	public void setControlPropertyService(
			ControlPropertyService controlPropertyService) {
		this.controlPropertyService = controlPropertyService;
	}

	public ControlService getControlService() {
		return controlService;
	}

	public void setControlService(ControlService controlService) {
		this.controlService = controlService;
	}
	
	public DatasourceService getDatasourceService() {
		return datasourceService;
	}

	public void setDatasourceService(DatasourceService datasourceService) {
		this.datasourceService = datasourceService;
	}

	public PermissionsetService getPermissionsetService() {
		return permissionsetService;
	}

	public void setPermissionsetService(PermissionsetService permissionsetService) {
		this.permissionsetService = permissionsetService;
	}

	public ScreenService getScreenService() {
		return screenService;
	}

	public void setScreenService(ScreenService screenService) {
		this.screenService = screenService;
	}
}
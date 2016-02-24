package com.gazoomobile.mfw.platform.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.platform.domain.Datasource;
import com.gazoomobile.mfw.platform.domain.Screen;
import com.gazoomobile.mfw.platform.engine.util.builder.MXALMBuilderResolver;
import com.gazoomobile.mfw.platform.service.DatasourceService;
import com.gazoomobile.mfw.xmlbind.component.TComponent;
import com.gazoomobile.mfw.xmlbind.windows.Windows;

public class MXALMCreatorImpl
implements MXALMCreator
{
	private MXALMBuilderResolver builderResolver;
	private DatasourceService datasourceService;

	public String getApplicationsList(List<Application> applications)
	{
		StringBuilder builder = new StringBuilder("<apps>");
		if (applications != null) {
			for (Application app : applications)
				builder.append("<app id=\"").append(app.getIdApplication()).append("\" name=\"").append(app.getName()).append("\" />");
		}
		builder.append("</apps>");
		return builder.toString();
	}

	public String getXmlForScreen(Screen screen)
	{
		List<Datasource> dss = screen.getDatasources();
		Map<String, DataBaseConnectorResult> dbcResults = new HashMap<String, DataBaseConnectorResult>();

		for (Datasource datasource : dss) {
			Object o = this.datasourceService.executeDatasource(datasource);
			if ((o instanceof DataBaseConnectorResult)) {
				dbcResults.put(datasource.getName(), (DataBaseConnectorResult)o);
			}
			else {
				System.out.println("Found unknown datasource result: " + o.getClass().getName());
			}
		}
		Windows window = new Windows();
		window.setId(String.valueOf(screen.getIdScreen()));
		window.setTitle(screen.getName());

		List<Control> controls = screen.getControls();
		for (Control ctrl : controls) {
			if (ctrl.getParentControl() != null)
			{
				continue;
			}
			addToContainer(window, ctrl, dbcResults, controls);
		}

		return window.toString();
	}

	@SuppressWarnings("unchecked")
	private void addToContainer(Object container, Control ctrl, Map<String, DataBaseConnectorResult> dbcResults, List<Control> controls)
	{
		String type = ctrl.getControlType().getType();
		TComponent xmlObject = this.builderResolver.getBuilderForType(type).AddItemToContainer(container, ctrl, dbcResults, controls);

		List<Control> childrenControls = new ArrayList<Control>();
		for (Control child : controls) {
			if ((child.getParentControl() != null) && (child.getParentControl().getIdControl().equals(ctrl.getIdControl())))
				childrenControls.add(child);
		}
		Collections.sort(childrenControls, new Comparator()
		{
			public int compare(Object o1, Object o2) {
				Control c1 = (Control) o1;
				Control c2 = (Control) o2;

				return c1.getIndex() - c2.getIndex();
			}
		});
		for (Control child : childrenControls)
			addToContainer(xmlObject, child, dbcResults, controls);
	}

	public MXALMBuilderResolver getBuilderResolver()
	{
		return this.builderResolver;
	}

	public void setBuilderResolver(MXALMBuilderResolver builderResolver)
	{
		this.builderResolver = builderResolver;
	}

	public DatasourceService getDatasourceService() {
		return this.datasourceService;
	}

	public void setDatasourceService(DatasourceService datasourceService) {
		this.datasourceService = datasourceService;
	}
}
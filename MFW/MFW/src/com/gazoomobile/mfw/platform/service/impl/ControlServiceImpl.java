package com.gazoomobile.mfw.platform.service.impl;

import com.gazoomobile.mfw.platform.dao.ControlDao;
import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.platform.domain.ControlProperty;
import com.gazoomobile.mfw.platform.domain.ControlType;
import com.gazoomobile.mfw.platform.service.ControlService;
import java.util.List;

public class ControlServiceImpl implements ControlService
{
	private ControlDao controlDao;

	public Control createControl(Control control)
	{
		return (Control)this.controlDao.InsertOrUpdate(control);
	}

	public List<ControlProperty> getPropertiesByControlType(String controlType)
	{
		return this.controlDao.getControlProperties(controlType);
	}

	public List<ControlType> getAllControlTypes()
	{
		return this.controlDao.getAllControlTypes();
	}
	
	@Override
	public void removeOldOptions(long parentControlId) 
	{
		this.controlDao.removeOptionsByParentId(parentControlId);
	}

	public ControlDao getControlDao() {
		return this.controlDao;
	}

	public void setControlDao(ControlDao controlDao) {
		this.controlDao = controlDao;
	}
}
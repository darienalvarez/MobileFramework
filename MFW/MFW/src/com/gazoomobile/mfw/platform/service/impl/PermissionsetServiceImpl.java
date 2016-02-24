package com.gazoomobile.mfw.platform.service.impl;

import com.gazoomobile.mfw.platform.dao.PermissionsetDao;
import com.gazoomobile.mfw.platform.domain.Permissionset;
import com.gazoomobile.mfw.platform.service.PermissionsetService;

public class PermissionsetServiceImpl
  implements PermissionsetService
{
  private PermissionsetDao permissionsetDao;

  public Permissionset createPermissionset(Permissionset permissionset)
  {
    return (Permissionset)this.permissionsetDao.InsertOrUpdate(permissionset);
  }

  public PermissionsetDao getPermissionsetDao() {
    return this.permissionsetDao;
  }

  public void setPermissionsetDao(PermissionsetDao permissionsetDao) {
    this.permissionsetDao = permissionsetDao;
  }
}
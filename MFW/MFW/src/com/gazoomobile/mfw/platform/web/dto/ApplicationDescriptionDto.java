package com.gazoomobile.mfw.platform.web.dto;

import java.io.Serializable;

public class ApplicationDescriptionDto
  implements Serializable
{
  private static final long serialVersionUID = -7302555102986236562L;
  private long applicationId;
  private String applicationName;
  private String applicationDescription;

  public ApplicationDescriptionDto()
  {
  }

  public ApplicationDescriptionDto(long applicationId, String applicationName, String applicationDescription)
  {
    this.applicationId = applicationId;
    this.applicationName = applicationName;
    this.applicationDescription = applicationDescription;
  }

  public long getApplicationId() {
    return this.applicationId;
  }

  public void setApplicationId(long applicationId) {
    this.applicationId = applicationId;
  }

  public String getApplicationName() {
    return this.applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  public String getApplicationDescription() {
    return this.applicationDescription;
  }

  public void setApplicationDescription(String applicationDescription) {
    this.applicationDescription = applicationDescription;
  }
}
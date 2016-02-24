package com.gazoomobile.mfw.platform.engine.util.builder.impl;

import java.util.HashMap;
import java.util.Map;

import com.gazoomobile.mfw.platform.engine.util.builder.MXALMBuilder;
import com.gazoomobile.mfw.platform.engine.util.builder.MXALMBuilderResolver;

public class MXALMBuilderResolverImpl implements MXALMBuilderResolver
{
	Map<String, String> builders;
	Map<String, MXALMBuilder> cachedBuilders;

	public MXALMBuilderResolverImpl()
	{
		this.cachedBuilders = new HashMap<String, MXALMBuilder>();
	}

	public MXALMBuilder getBuilderForType(String type)
	{
		MXALMBuilder builder = (MXALMBuilder)this.cachedBuilders.get(type);
		if (builder != null) {
			return builder;
		}
		String clazz = (String)this.builders.get(type);
		try {
			builder = (MXALMBuilder)Class.forName(clazz).newInstance();
			return builder;
		} catch (Exception e) {
			System.out.println("Error getting MXALMBuilder for type: " + type);
			e.printStackTrace();
		}return null;
	}

	public Map<String, String> getBuilders()
	{
		return this.builders;
	}

	public void setBuilders(Map<String, String> builders) {
		this.builders = builders;
	}
}
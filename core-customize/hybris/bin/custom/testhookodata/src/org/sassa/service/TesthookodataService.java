/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.sassa.service;

public interface TesthookodataService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}

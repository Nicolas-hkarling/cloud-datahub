/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.sassa.setup;

import static org.sassa.constants.TesthookodataConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.sassa.constants.TesthookodataConstants;
import org.sassa.service.TesthookodataService;


@SystemSetup(extension = TesthookodataConstants.EXTENSIONNAME)
public class TesthookodataSystemSetup
{
	private final TesthookodataService testhookodataService;

	public TesthookodataSystemSetup(final TesthookodataService testhookodataService)
	{
		this.testhookodataService = testhookodataService;
	}

	@SystemSetup(process = SystemSetup.Process.ALL, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		testhookodataService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TesthookodataSystemSetup.class.getResourceAsStream("/testhookodata/sap-hybris-platform.png");
	}
}

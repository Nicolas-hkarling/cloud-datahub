/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.sassa.controller;

import static org.sassa.constants.TesthookodataConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.sassa.service.TesthookodataService;


@Controller
public class TesthookodataHelloController
{
	@Autowired
	private TesthookodataService testhookodataService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", testhookodataService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}

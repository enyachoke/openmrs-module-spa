/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * 
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.spa.servlet;

import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.openmrs.module.util.SingleSpaConstants.DEFAULT_SPA_BASE_URL;
import static org.openmrs.module.util.SingleSpaConstants.GP_KEY_SPA_BASE_URL;

public class SpaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/module/spa/master-single-page-application.form");

		req.setAttribute("openmrsBaseUrlContext", new String(req.getContextPath()));
		req.setAttribute("spaBaseUrlContext",
				Context.getAdministrationService().getGlobalProperty(GP_KEY_SPA_BASE_URL, DEFAULT_SPA_BASE_URL));

		dispatcher.forward(req, resp);
	}
}
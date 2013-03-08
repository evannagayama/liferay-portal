/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.permissions.blogs.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_AllowConfigurePortletPermissionsTest extends BaseTestCase {
	public void testSA_AllowConfigurePortletPermissions()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("link=Blogs Test Page",
					RuntimeVariables.replace("Blogs Test Page"));
				selenium.waitForPageToLoad("30000");
				Thread.sleep(1000);
				assertEquals(RuntimeVariables.replace("Options"),
					selenium.getText("//span[@title='Options']/ul/li/strong/a"));
				selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
					RuntimeVariables.replace("Options"));
				selenium.waitForVisible(
					"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(@id,'configuration')]");
				assertEquals(RuntimeVariables.replace("Configuration"),
					selenium.getText(
						"//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(@id,'configuration')]"));
				selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li/a[contains(@id,'configuration')]",
					RuntimeVariables.replace("Configuration"));
				selenium.waitForVisible(
					"//iframe[@id='_33_configurationIframeDialog']");
				selenium.selectFrame(
					"//iframe[@id='_33_configurationIframeDialog']");
				selenium.waitForElementPresent(
					"//script[contains(@src,'/liferay/navigation_interaction.js')]");
				selenium.waitForVisible("link=Permissions");
				selenium.clickAt("link=Permissions",
					RuntimeVariables.replace("Permissions"));
				selenium.waitForPageToLoad("30000");

				boolean portletConfigurationChecked = selenium.isChecked(
						"//input[@id='portlet_ACTION_CONFIGURATION']");

				if (portletConfigurationChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@id='portlet_ACTION_CONFIGURATION']",
					RuntimeVariables.replace("Portlet Configuration"));

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@id='portlet_ACTION_CONFIGURATION']"));
				Thread.sleep(1000);
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.waitForVisible(
					"//input[@id='portlet_ACTION_CONFIGURATION']");
				assertTrue(selenium.isChecked(
						"//input[@id='portlet_ACTION_CONFIGURATION']"));
				selenium.selectFrame("relative=top");

			case 100:
				label = -1;
			}
		}
	}
}
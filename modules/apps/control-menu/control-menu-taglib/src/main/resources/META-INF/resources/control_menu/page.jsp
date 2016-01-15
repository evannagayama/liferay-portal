<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
--%>

<%@ include file="/control_menu/init.jsp" %>

<%
List<ControlMenuCategory> controlMenuCategories = (List<ControlMenuCategory>)request.getAttribute("liferay-control-menu:control-menu:control-menu-categories");
ControlMenuEntryRegistry controlMenuEntryRegistry = (ControlMenuEntryRegistry)request.getAttribute("liferay-control-menu:control-menu:control-menu-entry-registry");
%>

<c:if test="<%= !controlMenuCategories.isEmpty() %>">
	<div class="control-menu" data-qa-id="controlMenu" id="<portlet:namespace/>ControlMenu">
		<ul class="control-menu-nav control-menu-level-1 control-menu-nav-level-1" data-namespace="<portlet:namespace />" data-qa-id="header" id="<portlet:namespace />controlMenu">

			<%
			for (int i = 0; i < controlMenuCategories.size(); i++) {
				ControlMenuCategory controlMenuCategory = controlMenuCategories.get(i);

				String cssClass = "site";

				if (i == (controlMenuCategories.size() - 2)) {
					cssClass = "tool";
				}
				else if (i == (controlMenuCategories.size() - 1)) {
					cssClass = "user";
				}
			%>

				<li class="control-menu-nav-item <%= cssClass %>-controls-group">
					<ul class="control-menu-nav">

						<%
						List<ControlMenuEntry> controlMenuEntries = controlMenuEntryRegistry.getControlMenuEntries(controlMenuCategory, request);

						for (ControlMenuEntry controlMenuEntry : controlMenuEntries) {
							if (controlMenuEntry.include(request, new PipingServletResponse(pageContext))) {
								continue;
							}
						%>

							<liferay-ui:icon
								data="<%= controlMenuEntry.getData(request) %>"
								icon="<%= controlMenuEntry.getIconCssClass(request) %>"
								label="<%= false %>"
								linkCssClass='<%= "control-menu-icon " + controlMenuEntry.getLinkCssClass(request) %>'
								markupView="lexicon"
								message="<%= controlMenuEntry.getLabel(locale) %>"
								url="<%= controlMenuEntry.getURL(request) %>"
							/>

						<%
						}
						%>

					</ul>
				</li>

			<%
			}
			%>

		</ul>
	</div>

	<aui:script use="liferay-control-menu">
		Liferay.ControlMenu.init('#<portlet:namespace />controlMenu');
	</aui:script>
</c:if>
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

<%@ include file="/init.jsp" %>

<%
PanelCategory panelCategory = (PanelCategory)request.getAttribute(ApplicationListWebKeys.PANEL_CATEGORY);

boolean showSiteSelector = ParamUtil.getBoolean(request, "showSiteSelector");
%>

<c:choose>
	<c:when test="<%= user.hasMySites() && showSiteSelector %>">
		<liferay-util:include page="/sites_list.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<portlet:renderURL var="selectSiteURL">
			<portlet:param name="showSiteSelector" value="<%= Boolean.TRUE.toString() %>" />
		</portlet:renderURL>

		<aui:a href="<%= selectSiteURL.toString() %>" cssClass="icon-arrow-left" label="<%= themeDisplay.getScopeGroupName() %>" />

		<application-list-ui:panel panelCategory="<%= panelCategory %>" />
	</c:otherwise>
</c:choose>
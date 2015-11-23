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
String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectUserGroupsRoles");

String displayStyle = ParamUtil.getString(request, "displayStyle", "list");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/user_groups_roles.jsp");
portletURL.setParameter("userGroupId", String.valueOf(siteMembershipsDisplayContext.getUserGroupId()));
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav-bar-search>
		<aui:form action="<%= portletURL.toString() %>" name="searchFm">
			<liferay-ui:input-search autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<liferay-frontend:management-bar
	checkBoxContainerId="userGroupGroupRoleRoleSearchContainer"
	includeCheckBox="<%= true %>"
>
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
		/>
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"list"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
			selectedDisplayStyle="<%= displayStyle %>"
		/>
	</liferay-frontend:management-bar-buttons>
</liferay-frontend:management-bar>

<aui:form cssClass="container-fluid-1280" name="fm">
	<liferay-ui:search-container
		id="userGroupGroupRoleRole"
		rowChecker="<%= new UserGroupGroupRoleRoleChecker(renderResponse, siteMembershipsDisplayContext.getUserGroup(), siteMembershipsDisplayContext.getGroup()) %>"
		searchContainer="<%= new RoleSearch(renderRequest, portletURL) %>"
	>
		<liferay-ui:search-container-results>

			<%
			RoleSearchTerms searchTerms = (RoleSearchTerms)searchContainer.getSearchTerms();

			List<Role> roles = RoleLocalServiceUtil.search(company.getCompanyId(), searchTerms.getKeywords(), new Integer[] {RoleConstants.TYPE_SITE}, QueryUtil.ALL_POS, QueryUtil.ALL_POS, searchContainer.getOrderByComparator());

			roles = UsersAdminUtil.filterGroupRoles(permissionChecker, siteMembershipsDisplayContext.getGroupId(), roles);

			total = roles.size();

			searchContainer.setTotal(total);

			results = ListUtil.subList(roles, searchContainer.getStart(), searchContainer.getEnd());

			searchContainer.setResults(results);
			%>

		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.liferay.portal.model.Role"
			cssClass="selected"
			keyProperty="roleId"
			modelVar="role"
		>
			<liferay-ui:search-container-column-text
				name="title"
			>
				<liferay-ui:icon
					iconCssClass="<%= RolesAdminUtil.getIconCssClass(role) %>"
					label="<%= true %>"
					message="<%= HtmlUtil.escape(role.getTitle(locale)) %>"
				/>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				name="type"
				value="<%= LanguageUtil.get(request, role.getTypeLabel()) %>"
			/>

			<liferay-ui:search-container-column-text
				name="description"
				value="<%= HtmlUtil.escape(role.getDescription(locale)) %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator displayStyle="<%= displayStyle %>" markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	$('input[name="<portlet:namespace />rowIds"]').on(
		'change',
		function(event) {
			<portlet:namespace />updateUserGroupGroupRole();
		}
	);

	function <portlet:namespace />updateUserGroupGroupRole() {
		var Util = Liferay.Util;

		var form = AUI.$(document.<portlet:namespace />fm);

		var values = {
			data: {
				addRoleIds: Util.listCheckedExcept(form, '<portlet:namespace />allRowIds'),
				removeRoleIds: Util.listUncheckedExcept(form, '<portlet:namespace />allRowIds'),
				userGroupId: <%= siteMembershipsDisplayContext.getUserGroupId() %>
			}
		};

		Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', values);
	}

	<portlet:namespace />updateUserGroupGroupRole();
</aui:script>
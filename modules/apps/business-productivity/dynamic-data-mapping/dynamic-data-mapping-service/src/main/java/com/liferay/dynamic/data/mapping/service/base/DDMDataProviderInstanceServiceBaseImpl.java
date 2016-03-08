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

package com.liferay.dynamic.data.mapping.service.base;

import com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance;
import com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceService;
import com.liferay.dynamic.data.mapping.service.persistence.DDMDataProviderInstanceFinder;
import com.liferay.dynamic.data.mapping.service.persistence.DDMDataProviderInstancePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.GroupPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the d d m data provider instance remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.dynamic.data.mapping.service.impl.DDMDataProviderInstanceServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.dynamic.data.mapping.service.impl.DDMDataProviderInstanceServiceImpl
 * @see com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceServiceUtil
 * @generated
 */
public abstract class DDMDataProviderInstanceServiceBaseImpl
	extends BaseServiceImpl implements DDMDataProviderInstanceService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceServiceUtil} to access the d d m data provider instance remote service.
	 */

	/**
	 * Returns the d d m data provider instance local service.
	 *
	 * @return the d d m data provider instance local service
	 */
	public com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceLocalService getDDMDataProviderInstanceLocalService() {
		return ddmDataProviderInstanceLocalService;
	}

	/**
	 * Sets the d d m data provider instance local service.
	 *
	 * @param ddmDataProviderInstanceLocalService the d d m data provider instance local service
	 */
	public void setDDMDataProviderInstanceLocalService(
		com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceLocalService ddmDataProviderInstanceLocalService) {
		this.ddmDataProviderInstanceLocalService = ddmDataProviderInstanceLocalService;
	}

	/**
	 * Returns the d d m data provider instance remote service.
	 *
	 * @return the d d m data provider instance remote service
	 */
	public DDMDataProviderInstanceService getDDMDataProviderInstanceService() {
		return ddmDataProviderInstanceService;
	}

	/**
	 * Sets the d d m data provider instance remote service.
	 *
	 * @param ddmDataProviderInstanceService the d d m data provider instance remote service
	 */
	public void setDDMDataProviderInstanceService(
		DDMDataProviderInstanceService ddmDataProviderInstanceService) {
		this.ddmDataProviderInstanceService = ddmDataProviderInstanceService;
	}

	/**
	 * Returns the d d m data provider instance persistence.
	 *
	 * @return the d d m data provider instance persistence
	 */
	public DDMDataProviderInstancePersistence getDDMDataProviderInstancePersistence() {
		return ddmDataProviderInstancePersistence;
	}

	/**
	 * Sets the d d m data provider instance persistence.
	 *
	 * @param ddmDataProviderInstancePersistence the d d m data provider instance persistence
	 */
	public void setDDMDataProviderInstancePersistence(
		DDMDataProviderInstancePersistence ddmDataProviderInstancePersistence) {
		this.ddmDataProviderInstancePersistence = ddmDataProviderInstancePersistence;
	}

	/**
	 * Returns the d d m data provider instance finder.
	 *
	 * @return the d d m data provider instance finder
	 */
	public DDMDataProviderInstanceFinder getDDMDataProviderInstanceFinder() {
		return ddmDataProviderInstanceFinder;
	}

	/**
	 * Sets the d d m data provider instance finder.
	 *
	 * @param ddmDataProviderInstanceFinder the d d m data provider instance finder
	 */
	public void setDDMDataProviderInstanceFinder(
		DDMDataProviderInstanceFinder ddmDataProviderInstanceFinder) {
		this.ddmDataProviderInstanceFinder = ddmDataProviderInstanceFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the group local service.
	 *
	 * @return the group local service
	 */
	public com.liferay.portal.kernel.service.GroupLocalService getGroupLocalService() {
		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(
		com.liferay.portal.kernel.service.GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	/**
	 * Returns the group remote service.
	 *
	 * @return the group remote service
	 */
	public com.liferay.portal.kernel.service.GroupService getGroupService() {
		return groupService;
	}

	/**
	 * Sets the group remote service.
	 *
	 * @param groupService the group remote service
	 */
	public void setGroupService(
		com.liferay.portal.kernel.service.GroupService groupService) {
		this.groupService = groupService;
	}

	/**
	 * Returns the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DDMDataProviderInstanceService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DDMDataProviderInstance.class;
	}

	protected String getModelClassName() {
		return DDMDataProviderInstance.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ddmDataProviderInstancePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceLocalService.class)
	protected com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceLocalService ddmDataProviderInstanceLocalService;
	@BeanReference(type = com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceService.class)
	protected DDMDataProviderInstanceService ddmDataProviderInstanceService;
	@BeanReference(type = DDMDataProviderInstancePersistence.class)
	protected DDMDataProviderInstancePersistence ddmDataProviderInstancePersistence;
	@BeanReference(type = DDMDataProviderInstanceFinder.class)
	protected DDMDataProviderInstanceFinder ddmDataProviderInstanceFinder;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.GroupLocalService.class)
	protected com.liferay.portal.kernel.service.GroupLocalService groupLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.GroupService.class)
	protected com.liferay.portal.kernel.service.GroupService groupService;
	@ServiceReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}
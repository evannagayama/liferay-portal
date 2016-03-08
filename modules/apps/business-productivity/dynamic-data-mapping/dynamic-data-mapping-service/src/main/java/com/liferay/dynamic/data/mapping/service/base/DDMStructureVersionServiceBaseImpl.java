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

import com.liferay.dynamic.data.mapping.model.DDMStructureVersion;
import com.liferay.dynamic.data.mapping.service.DDMStructureVersionService;
import com.liferay.dynamic.data.mapping.service.persistence.DDMStructureVersionPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the d d m structure version remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.dynamic.data.mapping.service.impl.DDMStructureVersionServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.dynamic.data.mapping.service.impl.DDMStructureVersionServiceImpl
 * @see com.liferay.dynamic.data.mapping.service.DDMStructureVersionServiceUtil
 * @generated
 */
public abstract class DDMStructureVersionServiceBaseImpl extends BaseServiceImpl
	implements DDMStructureVersionService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.dynamic.data.mapping.service.DDMStructureVersionServiceUtil} to access the d d m structure version remote service.
	 */

	/**
	 * Returns the d d m structure version local service.
	 *
	 * @return the d d m structure version local service
	 */
	public com.liferay.dynamic.data.mapping.service.DDMStructureVersionLocalService getDDMStructureVersionLocalService() {
		return ddmStructureVersionLocalService;
	}

	/**
	 * Sets the d d m structure version local service.
	 *
	 * @param ddmStructureVersionLocalService the d d m structure version local service
	 */
	public void setDDMStructureVersionLocalService(
		com.liferay.dynamic.data.mapping.service.DDMStructureVersionLocalService ddmStructureVersionLocalService) {
		this.ddmStructureVersionLocalService = ddmStructureVersionLocalService;
	}

	/**
	 * Returns the d d m structure version remote service.
	 *
	 * @return the d d m structure version remote service
	 */
	public DDMStructureVersionService getDDMStructureVersionService() {
		return ddmStructureVersionService;
	}

	/**
	 * Sets the d d m structure version remote service.
	 *
	 * @param ddmStructureVersionService the d d m structure version remote service
	 */
	public void setDDMStructureVersionService(
		DDMStructureVersionService ddmStructureVersionService) {
		this.ddmStructureVersionService = ddmStructureVersionService;
	}

	/**
	 * Returns the d d m structure version persistence.
	 *
	 * @return the d d m structure version persistence
	 */
	public DDMStructureVersionPersistence getDDMStructureVersionPersistence() {
		return ddmStructureVersionPersistence;
	}

	/**
	 * Sets the d d m structure version persistence.
	 *
	 * @param ddmStructureVersionPersistence the d d m structure version persistence
	 */
	public void setDDMStructureVersionPersistence(
		DDMStructureVersionPersistence ddmStructureVersionPersistence) {
		this.ddmStructureVersionPersistence = ddmStructureVersionPersistence;
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
		return DDMStructureVersionService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DDMStructureVersion.class;
	}

	protected String getModelClassName() {
		return DDMStructureVersion.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ddmStructureVersionPersistence.getDataSource();

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

	@BeanReference(type = com.liferay.dynamic.data.mapping.service.DDMStructureVersionLocalService.class)
	protected com.liferay.dynamic.data.mapping.service.DDMStructureVersionLocalService ddmStructureVersionLocalService;
	@BeanReference(type = com.liferay.dynamic.data.mapping.service.DDMStructureVersionService.class)
	protected DDMStructureVersionService ddmStructureVersionService;
	@BeanReference(type = DDMStructureVersionPersistence.class)
	protected DDMStructureVersionPersistence ddmStructureVersionPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
}
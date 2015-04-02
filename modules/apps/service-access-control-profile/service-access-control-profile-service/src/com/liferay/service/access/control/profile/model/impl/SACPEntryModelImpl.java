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

package com.liferay.service.access.control.profile.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.service.access.control.profile.model.SACPEntry;
import com.liferay.service.access.control.profile.model.SACPEntryModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the SACPEntry service. Represents a row in the &quot;SACPEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.service.access.control.profile.model.SACPEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SACPEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SACPEntryImpl
 * @see com.liferay.service.access.control.profile.model.SACPEntry
 * @see com.liferay.service.access.control.profile.model.SACPEntryModel
 * @generated
 */
@ProviderType
public class SACPEntryModelImpl extends BaseModelImpl<SACPEntry>
	implements SACPEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s a c p entry model instance should use the {@link com.liferay.service.access.control.profile.model.SACPEntry} interface instead.
	 */
	public static final String TABLE_NAME = "SACPEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "sacpEntryId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "allowedServices", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "title", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SACPEntry (uuid_ VARCHAR(75) null,sacpEntryId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,allowedServices STRING null,name VARCHAR(75) null,title STRING null)";
	public static final String TABLE_SQL_DROP = "drop table SACPEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY sacpEntry.sacpEntryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SACPEntry.sacpEntryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.service.access.control.profile.model.SACPEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.service.access.control.profile.model.SACPEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.service.access.control.profile.model.SACPEntry"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long NAME_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long SACPENTRYID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.service.access.control.profile.model.SACPEntry"));

	public SACPEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _sacpEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSacpEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sacpEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SACPEntry.class;
	}

	@Override
	public String getModelClassName() {
		return SACPEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sacpEntryId", getSacpEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("allowedServices", getAllowedServices());
		attributes.put("name", getName());
		attributes.put("title", getTitle());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sacpEntryId = (Long)attributes.get("sacpEntryId");

		if (sacpEntryId != null) {
			setSacpEntryId(sacpEntryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String allowedServices = (String)attributes.get("allowedServices");

		if (allowedServices != null) {
			setAllowedServices(allowedServices);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getSacpEntryId() {
		return _sacpEntryId;
	}

	@Override
	public void setSacpEntryId(long sacpEntryId) {
		_sacpEntryId = sacpEntryId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getAllowedServices() {
		if (_allowedServices == null) {
			return StringPool.BLANK;
		}
		else {
			return _allowedServices;
		}
	}

	@Override
	public void setAllowedServices(String allowedServices) {
		_allowedServices = allowedServices;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@JSON
	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
				"Title", LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SACPEntry.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SACPEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getTitle();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(SACPEntry.class.getName(),
				getPrimaryKey(), defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public SACPEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SACPEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SACPEntryImpl sacpEntryImpl = new SACPEntryImpl();

		sacpEntryImpl.setUuid(getUuid());
		sacpEntryImpl.setSacpEntryId(getSacpEntryId());
		sacpEntryImpl.setCompanyId(getCompanyId());
		sacpEntryImpl.setUserId(getUserId());
		sacpEntryImpl.setUserName(getUserName());
		sacpEntryImpl.setCreateDate(getCreateDate());
		sacpEntryImpl.setModifiedDate(getModifiedDate());
		sacpEntryImpl.setAllowedServices(getAllowedServices());
		sacpEntryImpl.setName(getName());
		sacpEntryImpl.setTitle(getTitle());

		sacpEntryImpl.resetOriginalValues();

		return sacpEntryImpl;
	}

	@Override
	public int compareTo(SACPEntry sacpEntry) {
		long primaryKey = sacpEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SACPEntry)) {
			return false;
		}

		SACPEntry sacpEntry = (SACPEntry)obj;

		long primaryKey = sacpEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		SACPEntryModelImpl sacpEntryModelImpl = this;

		sacpEntryModelImpl._originalUuid = sacpEntryModelImpl._uuid;

		sacpEntryModelImpl._originalCompanyId = sacpEntryModelImpl._companyId;

		sacpEntryModelImpl._setOriginalCompanyId = false;

		sacpEntryModelImpl._originalName = sacpEntryModelImpl._name;

		sacpEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SACPEntry> toCacheModel() {
		SACPEntryCacheModel sacpEntryCacheModel = new SACPEntryCacheModel();

		sacpEntryCacheModel.uuid = getUuid();

		String uuid = sacpEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			sacpEntryCacheModel.uuid = null;
		}

		sacpEntryCacheModel.sacpEntryId = getSacpEntryId();

		sacpEntryCacheModel.companyId = getCompanyId();

		sacpEntryCacheModel.userId = getUserId();

		sacpEntryCacheModel.userName = getUserName();

		String userName = sacpEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			sacpEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			sacpEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			sacpEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			sacpEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			sacpEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		sacpEntryCacheModel.allowedServices = getAllowedServices();

		String allowedServices = sacpEntryCacheModel.allowedServices;

		if ((allowedServices != null) && (allowedServices.length() == 0)) {
			sacpEntryCacheModel.allowedServices = null;
		}

		sacpEntryCacheModel.name = getName();

		String name = sacpEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			sacpEntryCacheModel.name = null;
		}

		sacpEntryCacheModel.title = getTitle();

		String title = sacpEntryCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			sacpEntryCacheModel.title = null;
		}

		return sacpEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", sacpEntryId=");
		sb.append(getSacpEntryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", allowedServices=");
		sb.append(getAllowedServices());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.service.access.control.profile.model.SACPEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sacpEntryId</column-name><column-value><![CDATA[");
		sb.append(getSacpEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allowedServices</column-name><column-value><![CDATA[");
		sb.append(getAllowedServices());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = SACPEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			SACPEntry.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _sacpEntryId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _allowedServices;
	private String _name;
	private String _originalName;
	private String _title;
	private String _titleCurrentLanguageId;
	private long _columnBitmask;
	private SACPEntry _escapedModel;
}
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

package com.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Ticket service. Represents a row in the &quot;Ticket&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.TicketModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.TicketImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ticket
 * @see com.liferay.portal.model.impl.TicketImpl
 * @see com.liferay.portal.model.impl.TicketModelImpl
 * @generated
 */
public interface TicketModel extends AttachedModel, BaseModel<Ticket> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ticket model instance should use the {@link Ticket} interface instead.
	 */

	/**
	 * Returns the primary key of this ticket.
	 *
	 * @return the primary key of this ticket
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ticket.
	 *
	 * @param primaryKey the primary key of this ticket
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ticket ID of this ticket.
	 *
	 * @return the ticket ID of this ticket
	 */
	public long getTicketId();

	/**
	 * Sets the ticket ID of this ticket.
	 *
	 * @param ticketId the ticket ID of this ticket
	 */
	public void setTicketId(long ticketId);

	/**
	 * Returns the company ID of this ticket.
	 *
	 * @return the company ID of this ticket
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this ticket.
	 *
	 * @param companyId the company ID of this ticket
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this ticket.
	 *
	 * @return the create date of this ticket
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this ticket.
	 *
	 * @param createDate the create date of this ticket
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the fully qualified class name of this ticket.
	 *
	 * @return the fully qualified class name of this ticket
	 */
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this ticket.
	 *
	 * @return the class name ID of this ticket
	 */
	public long getClassNameId();

	/**
	 * Sets the class name ID of this ticket.
	 *
	 * @param classNameId the class name ID of this ticket
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this ticket.
	 *
	 * @return the class p k of this ticket
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this ticket.
	 *
	 * @param classPK the class p k of this ticket
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the key of this ticket.
	 *
	 * @return the key of this ticket
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this ticket.
	 *
	 * @param key the key of this ticket
	 */
	public void setKey(String key);

	/**
	 * Returns the type of this ticket.
	 *
	 * @return the type of this ticket
	 */
	public int getType();

	/**
	 * Sets the type of this ticket.
	 *
	 * @param type the type of this ticket
	 */
	public void setType(int type);

	/**
	 * Returns the extra info of this ticket.
	 *
	 * @return the extra info of this ticket
	 */
	@AutoEscape
	public String getExtraInfo();

	/**
	 * Sets the extra info of this ticket.
	 *
	 * @param extraInfo the extra info of this ticket
	 */
	public void setExtraInfo(String extraInfo);

	/**
	 * Returns the expiration date of this ticket.
	 *
	 * @return the expiration date of this ticket
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this ticket.
	 *
	 * @param expirationDate the expiration date of this ticket
	 */
	public void setExpirationDate(Date expirationDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Ticket ticket);

	public int hashCode();

	public CacheModel<Ticket> toCacheModel();

	public Ticket toEscapedModel();

	public Ticket toUnescapedModel();

	public String toString();

	public String toXmlString();
}
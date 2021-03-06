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

package com.liferay.poshi.runner.pql;

import java.util.Properties;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author Michael Hashimoto
 */
public class PQLEntityFactoryTest extends TestCase {

	@Test
	public void testPQLValueGetValue() throws Exception {
		_validateQueryResult("false", Boolean.valueOf(false));
		_validateQueryResult("'false'", Boolean.valueOf(false));
		_validateQueryResult("\"false\"", Boolean.valueOf(false));
		_validateQueryResult("true", Boolean.valueOf(true));
		_validateQueryResult("'true'", Boolean.valueOf(true));
		_validateQueryResult("\"true\"", Boolean.valueOf(true));

		_validateQueryResult("3.2", Double.valueOf(3.2));
		_validateQueryResult("'3.2'", Double.valueOf(3.2));
		_validateQueryResult("\"3.2\"", Double.valueOf(3.2));
		_validateQueryResult("2016.0", Double.valueOf(2016));
		_validateQueryResult("'2016.0'", Double.valueOf(2016));
		_validateQueryResult("\"2016.0\"", Double.valueOf(2016));

		_validateQueryResult("2016", Integer.valueOf(2016));
		_validateQueryResult("'2016'", Integer.valueOf(2016));
		_validateQueryResult("\"2016\"", Integer.valueOf(2016));

		_validateQueryResult("test", "test");
		_validateQueryResult("'test'", "test");
		_validateQueryResult("\"test\"", "test");

		_validateQueryResult("'test test'", "test test");
		_validateQueryResult("\"test test\"", "test test");
	}

	@Test
	public void testPQLVariableGetValue() throws Exception {
		_validateVariableResult("false", Boolean.valueOf(false));
		_validateVariableResult("'false'", Boolean.valueOf(false));
		_validateVariableResult("\"false\"", Boolean.valueOf(false));
		_validateVariableResult("true", Boolean.valueOf(true));
		_validateVariableResult("'true'", Boolean.valueOf(true));
		_validateVariableResult("\"true\"", Boolean.valueOf(true));

		_validateVariableResult("3.2", Double.valueOf(3.2));
		_validateVariableResult("'3.2'", Double.valueOf(3.2));
		_validateVariableResult("\"3.2\"", Double.valueOf(3.2));
		_validateVariableResult("2016.0", Double.valueOf(2016));
		_validateVariableResult("'2016.0'", Double.valueOf(2016));
		_validateVariableResult("\"2016.0\"", Double.valueOf(2016));

		_validateVariableResult("2016", Integer.valueOf(2016));
		_validateVariableResult("'2016'", Integer.valueOf(2016));
		_validateVariableResult("\"2016\"", Integer.valueOf(2016));

		_validateVariableResult("test", "test");
		_validateVariableResult("'test'", "test");
		_validateVariableResult("\"test\"", "test");

		_validateVariableResult("'test test'", "test test");
		_validateVariableResult("\"test test\"", "test test");
	}

	private static void _validateQueryResult(
			String query, Object expectedResult)
		throws Exception {

		_validateQueryResult(query, expectedResult, new Properties());
	}

	private static void _validateQueryResult(
			String query, Object expectedResult, Properties properties)
		throws Exception {

		PQLEntity pqlEntity = PQLEntityFactory.newPQLEntity(query);

		Object actualResult = pqlEntity.getValue(properties);

		if (!actualResult.equals(expectedResult)) {
			StringBuilder sb = new StringBuilder();

			sb.append("Mismatched result within the following query:\n");
			sb.append(query);
			sb.append("\n* Actual:   ");
			sb.append(actualResult);
			sb.append("\n* Expected: ");
			sb.append(expectedResult);

			throw new Exception(sb.toString());
		}
	}

	private static void _validateVariableResult(
			String query, Object expectedResult)
		throws Exception {

		Properties properties = new Properties();

		properties.put("portal.smoke", query);

		_validateQueryResult("portal.smoke", expectedResult, properties);
	}

}
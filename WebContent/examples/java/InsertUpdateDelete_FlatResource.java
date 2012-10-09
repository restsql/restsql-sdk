/* Copyright (c) restSQL Project Contributors. Licensed under MIT. */

import java.util.ArrayList;
import java.util.List;

import org.restsql.core.Config;
import org.restsql.core.Factory;
import org.restsql.core.NameValuePair;
import org.restsql.core.Request;
import org.restsql.core.RequestLogger;
import org.restsql.core.SqlResource;
import org.restsql.core.SqlResourceException;
import org.restsql.core.NameValuePair.Operator;

/**
 * Contains insert and delete examples using the Java API using Country, a flat SQL Resource.
 * 
 * @author Mark Sawers
 */
public class InsertUpdateDelete_FlatResource {

	/** The main show. */
	public static void main(final String[] args) throws SqlResourceException {
		// Set the restsql properties location
		System.setProperty(Config.KEY_RESTSQL_PROPERTIES, InsertUpdateDelete_FlatResource.class.getResource(
				"example-restsql.properties").getPath());

		// Do a delete of test fixtures for safety
		doDeleteMultiple();

		// Do some updates
		doUpdateWithPk();
		doUpdateWithParam();

		// Do some deletes
		doDeleteWithPk();
		doDeleteWithWildcard();
	}

	// Worker methods

	/** Deletes record with names like Test% from the Country resource. */
	private static void doDeleteMultiple() throws SqlResourceException {
		System.out.println("Delete Multiple");

		// Get the resource object
		final SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the delete request
		final List<NameValuePair> resIds = null;
		final List<NameValuePair> params = new ArrayList<NameValuePair>(1);
		params.add(new NameValuePair("country", "Test%"));
		final List<List<NameValuePair>> childrenParams = null;
		final RequestLogger requestLogger = Factory.getRequestLogger();
		final Request request = Factory.getRequest(Request.Type.DELETE, sqlResource.getName(), resIds,
				params, childrenParams, requestLogger);

		// Execute the delete request
		final int rowsAffected = sqlResource.write(request);

		System.out.println("\t" + requestLogger.getSql());
		System.out.println("\tdeleted " + rowsAffected + " row(s)\n");
	}

	/** Deletes record with id 1000 from the Country resource. */
	private static void doDeleteWithPk() throws SqlResourceException {
		System.out.println("Delete with PK");

		// Get the resource object
		final SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the delete request
		final List<NameValuePair> resIds = new ArrayList<NameValuePair>(1);
		
		final List<NameValuePair> params = null;
		resIds.add(new NameValuePair("country_id", "1000", Operator.Equals));
		final List<List<NameValuePair>> childrenParams = null;
		final RequestLogger requestLogger = Factory.getRequestLogger();
		final Request request = Factory.getRequest(Request.Type.DELETE, sqlResource.getName(), resIds,
				params, childrenParams, requestLogger);

		// Execute the delete request
		final int rowsAffected = sqlResource.write(request);

		System.out.println("\t" + requestLogger.getSql());
		System.out.println("\tdeleted " + rowsAffected + " row(s)\n");
	}

	/** Deletes records with country name like W% from the Country resource. */
	private static void doDeleteWithWildcard() throws SqlResourceException {
		System.out.println("Delete with wildcard");

		// Get the resource object
		final SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the record
		final List<NameValuePair> params = new ArrayList<NameValuePair>(3);
		params.add(new NameValuePair("country_id", "1000"));
		params.add(new NameValuePair("country", "Test1"));
		doInsert(params);
		params.clear();
		params.add(new NameValuePair("country_id", "1001"));
		params.add(new NameValuePair("country", "Test2"));
		doInsert(params);

		// Create the delete request
		final List<NameValuePair> resIds = null;
		params.clear();
		params.add(new NameValuePair("country", "Test%"));
		final List<List<NameValuePair>> childrenParams = null;
		final RequestLogger requestLogger = Factory.getRequestLogger();
		final Request request = Factory.getRequest(Request.Type.DELETE, sqlResource.getName(), resIds,
				params, childrenParams, requestLogger);

		// Execute the delete request
		final int rowsAffected = sqlResource.write(request);

		System.out.println("\t" + requestLogger.getSql());
		System.out.println("\tdeleted " + rowsAffected + " row(s)\n");
	}

	/** Creates record in the Country resource. */
	private static void doInsert(final List<NameValuePair> params) throws SqlResourceException {
		// Get the resource object
		final SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the request
		final List<NameValuePair> resIds = null;
		final List<List<NameValuePair>> childrenParams = null;
		final RequestLogger requestLogger = Factory.getRequestLogger();
		final Request request = Factory.getRequest(Request.Type.INSERT, sqlResource.getName(), resIds,
				params, childrenParams, requestLogger);

		// Execute the insert request
		final int rowsAffected = sqlResource.write(request);

		System.out.println("\t" + requestLogger.getSql());
		System.out.println("\tinserted " + rowsAffected + " row(s)");
	}

	/** Updates record with country name Wohoo! in the Country resource. */
	private static void doUpdateWithParam() throws SqlResourceException {
		System.out.println("Update with Param");

		// Get the resource object
		final SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the record
		final List<NameValuePair> params = new ArrayList<NameValuePair>(3);

		// Create the delete request
		final List<NameValuePair> resIds = new ArrayList<NameValuePair>(1);
		resIds.add(new NameValuePair("country", "Test2"));
		params.add(new NameValuePair("country", "Test1"));
		params.add(new NameValuePair("last_update", "2012-02-18 10:00:10"));
		final List<List<NameValuePair>> childrenParams = null;
		final RequestLogger requestLogger = Factory.getRequestLogger();
		final Request request = Factory.getRequest(Request.Type.UPDATE, sqlResource.getName(), resIds,
				params, childrenParams, requestLogger);

		// Execute the update request
		final int rowsAffected = sqlResource.write(request);

		System.out.println("\t" + requestLogger.getSql());
		System.out.println("\tupdated " + rowsAffected + " row(s)\n");
	}

	// Helper methods

	/** Updates record with id 1000 from the Country resource. */
	private static void doUpdateWithPk() throws SqlResourceException {
		System.out.println("Update with PK");

		// Get the resource object
		final SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the record
		final List<NameValuePair> params = new ArrayList<NameValuePair>(3);
		params.add(new NameValuePair("country_id", "1000"));
		params.add(new NameValuePair("country", "Test1"));
		params.add(new NameValuePair("last_update", "2012-02-15 04:44:00.0"));
		doInsert(params);

		// Create the delete request
		final List<NameValuePair> resIds = new ArrayList<NameValuePair>(1);
		resIds.add(new NameValuePair("country_id", "1000"));
		params.clear();
		params.add(new NameValuePair("country", "Test2"));
		params.add(new NameValuePair("last_update", "2012-02-18 10:00:10"));
		final List<List<NameValuePair>> childrenParams = null;
		final RequestLogger requestLogger = Factory.getRequestLogger();
		final Request request = Factory.getRequest(Request.Type.UPDATE, sqlResource.getName(), resIds,
				params, childrenParams, requestLogger);

		// Execute the update request
		final int rowsAffected = sqlResource.write(request);

		System.out.println("\t" + requestLogger.getSql());
		System.out.println("\tupdated " + rowsAffected + " row(s)\n");
	}

}

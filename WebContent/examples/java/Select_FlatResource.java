/* Copyright (c) restSQL Project Contributors. Licensed under MIT. */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restsql.core.Config;
import org.restsql.core.Factory;
import org.restsql.core.HttpRequestAttributes;
import org.restsql.core.NameValuePair;
import org.restsql.core.Request;
import org.restsql.core.RequestLogger;
import org.restsql.core.SqlResource;
import org.restsql.core.SqlResourceException;

/**
 * Contains read examples using the Java API using Country, a flat SQL Resource.
 * 
 * @author Mark Sawers
 */
public class Select_FlatResource {

	/** The main show. */
	public static void main(String[] args) throws SqlResourceException {
		// Set the restsql properties location
		System.setProperty(Config.KEY_RESTSQL_PROPERTIES, Select_FlatResource.class
				.getResource("example-restsql.properties").getPath());

		// Do some selects
		doSelectWithPk();
		doSelectWithWildcard();
		doSelectWithLimit();
		doSelectWithNonPkAndLimitReturnXml();
	}

	// Worker methods
	
	/** Requests record with id 1000 from the Country resource. */
	private static void doSelectWithPk() throws SqlResourceException {
		// Get the resource object
		SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the request
		List<NameValuePair> resIds = new ArrayList<NameValuePair>(1);
		resIds.add(new NameValuePair("country_id", "1"));
		List<NameValuePair> params = null;
		List<List<NameValuePair>> childrenParams = null;
		RequestLogger requestLogger = Factory.getRequestLogger();
		Request request = Factory.getRequest(Request.Type.SELECT, sqlResource.getName(), resIds, params,
				childrenParams, requestLogger);

		// Execute the request
		final List<Map<String, Object>> results = sqlResource.read(request);

		printResults("Select using PK", results, requestLogger);
	}

	/** Requests records with country name like A% from the Country resource. */
	private static void doSelectWithWildcard() throws SqlResourceException {
		// Get the resource object
		SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the request
		List<NameValuePair> resIds = null;
		List<NameValuePair> params = new ArrayList<NameValuePair>(1);
		params.add(new NameValuePair("country", "A%"));
		List<List<NameValuePair>> childrenParams = null;
		RequestLogger requestLogger = Factory.getRequestLogger();
		Request request = Factory.getRequest(Request.Type.SELECT, sqlResource.getName(), resIds, params,
				childrenParams, requestLogger);

		// Execute the request
		final List<Map<String, Object>> results = sqlResource.read(request);

		printResults("Select with Wildcard", results, requestLogger);
	}

	/** Requests second page of records. */
	private static void doSelectWithLimit() throws SqlResourceException {
		// Get the resource object
		SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the request
		List<NameValuePair> resIds = null;
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new NameValuePair(Request.PARAM_NAME_LIMIT, "10"));
		params.add(new NameValuePair(Request.PARAM_NAME_OFFSET, "10"));
		List<List<NameValuePair>> childrenParams = null;
		RequestLogger requestLogger = Factory.getRequestLogger();
		Request request = Factory.getRequest(Request.Type.SELECT, sqlResource.getName(), resIds, params,
				childrenParams, requestLogger);

		// Execute the request
		final List<Map<String, Object>> results = sqlResource.read(request);

		printResults("Select with Limit", results, requestLogger);
	}
	
	/** Requests records with country name like A% from the Country resource with a limit and returns XML. */
	private static void doSelectWithNonPkAndLimitReturnXml() throws SqlResourceException {
		// Get the resource object
		SqlResource sqlResource = Factory.getSqlResource("Country");

		// Create the request
		List<NameValuePair> resIds = null;
		List<NameValuePair> params = new ArrayList<NameValuePair>(0);
		params.add(new NameValuePair("last_update", "2006-02-15 04:44:00"));
		params.add(new NameValuePair(Request.PARAM_NAME_LIMIT, "5"));
		params.add(new NameValuePair(Request.PARAM_NAME_OFFSET, "0"));
		List<List<NameValuePair>> childrenParams = null;
		RequestLogger requestLogger = Factory.getRequestLogger();
		Request request = Factory.getRequest(Request.Type.SELECT, sqlResource.getName(), resIds, params,
				childrenParams, requestLogger);
		
		// Execute the request
		final String results = sqlResource.read(request, HttpRequestAttributes.DEFAULT_MEDIA_TYPE);

		System.out.println("Select return XML");
		System.out.println(results);
		System.out.println("\nNote: By default XML directive and schema are not returned in responses. Restsql properties response.useXmlSchema and response.useXmlDirective controls this behavior.");
	}

	
	// Helper methods
	
	/** Prints the collection-based results. **/
	private static void printResults(String requestName, final List<Map<String, Object>> results,
			RequestLogger requestLogger) {
		System.out.println(requestName);
		System.out.println(requestLogger.getSql());
		if (results.size() > 0) {
			System.out.println(results.size() + " Results:");
			for (Map<String, Object> record : results) {
				String resultString = "country_id: " + record.get("country_id") + ", country: "
						+ record.get("country") + ", last_update: " + record.get("last_update");
				System.out.println("\t" + resultString);
			}
		} else {
			System.out.println(requestName + " returned zero rows...something is amiss!");
		}
		System.out.println();
	}
}

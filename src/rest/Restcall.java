package rest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/*
 * A Java Class to send API calls
 */
public class Restcall {

	public Restcall() {
	}
	
	// Query the API
	public void search() throws ParserConfigurationException, SAXException, IOException {
		Client client = ClientBuilder.newClient();
		
		String api = buildQuery("artist", "Alicia Keys", null, null);
		System.out.println(api);
		
		WebTarget resource = client.target(api);

		Builder request = resource.request();
		request.accept(MediaType.APPLICATION_JSON);
		request.accept(MediaType.APPLICATION_XML);

		Response response = request.get();

		if (response.getStatusInfo().getFamily() == Family.SUCCESSFUL) {
		    System.out.println("Success! " + response.getStatus());
		    System.out.println(response.getEntity());
		    String input = response.readEntity(String.class);

		    
//		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		    DocumentBuilder builder = factory.newDocumentBuilder();
//		    Document document =  builder.parse(new org.xml.sax.InputSource(new StringReader(input)));
		    
		    
		    input = input.replace("><", ">\n<");
		    PrintWriter out = new PrintWriter("musicbrainz.xml");
		    out.println(input);
		    out.close();
		    
		} else {
		    System.out.println("ERROR! " + response.getStatus());    
		    System.out.println(response.getEntity());

		}
	}

	// Build the query string which will be sent to the API
	public String buildQuery(String type, String query, String limit, String offset) {
		// Test if there's a null value
		type 	= type 		!= null? type	:"recording";
		query 	= query 	!= null? query	:"Sia";
		limit 	= limit 	!= null? limit	:"25";
		offset 	= offset 	!= null? offset	:"0";
		
		// Delete whitespaces
		query = query.replace(" ", "%20");
		
		// Musicbrainz API
		String api = "http://musicbrainz.org/ws/2/";
		
		// Concats type
		api += type;
		api += "?query=" + query;
		api += "&limit=" + limit;
		api += "&offset=" + offset;
		
		return api;
	}
	
	// Test
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Restcall restcall = new Restcall();
		restcall.search();
	}

}

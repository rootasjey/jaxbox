package rest;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dao.Transit;
import xml.Sax;

/*
 * A Java Class to send API calls
 */
public class Restcall {
	private Lastfm lastfm = null;
	private Musicbrainz musicbrainz = null;
	
	// Initialize API Objects
	public Restcall() {
		this.lastfm = new Lastfm();
		this.musicbrainz = new Musicbrainz();
	}
	
	// Send a query to musicbrainz
	public String queryMusicbrainz(String type, String query, String limit, String offset) {
		String api = this.musicbrainz.search(type, query, limit, offset);
		return api;
	}
	
	// Send a query to lastfm
	public String queryLastfm(String type, String query, String limit, String offset) {
		String api = this.lastfm.search(type, query, limit, offset);
		return api;
	}
	
	// Build the query string which will be sent to the API
	public String buildQuery(String source, String type, String query, String limit, String offset) {
		if (source.equals("musicbrainz")) {
			return queryMusicbrainz(type, query, limit, offset);
		} else if (source.equals("lastfm")) {
			return queryLastfm(type, query, limit, offset);
		}
		return null;
	}
	
	// Query the API
	public void search(String source, String type, String name) throws ParserConfigurationException, SAXException, IOException {
		Client client = ClientBuilder.newClient();
		
//		String source = "musicbrainz";
//		String source = "lastfm";
		String api = buildQuery(source, type, name, "25", null);
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
		    
		    // Save the file to the disk
		    Inout.postprocess(input, source);
		    
		} else {
		    System.out.println("ERROR! " + response.getStatus());
		}
	}

	
	// Test
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Restcall restcall = new Restcall();
		restcall.search("lastfm", "album", "Alicia Keys");
		restcall.search("musicbrainz", "album", "Alicia Keys");
		System.out.println("---------------------");
		System.out.println("RESTCALL FINISHED");
		
		Transit.persistAlbums(Sax.albumsList);
	}

}

package rest;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;


public class Musicbrainz {
	public String api = "http://musicbrainz.org/ws/2/";
	private String limit = null;
	private String page = null;
	
	public HashMap<String, String> searchFunctions = new HashMap<String, String>();
	
	public Musicbrainz() {
		this.fillSearchFunctions();
	}
	
	public void fillSearchFunctions() {
		String file = "src/rest/musicbrainz.json";
		String input = Inout.readfile(file);
		
		
		JSONObject json = new JSONObject(input);
		JSONArray arraySearch = json.getJSONArray("search");
		
		for (int i = 0; i < arraySearch.length(); i++) {
			
			JSONObject searchItem = arraySearch.getJSONObject(i);
			
			String type = searchItem.getString("name");
			String path = searchItem.getString("path");
			searchFunctions.put(type, path);
		}
		
	}
	
	public String search(String type, String query, String limit, String offset) {
		this.limit 	= limit != null? "&limit=" 	+ limit	: "&limit=25";
		this.page 	= page 	!= null? "&offset=" + page	: "&offset=1";
		
		String url = api;
		String media = this.searchFunctions.get(type);
		
		// Check if the media wanted exists (if there's a mistake in the keyword)
		if (media == null) {
			System.out.println("Cannot search for [" + type + "] (This keyword doesn't exist).");
			return null;
		}
		
		// Delete whitespaces
		query = query.replace(" ", "%20");
		
		// Concats 
		url += media;
		url += "?query=" + query;
		url += this.limit;
		url += this.page;
		
		return url;
	}

	
	public String get() {
		return null;
	}
}

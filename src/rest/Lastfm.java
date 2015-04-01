package rest;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class Lastfm {
	public String api = "http://ws.audioscrobbler.com/2.0/";
	private String limit = null;
	private String page = null;
	private static String laftfmKey = "f5e757d925c049fed3dd25493e3df7b6";
	
	public HashMap<String, String> album = new HashMap<String, String>();
	public HashMap<String, String> artist = new HashMap<String, String>();
	public HashMap<String, String> chart = new HashMap<String, String>();
	public HashMap<String, String> event = new HashMap<String, String>();
	public HashMap<String, String> geo = new HashMap<String, String>();
	public HashMap<String, String> group = new HashMap<String, String>();
	public HashMap<String, String> tag = new HashMap<String, String>();
	public HashMap<String, String> track = new HashMap<String, String>();
	public HashMap<String, String> user = new HashMap<String, String>();
	public HashMap<String, String> venue = new HashMap<String, String>();
	
	public HashMap<String, String> searchFunctions = new HashMap<String, String>();
	public HashMap<String, String> getFunctions = new HashMap<String, String>();
	
	public Lastfm() {
		this.fillSearchFunctions();
	}
	
	public void fillSearchFunctions() {
		String file = "src/rest/lastfm.json";
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
	
	
	public String search(String type, String query, String limit, String page) {
		this.limit 	= limit != null? "&limit=" 	+ limit	: "&limit=25";
		this.page 	= page 	!= null? "&page=" 	+ page	: "&page=1";
		
		String url = api;
		String media = this.searchFunctions.get(type);
		
		// Delete whitespaces
		query = query.replace(" ", "%20");
		
		url += media + query + searchSuffix();
		return url;
	}
	
	
	
	public String searchSuffix() {
		String suffix = "";
		
		suffix += this.limit;
		suffix += this.page;
		suffix += "&api_key=" + laftfmKey;
		return suffix;
	}
	
	public String get(String type, String query) {
		return null;
	}

}

package process;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import rest.Restcall;
import xml.Sax;
import dao.Transit;
import bean.Album;
import bean.Artiste;
import bean.Track;

public class Processing {
	private static int attemps = 0;
	
	public Processing() {
	}
	
	public static ArrayList<Album> searchAlbumByAuthor(String author) 
			throws ParserConfigurationException, SAXException, IOException {
		
		System.out.println("Search albums for " + author);
		
		ArrayList<Album> albums = (ArrayList<Album>) Transit.getAlbumsByAuthor(author);
		
		if (albums.size() == 0) {
			// Call APIs
			// if there's no result
			System.out.println("album not found");
			System.out.println("calling APIs");
			
			Restcall restcall = new Restcall();
			restcall.search("lastfm", "album", author);
			restcall.search("musicbrainz", "album", author);
			System.out.println("---------------------");
			System.out.println("RESTCALL FINISHED");
			
			Transit.persistAlbums(Sax.albumList);
			
			if (attemps > 2) return null;
			attemps++;
			
			albums = (ArrayList<Album>) Transit.getAlbumsByAuthor(author);
			
			
			return albums;
			
		} else {
			// Return database results			
			return albums;
		}
	}
	
	
	public static ArrayList<Artiste> searchArtist(String artist) 
			throws ParserConfigurationException, SAXException, IOException {
		
		System.out.println("Search artist for " + artist);
		
		ArrayList<Artiste> artists = (ArrayList<Artiste>) Transit.getArtists(artist);
		
		if (artists.size() == 0) {
			// Call APIs
			// if there's no result
			System.out.println("artist not found");
			System.out.println("calling APIs");
			
			Restcall restcall = new Restcall();
			restcall.search("lastfm", "artist", artist);
			restcall.search("musicbrainz", "artist", artist);
			System.out.println("---------------------");
			System.out.println("RESTCALL FINISHED");
			
			Transit.persistArtists(Sax.artistList);
			
			if (attemps > 2) return null;
			attemps++;
			
			return searchArtist(artist);
			
		} else {
			// Return database results
			return artists;
		}
	}
	
	
	public static ArrayList<Track> searchTracks(String track) 
			throws ParserConfigurationException, SAXException, IOException {
		
		System.out.println("Search track for " + track);
		
		ArrayList<Track> tracks = (ArrayList<Track>) Transit.getTracks(track);
		
		if (tracks.size() == 0) {
			// Call APIs
			// if there's no result
			System.out.println("track not found");
			System.out.println("calling APIs");
			
			Restcall restcall = new Restcall();
			restcall.search("lastfm", "track", track);
			restcall.search("musicbrainz", "track", track);
			System.out.println("---------------------");
			System.out.println("RESTCALL FINISHED");
			
			Transit.persistTracks(Sax.trackList);
			
			if (attemps > 2) return null;
			attemps++;
			
			return searchTracks(track);
			
		} else {
			// Return database results			
			return tracks;
		}
	}
	
	public static void searchTrackByAuthor(String author) {
		
	}
	
	public static void getTrackInfos(String track) {
			
	}
	
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		attemps = 0;
//		searchAlbumByAuthor("Alicia Keys");
//		searchArtist("Alicia Keys");
//		searchTracks("Lost One");
	}
}

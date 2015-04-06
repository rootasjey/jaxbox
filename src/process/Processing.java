package process;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import rest.Restcall;
import xml.Sax;
import dao.Transit;
import bean.Album;

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
			
			Transit.persistAlbums(Sax.albumsList);
			
			if (attemps > 2) return null;
			attemps++;
			
			return searchAlbumByAuthor(author);
		} else {
			// Return database results
			System.out.println("albums full");
			
//			for (Album album : albums) {
//				System.out.println(album);
//			}
			
			return albums;
		}
	}
	
	public static void searchSongsByAuthor() {
		
	}
	
	public static void getSongInfos() {
			
	}
	
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		attemps = 0;
		searchAlbumByAuthor("Alicia Keys");
	}
}

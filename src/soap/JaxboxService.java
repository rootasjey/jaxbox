package soap;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import process.Processing;
import bean.Album;
import bean.Artiste;
import bean.Track;

//Service Implementation
	@WebService(endpointInterface = "soap.JaxboxServiceInterface")
public class JaxboxService implements JaxboxServiceInterface {
	
	public JaxboxService() {
	}

	@Override
	public String getHelloWorld(String name) {
		return "Hello World JAX-WS" + name;
	}

	@Override
	public Album[] searchAlbumArtist(String artist) 
			throws ParserConfigurationException, SAXException, IOException {

		ArrayList<Album> albums = Processing.searchAlbumByAuthor(artist);		
		return albums.toArray(new Album[albums.size()]);
	}
	
	
	@Override
	public Artiste[] searchArtists(String artist)
			throws ParserConfigurationException, SAXException, IOException {
		
		ArrayList<Artiste> artists = Processing.searchArtist(artist);
		return artists.toArray(new Artiste[artists.size()]);
	}
	
	@Override
	public Track[] searchTracks(String track)
			throws ParserConfigurationException, SAXException, IOException {
		
		ArrayList<Track> tracks = Processing.searchTracks(track);
		return tracks.toArray(new Track[tracks.size()]);
	}

	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		
	}


}

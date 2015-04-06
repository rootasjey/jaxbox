package soap;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import process.Processing;
import bean.Album;

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
		System.out.println("my size: " + albums.size());
		
		return albums.toArray(new Album[albums.size()]);
	}
	
	
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		
	}

	
}

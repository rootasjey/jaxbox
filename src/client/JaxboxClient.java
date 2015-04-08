package client;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Service;

import org.xml.sax.SAXException;

import bean.Album;
import bean.Artiste;
import bean.Track;
import soap.JaxboxServiceInterface;

public class JaxboxClient {

	public JaxboxClient() {
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		URL url = new URL("http://localhost:9999/ws/jaxbox?wsdl");
		QName qname = new QName("http://soap/", "JaxboxServiceService");
		
		Service service = Service.create(url, qname);
		JaxboxServiceInterface jaxbox = service.getPort(JaxboxServiceInterface.class);
		
		System.out.println(jaxbox.getHelloWorld(" jeemys"));
				
//		List<Album> albums = Arrays.asList(jaxbox.searchAlbumArtist("Ariana Grande"));
//		
//		System.out.println("[client] size: " + albums.size());
//		for (Album album : albums) {
//			System.out.println(album);
//		}
		
//		List<Artiste> artists = Arrays.asList(jaxbox.searchArtists("Ariana Grande"));
//		
//		System.out.println("[client] size: " + artists.size());
//		for (Artiste artiste : artists) {
//			System.out.println(artiste);
//		}
		
//		List<Track> tracks = Arrays.asList(jaxbox.searchTracks("September"));
//		
//		System.out.println("[client] size: " + tracks.size());
//		for (Track track : tracks) {
//			System.out.println(track);
//		}
	}

}

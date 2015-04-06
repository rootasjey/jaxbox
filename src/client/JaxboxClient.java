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
import soap.JaxboxServiceInterface;

public class JaxboxClient {

	public JaxboxClient() {
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
		QName qname = new QName("http://soap/", "JaxboxServiceService");
		
		Service service = Service.create(url, qname);
		JaxboxServiceInterface jaxbox = service.getPort(JaxboxServiceInterface.class);
		
		System.out.println(jaxbox.getHelloWorld(" jeemys"));
				
		List<Album> albums = Arrays.asList(jaxbox.searchAlbumArtist("Ariana Grande"));
		
		System.out.println("[client] size: " + albums.size());
		for (Album album : albums) {
			System.out.println(album);
		}
	}

}

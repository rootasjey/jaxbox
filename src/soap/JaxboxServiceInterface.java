package soap;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import bean.Album;


@WebService
@SOAPBinding(style = Style.RPC)
public interface JaxboxServiceInterface {
	@WebMethod String getHelloWorld(String name);
	@WebMethod Album[] searchAlbumArtist(String artist) throws ParserConfigurationException, SAXException, IOException;
}

package xml;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import bean.Album;



public class Sax {
	public static String fileReference = null;
	
	public static HashMap<String, Album> albumsList = new HashMap<String, Album>();
	
	public Sax() {
		super();
	}
	
	public static void parse(String file) 
			throws ParserConfigurationException, SAXException, IOException {
		
		XMLReader xr = XMLReaderFactory.createXMLReader();
		SaxLastfm saxHandler = new SaxLastfm();
		xr.setContentHandler(saxHandler);
		xr.setErrorHandler(saxHandler);
		
		FileReader reader = new FileReader(file);
		xr.parse(new InputSource(reader));
	}
	
	public void parseAndCompare(String file, String fileToCompare) 
			throws ParserConfigurationException, SAXException, IOException {
		parse(file);
//		this.fileReference = fileToCompare;
	}
	
	public static void compare(String file) throws SAXException, IOException {
		XMLReader xr = XMLReaderFactory.createXMLReader();
		SaxMusicbrainz saxHandler = new SaxMusicbrainz("album");
		xr.setContentHandler(saxHandler);
		xr.setErrorHandler(saxHandler);
		
		FileReader reader = new FileReader(file);
		xr.parse(new InputSource(reader));
	}

	
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		parse("src/rest/musicbrainz.xml");
	}
	
	public static void parseCallback() {
		System.out.println("parsing finished");
//		System.out.println(albumsList);
	}


}

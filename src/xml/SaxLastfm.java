package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import bean.Album;

public class SaxLastfm extends DefaultHandler {
	private String currentTag="";
	private String tagValue="";
	
	private Album album = null;
	
	public SaxLastfm() {
		super();
	}



	public void startDocument() {
		System.out.println("Start document");
	}
	
	public void endDocument() {
		System.out.println("End document");
		Sax.parseCallback();
	}
	
	public void startElement(String uri, String name,
			String qName, Attributes atts) {
		
		currentTag = name;
		
		// If we encounter these tags, we create a new item
		if (currentTag.equals("album")) {
			
			if (album != null) {
				// Add the title object to a map to recover it faster in the future
//				String localName = xmlObject.get("title") != null? xmlObject.get("title"):xmlObject.get("name");
				
				// If there was something in xmlObject, add it to the list
//				Sax.arrayXMLObjects.add(xmlObject);
//				xmlObject = null;
				
				Sax.albumsList.put(album.getTitreAlbum(), album);
				album = null;
			}
			album = new Album();
		}
	}
	
	public void endElement(String uri, String name, String qName) {
		
	}
	
	public void characters(char ch[], int start, int length) {
		tagValue = new String(ch, start, length);
		
		if (tagValue.length() >= 2) {
//			xmlObject.put(currentTag, tagValue);
			
			switch (currentTag) {
			case "name":
				album.setTitreAlbum(tagValue);
				break;
			case "artist":
				album.setArtisteAlbum(tagValue);
				break;
			case "url":
				album.setUrl(tagValue);
				break;
			case "image":
				album.setImage(tagValue);
				break;
			default:
				break;
			}
		}
	}
}

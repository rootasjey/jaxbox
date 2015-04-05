package xml;


import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import bean.Album;


public class SaxMusicbrainz extends DefaultHandler {
	private String currentTag="";
	private String tagValue="";
	
	private Album localAlbum = null;
	
	public SaxMusicbrainz(String mode) {
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
		if (currentTag.equals("album") || currentTag.equals("cdstub")) {
			if (localAlbum != null) {

				// -----------------------------------------
				// Verify if the album is already in the list
				// If no, add a new Object class,
				// If yes, try to extend the object 
				if (Sax.albumsList.containsKey(localAlbum.getTitreAlbum())) {
					// If we're here, the album's title is already in the list
					// So we check the artist's name
					Album a = Sax.albumsList.get(localAlbum.getTitreAlbum());
//					System.out.println("extend album!!!");
					
					if (a.getArtisteAlbum().equals(localAlbum.getArtisteAlbum())) {
						// The artist's name matches
						// > Extend the object
						if (localAlbum.getScore() != null) {
							a.setScore(localAlbum.getScore());
						}
						if (localAlbum.getCodebareAlbum() != null) {
							a.setCodebareAlbum(localAlbum.getCodebareAlbum());
						}
//						if (localAlbum.getTracks() != 0) {
//							a.setTracks(localAlbum.getTracks());
//						}
						a.setTracks(localAlbum.getTracks());
					}
					
				} else {
					// The object isn't in the list yet
					// We add it
					Sax.albumsList.put(localAlbum.getTitreAlbum(), localAlbum);
//					System.out.println("new album added!");
				}
			}

			localAlbum = new Album();
			
			// Try to get attributes values
			String score = "ext:score";			
			localAlbum.setScore(atts.getValue(score));
			
		} else if (currentTag.equals("track-list")) {
			// Add the number of track for the current element
			String trackcount = "count";
			Integer count = Integer.valueOf(atts.getValue(trackcount));
			localAlbum.setTracks(count);
//			System.out.println("tracks is not empty");
		}
	}
	
	public void endElement(String uri, String name, String qName) {
		
	}
	
	public void characters(char ch[], int start, int length) {
		tagValue = new String(ch, start, length);
		
		if (tagValue.length() >= 2) {			
			switch (currentTag) {
			case "title":
				localAlbum.setTitreAlbum(tagValue);
				break;
			case "artist":
				localAlbum.setArtisteAlbum(tagValue);
				break;
			case "barcode":
				localAlbum.setCodebareAlbum(tagValue);
				break;
			default:
				break;
			}
		}
	}

}

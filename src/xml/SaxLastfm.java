package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import bean.Album;
import bean.Artiste;
import bean.Track;

public class SaxLastfm extends DefaultHandler {
	private String currentTag = "";
	private String tagValue = "";
	
	private Album album = null;
	private Artiste artist = null;
	private Track track	= null;
	
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
		
		if (Sax.mediaType.equals("album")) {
			// If we encounter these tags, we create a new item
			if (currentTag.equals("album")) {
				
				if (album != null) {
					Sax.albumList.put(album.getTitreAlbum(), album);
					album = null;
				}
				album = new Album();
			}
			
		} else if (Sax.mediaType.equals("artist")) {
			// If we encounter these tags, we create a new item
			if (currentTag.equals("artist")) {
				
				if (artist != null) {
					Sax.artistList.put(artist.getNomArtiste(), artist);
					artist = null;
				}
				artist = new Artiste();
			}
		} else if (Sax.mediaType.equals("track")) {
			// If we encounter these tags, we create a new item
			if (currentTag.equals("track")) {
				
				if (track != null) {
					Sax.trackList.put(track.getTitle(), track);
					track = null;
				}
				track = new Track();
			}
		}
	}
	
	public void endElement(String uri, String name, String qName) {
		
	}
	
	// When a value is occurred
	public void characters(char ch[], int start, int length) {
		tagValue = new String(ch, start, length);
		
		if (tagValue.length() >= 2) {
			if (Sax.mediaType.equals("album")) {
				charactersAlbum();
			} else if (Sax.mediaType.equals("artist")) {
				charactersArtist();
			} else if (Sax.mediaType.equals("track")) {
				charactersTrack();
			}
			
		}
	}
	
	// If we want to parse tag value according to album
	public void charactersAlbum() {
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
	
	// If we want to parse tag value according to artist
	public void charactersArtist() {
		switch (currentTag) {
		case "mbid":
			artist.setIdArtiste(tagValue);
			break;
		case "name":
			artist.setNomArtiste(tagValue);
			break;
		case "url":
			artist.setUrl(tagValue);
			break;
		case "image":
			artist.setImage(tagValue);
			break;
		default:
			break;
		}
	}
	
	// If we want to parse tag value according to song
	public void charactersTrack() {
		switch (currentTag) {
		case "name":
			track.setTitle(tagValue);
			break;
		case "artist":
			track.setArtist_name(tagValue);
			break;
		case "url":
			track.setUrl(tagValue);
			break;
		case "image":
			track.setImage(tagValue);
			break;
		case "listeners":
			track.setListeners(tagValue);
			break;
		default:
			break;
		}
	}
}

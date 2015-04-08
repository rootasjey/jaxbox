package xml;


import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import bean.Album;
import bean.Artiste;
import bean.Track;


public class SaxMusicbrainz extends DefaultHandler {
	private String previousTag = ""; // needed to disting artist's name & country's name tags
	private String currentTag = "";
	private String tagValue = "";
	
	private Album localAlbum = null;
	private Artiste localArtist = null;
	private Track localTrack = null;
	
	public SaxMusicbrainz(String mode) {
		super();
		
	}
	
	// Event fired when we start to read the xml document start
	public void startDocument() {
		System.out.println("Start document");
	}
	
	// Event fired when we finsh to read the xml document start
	public void endDocument() {
		System.out.println("End document");
		Sax.parseCallback();
	}
	
	// This event is fired when a starting tag element is encountered
	
	public void startElement(String uri, String name,
			String qName, Attributes atts) {
		
		// Save the previous tag name
		previousTag = currentTag;
		
		// Save the current tag name
		currentTag = name;
		
		if (Sax.mediaType.equals("album")) {
			extendAlbum(uri, name, qName, atts);
			
		} else if (Sax.mediaType.equals("artist")) {
			extendArtist(uri, name, qName, atts);
			
		} else if (Sax.mediaType.equals("track")) {
			extendTrack(uri, name, qName, atts);
		}		
	}
	
	
	// What to do with a album's xml document when the 'startElement' method is fired
	public void extendAlbum(String uri, String name, String qName, Attributes atts) {
		// If we encounter these tags, we create a new item
		if (currentTag.equals("album") || currentTag.equals("cdstub")) {
			if (localAlbum != null) {
				
				// -----------------------------------------
				// Verify if the album is already in the list
				// If no, add a new Object class,
				// If yes, try to extend the object 
				if (Sax.albumList.containsKey(localAlbum.getTitreAlbum())) {
					// If we're here, the album's title is already in the list
					// So we check the artist's name
					Album a = Sax.albumList.get(localAlbum.getTitreAlbum());
					//System.out.println("extend album!!!");
					
					if (a.getArtisteAlbum().equals(localAlbum.getArtisteAlbum())) {
						// The artist's name matches
						// > Extend the object
						if (localAlbum.getScore() != null) {
							a.setScore(localAlbum.getScore());
						}
						if (localAlbum.getCodebareAlbum() != null) {
							a.setCodebareAlbum(localAlbum.getCodebareAlbum());
						}
						a.setTracks(localAlbum.getTracks());
					}
					
				} else {
					// The object isn't in the list yet, we add it
					Sax.albumList.put(localAlbum.getTitreAlbum(), localAlbum);
					//System.out.println("new album added!");
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
			//System.out.println("tracks is not empty");
		}
	}
	
	
	// What to do with a artist's xml document when the 'startElement' method is fired
	public void extendArtist(String uri, String name, String qName, Attributes atts) {
		// If we encounter these tags, we create a new item
		if (currentTag.equals("artist")) {
			if (localArtist != null) {

				// -----------------------------------------
				// Verify if the album is already in the list
				// If no, add a new Object class,
				// If yes, try to extend the object 
				if (Sax.artistList.containsKey(localArtist.getNomArtiste())) {
					// If we're here, the album's title is already in the list
					// So we check the artist's name
					Artiste a = Sax.artistList.get(localArtist.getNomArtiste());
					
					//System.out.println("artist extend!!!");
					
					if (a.getNomArtiste().equals(localArtist.getNomArtiste())) {
						// The artist's name matches
						// > Extend the object
						if (localArtist.getScore() != null) {
							a.setScore(localArtist.getScore());
						}
						if (localArtist.getDescription() != null) {
							a.setDescription(localArtist.getDescription());
						}
						//a.setTracks(localAlbum.getTracks());
					}
					
				} else {
					// The object isn't in the list yet, we add it
					Sax.artistList.put(localArtist.getNomArtiste(), localArtist);
					//System.out.println("new artist added!");
				}
			}
			localArtist = new Artiste();
			
			// Try to get attributes values
			String score = "ext:score";
			localArtist.setScore(atts.getValue(score));
			
			String idArtist = "id";
			localArtist.setIdArtiste(atts.getValue(idArtist));
			
		}
	}
	
	
	// What to do with a track's xml document when the 'startElement' method is fired
	public void extendTrack(String uri, String name, String qName, Attributes atts) {
		// If we encounter these tags, we create a new item
		if (currentTag.equals("recording")) {
			if (localTrack != null) {
				
				// -----------------------------------------
				// Verify if the album is already in the list
				// If no, add a new Object class,
				// If yes, try to extend the object 
				if (Sax.trackList.containsKey(localTrack.getTitle())) {
					// If we're here, the album's title is already in the list
					// So we check the artist's name
					Track t = Sax.trackList.get(localTrack.getTitle());
					//System.out.println("extend album!!!");
					
					if (t.getTitle().equals(localTrack.getTitle())) {
						// The artist's name matches
						// > Extend the object
						// -------------------------
						
						if (localTrack.getScore() != null) 
							t.setScore(localTrack.getScore());
						
						if (localTrack.getRelease_date() != null) 
							t.setRelease_date(localTrack.getRelease_date());
						
						if (localTrack.getArtistId() != null)
							t.setArtistId(localTrack.getArtistId());
					}
					
				} else {
					// The object isn't in the list yet, we add it
					Sax.trackList.put(localTrack.getTitle(), localTrack);
					//System.out.println("new album added!");
				}
			}
			localTrack = new Track();
			
			// Try to get attributes values
			String score = "ext:score";
			localTrack.setScore(atts.getValue(score));
			
		} else if (currentTag.equals("artist")) {
			// Add the number of track for the current element
			String artistId = "id";
			localTrack.setArtistId(atts.getValue(artistId));
			//System.out.println("tracks is not empty");
		}
	}
	
	public void endElement(String uri, String name, String qName) {
		
	}
	
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
	
	// If we want to parse tag value according to artist
	public void charactersArtist() {
		switch (currentTag) {
		case "name":
			// As we have multiple tag for "name", 
			// we have to check what's the previous tag
			if (previousTag.equals("artist"))
				localArtist.setNomArtiste(tagValue);
			else if (previousTag.equals("area"))
				localArtist.setPaysArtiste(tagValue);;
			break;
		case "disambiguation":
			localArtist.setDescription(tagValue);
			break;
		//case "country":
			//localArtist.setPaysArtiste(tagValue);
			//break;
		default:
			break;
		}
	}
	
	// If we want to parse tag value according to track
	public void charactersTrack() {
		switch (currentTag) {
		case "title":
			if (previousTag.equals("recording"))
				localTrack.setTitle(tagValue);
			break;
		case "name":
			if (previousTag.equals("artist"))
				localTrack.setArtist_name(tagValue);
			break;
		case "date":
			if (previousTag.equals("release-group"))
				localTrack.setRelease_date(tagValue);
			break;
		default:
			break;
		}
	}
}

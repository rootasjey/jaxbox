package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xml.Sax;
import bean.Album;
import bean.Artiste;
import bean.Track;

public class Transit {

	public Transit() {
		
	}
	
	// Insert a set of Album contained in a HasMap
	public static void persistAlbums(HashMap<String, Album> albums) {
		Iterator<?> iterator = Sax.albumList.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry pair = (Map.Entry)iterator.next();
			
			Album album = (Album) pair.getValue();
			iterator.remove();
			
			AlbumPersist persist = new AlbumPersist();
			persist.ajouterAlbum(album);
		}
	}
	
	public static List<Album> getAlbumsByAuthor(String author) {
		AlbumPersist persist = new AlbumPersist();
		List<Album> albums = persist.chercherAvecNomArtiste(author);
		
		return albums;
	}
	
	// Insert a set of Artist contained in a HasMap
	public static void persistArtists(HashMap<String, Artiste> artists) {
		Iterator<?> iterator = Sax.artistList.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry pair = (Map.Entry)iterator.next();
			Artiste artist = (Artiste) pair.getValue();
			
			iterator.remove();
			
			ArtistePersist persist = new ArtistePersist();
			persist.ajouterArtiste(artist);
		}
	}
	
	public static List<Artiste> getArtists(String artist) {
		ArtistePersist persist = new ArtistePersist();
		List<Artiste> artists = persist.chercherAvecNomArtiste(artist);
		
		return artists;
	}
	
	// Insert a set of Track contained in a HasMap
	public static void persistTracks(HashMap<String, Track> tracks) {
		Iterator<?> iterator = Sax.trackList.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry pair = (Map.Entry)iterator.next();
			Track track = (Track) pair.getValue();
			
			iterator.remove();
			
			TrackPersist persist = new TrackPersist();
			persist.ajouterTrack(track);
		}
	}
	
	public static List<Track> getTracks(String track) {
		TrackPersist persist = new TrackPersist();
		List<Track> tracks = persist.queryTracks(track);
		
		return tracks;
	}

}

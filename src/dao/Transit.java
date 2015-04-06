package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xml.Sax;
import bean.Album;

public class Transit {

	public Transit() {
		
	}
	
	public static void persistAlbums(HashMap<String, Album> albums) {
		Iterator<?> iterator = Sax.albumsList.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry pair = (Map.Entry)iterator.next();
			Album album = (Album) pair.getValue();
//			System.out.println(album);
			iterator.remove();
			
			AlbumPersist persistTool = new AlbumPersist();
			persistTool.ajouterAlbum(album);
		}
	}
	
	public static List<Album> getAlbumsByAuthor(String author) {
		AlbumPersist persistTool = new AlbumPersist();
		List<Album> albums = persistTool.chercherAvecNomArtiste(author);
		
		return albums;
	}

}

package dao;


import java.util.List;

import bean.Album;
import bean.Artiste;
import bean.Track;

public class AppMain {

	public static void main(String[] args) {
		/**Insert Artiste**/
		Artiste art = new Artiste();
		ArtistePersist artP = new ArtistePersist();
		art.setNomArtiste("Stromae");
		art.setPrenomArtiste("Paul");
		art.setPaysArtiste("Belgique");
		artP.ajouterArtiste(art);
		
		/**Insert Album**/
		AlbumPersist albP = new AlbumPersist();
		Album alb = new Album();
		alb.setArtisteAlbum("Stromae");
		alb.setIdArtisteAlbum("ss");
		alb.setTitreAlbum("Racine Carree");
		alb.setCommentAlbum("Ceci est album du Maestro");
		albP.ajouterAlbum(alb);
		
		/**Insert Album**/
		Album alb2 = new Album();
		alb2.setArtisteAlbum("Stromae");
		alb2.setIdArtisteAlbum("2");
		alb2.setTitreAlbum("Cheese");
		alb2.setCommentAlbum("Ceci est album du Maestro -Cheese-");
		albP.ajouterAlbum(alb2);
		
		/**Insert Track**/
		Track tr = new Track();
		TrackPersist trP = new TrackPersist();
		tr.setIdRecording("aytuu-455-uyu");
		tr.setArtist_name("Stromae");
		tr.setLength("1222");
		tr.setRelease_contry("US");
		tr.setRelease_title("Papaoute");
		trP.ajouterTrack(tr);
		System.out.println("fait");
		/******************************************************************/
		System.out.println("Les albums de Stromae");
		List<Album> listeAlb = albP.chercherAvecNomArtiste("Stromae");
		
		for (Album unAlbum : listeAlb) {
			System.out.println("*"+unAlbum.getTitreAlbum());
		}
		
		/******************************************************************/
		
		System.out.println("Les Artiste qui portent le nom  : Stromae");
		List<Artiste> listeArti = artP.chercherAvecNomArtiste("Stromae");
		
		for (Artiste unArtiste : listeArti) {
			System.out.println("*"+unArtiste.toString());
		}
	}

}

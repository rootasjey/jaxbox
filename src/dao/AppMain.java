package dao;

import java.util.Date;

import bean.Artiste;

public class AppMain {

	public static void main(String[] args) {
		Artiste art = new Artiste();
		art.setNomArtiste("Stromae");
		art.setPrenomArtiste("Paul");
		art.setPaysArtiste("Belgique");
		//art.setDateNaissArtiste(new Date());
		
		ArtistePersist artP = new ArtistePersist();
		artP.ajouterArtiste(art);
		System.out.println("fait");

	}

}

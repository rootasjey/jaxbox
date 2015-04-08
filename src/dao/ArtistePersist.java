package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Album;
import bean.Artiste;

public class ArtistePersist {
	public void ajouterArtiste(Artiste art){
		Session session = DBConnect.getSessionFactory().getCurrentSession();
		
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			System.out.println("eee");
			session.save(art);
			
			tx.commit();
			
		}catch(Exception e){
			e.getMessage();
			tx.rollback();
		}
	}
	
	public List<Artiste> chercherAvecNomArtiste(String nomArti){
		System.out.println("query artist");
		List<Artiste> listeAlbum = null;
		Transaction tx = null;
		Session session = DBConnect.getSessionFactory().getCurrentSession();
		
		
		try{
			tx = session.beginTransaction();
			Query req = session.createQuery("select a from Artiste as a where a.nomArtiste= :nomartiste ");
			req.setString("nomartiste", nomArti);
			listeAlbum = req.list();
			tx.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			tx.rollback();
		}
		
		return listeAlbum;
	} 
}

package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Album;

public class AlbumPersist {
	public void ajouterAlbum(Album alb){
		Session session = DBConnect.getSessionFactory().getCurrentSession();
		
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			System.out.println("ALBUM");
			session.save(alb);
			
			tx.commit();
			
		}catch(Exception e){
			e.getMessage();
			tx.rollback();
		}
	}
	
	public List<Album> chercherAvecNomArtiste(String nomArti){
		System.out.println("methoe recherche Album");
		//Album alb = new  Album();
		List<Album> listeAlbum = null;
		Transaction tx = null;
		Session session = DBConnect.getSessionFactory().getCurrentSession();
		
		
		try{
			tx = session.beginTransaction();
			Query req = session.createQuery("select a from Album as a where a.artisteAlbum= :nomartiste ");
			req.setString("nomartiste", nomArti);
			listeAlbum = req.list();

			//alb = listeAlbum.get(0);
			tx.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			tx.rollback();
		}
		
		return listeAlbum;
	} 
}

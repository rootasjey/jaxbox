package dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

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
}

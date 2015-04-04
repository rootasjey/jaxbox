package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Track;

public class TrackPersist {
	public void ajouterTrack(Track tr){
		Session session = DBConnect.getSessionFactory().getCurrentSession();
		
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			System.out.println("TRACK");
			session.save(tr);
			
			tx.commit();
			
		}catch(Exception e){
			e.getMessage();
			tx.rollback();
		}
	}
}

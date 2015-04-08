package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Artiste;
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
	
	public List<Track> queryTracks(String track){
		System.out.println("query tracks...");
		List<Track> tracks = null;
		Transaction tx = null;
		Session session = DBConnect.getSessionFactory().getCurrentSession();
		
		
		try{
			tx = session.beginTransaction();
			Query req = session.createQuery("select t from Track as t where t.title= :title ");
			req.setString("title", track);
			tracks = req.list();
			tx.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
			tx.rollback();
		}
		
		return tracks;
	} 
}

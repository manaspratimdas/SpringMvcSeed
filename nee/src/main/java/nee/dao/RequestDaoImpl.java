package nee.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nee.model.Request;


@Repository("RequestDao")
public class RequestDaoImpl implements RequestDao {

	@Autowired
	   private SessionFactory sessionFactory;
	
	
	public void save(Request request) {
		if(sessionFactory!=null){
			Session session=this.sessionFactory.getCurrentSession();
			session.persist(request);
			System.out.println("Request successfully saved");
		}
		else{
			System.out.println("Session factory is null");
			
		}
		
		
		
	}

}

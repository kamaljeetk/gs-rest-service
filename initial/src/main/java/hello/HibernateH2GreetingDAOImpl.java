package hello;

import hello.Greeting.Type;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("hibernateDao")
public class HibernateH2GreetingDAOImpl implements JDBCGreetingDAO{

	@Autowired
	private SessionFactory sessionFactory;

		
	// select * from Greetings
	public List<Greeting> findAllMessagesWithMaxPriority() {
		String hql = "FROM Greeting G WHERE G.priority in (SELECT max(priority) FROM Greeting)";
		Query query = sessionFactory.openSession().createQuery(hql);
		List<Greeting> results = query.list();
		
		return results;
	}
	
	public List<String> getAllContent() {
		String hql = "Select content FROM Greeting";
		Query query = sessionFactory.openSession().createQuery(hql);
		List<String> results = query.list();
		
		return results;
	}
	
	public List<Greeting> getAllGreeting() {
		String hql = "FROM Greeting";
		Query query = sessionFactory.openSession().createQuery(hql);
		System.out.println(query);
		List<Greeting> results = query.list();
		return results;
	}
	
	public List<Greeting> findMessagesGivenPriority() {
		String hql = "FROM Greeting ORDER BY PRIORITY DESC";
		Query query = sessionFactory.openSession().createQuery(hql);
		List<Greeting> results = query.list();
		
		return results;
	}
	
	
	public void save(Greeting greeting) {
		
		Session session = sessionFactory.openSession();
		
		List<Address> a =greeting.getAddress();
		for (Address address : a) {
			System.out.println("AddressID to b saved:"+address.getAddress_id());
		}
		//session.save(greeting.getAddress());
		session.save(greeting);
		System.out.println("savedddddddddddddddddddddddd");
		session.flush();
	}

	public List<Greeting> findGreetingById(Long id) {
		
		String hql = " FROM Greeting where id=:id";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("id", id);
		List<Greeting> results = query.list();
		
		return results;
	}
	
	public List<Greeting> getAllGreetingwithTypeOKOK() {
		String hql = "FROM Greeting WHERE type=:type";
		Query query = sessionFactory.openSession().createQuery(hql).setParameter("type", Type.OKOK);
		System.out.println(query);
		List<Greeting> results = query.list();
		
		
		return results;
	}

	public void addAddress() {
		Address a=new Address();
		//List<Address> addobj =new ArrayList();
		a.setAddress_id(100);
//		a.setAddressLine1("Maroun PL");
//		a.setCityandState("San Jose CA");
		a.setHouseNo(3424);
//		a.setZipcode("95148");
		System.out.println("in dao");	
		Session session = sessionFactory.openSession();
		session.save(a);
		session.flush();
		
		
	}

	
	}

	


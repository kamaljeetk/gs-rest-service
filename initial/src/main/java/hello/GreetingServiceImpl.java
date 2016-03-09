package hello;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

	@Service
	public class GreetingServiceImpl implements GreetingService {

		@Autowired
		@Qualifier("hibernateDao")
		JDBCGreetingDAO greetingDao;
		
		@Autowired
		Environment env;
		
		private static final String PROPERTY_NAME_GREETING_PRIORITY = "greeting.priority";
	     
	    public  List<Greeting> maxPriority(){
	    	System.out.println("Hello");
	    	return greetingDao.findAllMessagesWithMaxPriority();
	    }
	    
	    
	   
	    public  List<Greeting> findMessagesGivenPriority(){
	    		Long priority=Long.valueOf(env.getRequiredProperty(PROPERTY_NAME_GREETING_PRIORITY));
	 	    	List<Greeting> greetings=greetingDao.findMessagesGivenPriority();
	 	    	List<Greeting> newlist=new ArrayList<Greeting>();
	 	    
	 	    	for (Greeting greeting : greetings) {
					if(greeting.getPriority()==priority){
						/*Greeting g1=new Greeting();
						g1.setId(greeting.getId());
						g1.setContent(greeting.getContent());
						g1.setPriority(priority);*/
						newlist.add(greeting);
					}	
				}
	 	    	return newlist;
	    }

	    public  List<String> findContentlength(){
	    	
	    	List<String> contents=greetingDao.getAllContent();
 	    	List<String> newlist1=new ArrayList<String>();
 	    	
 	    	for (String content : contents) {
 	    		if(content.length()>10){
 	    			newlist1.add(content);
 	    		}
			}
 	    	return newlist1;
	    }


		public void saveGreeting(Greeting g) {
			
			greetingDao.save(g);
			
		}
		
		public  List<Greeting> getAllGreetings(){
			return greetingDao.getAllGreeting();
		}


		public List<Greeting> findGreetingById(Long id) {
			// TODO Auto-generated method stub
			return greetingDao.findGreetingById(id);
		}
		
		public Map<Long,List<String> >  exposemap(){
			 List<Greeting> Greetings=greetingDao.getAllGreeting();
			 Map<Long,List<String> > m = new HashMap< Long,List<String>>();
			 
			 for (Greeting greeting : Greetings)
			 {		 
					 if(!m.containsKey(greeting.getPriority())){
						 List<String> contents=new ArrayList<String>();
					 contents.add( greeting.getContent());
					m.put(greeting.getPriority(),contents); 

				 }else{
					 List<String> oldContents=m.get(greeting.getPriority());
					 oldContents.add( greeting.getContent());
					//m.put(greeting.getPriority(),oldContents);				 
			 }
			
			}return m;
		}
		
			 public Map<Long,List<Greeting>> sortedMap(){
				 List<Greeting> Greetings=greetingDao.getAllGreeting();
				 
				 Map<Long,List<Greeting> > m = new HashMap< Long,List<Greeting>>();
				 
				 for (Greeting greeting : Greetings)
				 {		 
						 if(!m.containsKey(greeting.getPriority())){
							 List<Greeting> contents=new ArrayList<Greeting>();
							 contents.add( greeting);
							 m.put(greeting.getPriority(),contents);
							  

					 }else{
						 List<Greeting> oldContents=m.get(greeting.getPriority());
						 oldContents.add( greeting);
						// Collections.sort(oldContents, new Greeting()); 
						//m.put(greeting.getPriority(),oldContents);
						//m.put(greeting.getPriority(),oldContents);				 
				 }
			}
				 // Very good 
				 for (List<Greeting>  contents :m.values()){
					 
					 Collections.sort(contents, new Greeting()); 
					
				}
							
				return Collections.unmodifiableMap(m);
		}



			public void addAddress() {
				greetingDao.addAddress();
				
			}
	}
		
	
	      	
	    	
	    




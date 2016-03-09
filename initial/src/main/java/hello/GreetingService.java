package hello;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface GreetingService {
	
public  List<Greeting> maxPriority();
public  List<Greeting> findMessagesGivenPriority();
public  List<String> findContentlength();
public void saveGreeting(Greeting g);
public  List<Greeting> getAllGreetings();
public List<Greeting> findGreetingById(Long id);
public Map<Long,List<String> > exposemap ();
public Map<Long,List<Greeting>> sortedMap();
public void addAddress();

}

/**
 * 
 */
package hello;

import java.util.List;


/**
 * @author nound_000
 *
 */

public interface JDBCGreetingDAO {
	int o=10;
	public List<Greeting> findAllMessagesWithMaxPriority();
	public List<Greeting> findMessagesGivenPriority();
	public List<String> getAllContent();
	public void save(Greeting greeting);
	public List<Greeting> getAllGreeting();
	public List<Greeting> findGreetingById(Long id);
	public List<Greeting> getAllGreetingwithTypeOKOK();
	public void addAddress();
}

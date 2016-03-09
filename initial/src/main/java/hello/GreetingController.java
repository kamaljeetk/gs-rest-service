package hello;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final int counter = 5;
    
    
    @Autowired
    private GreetingService greetingService;
    
    @Autowired
    private UriBuilder buildUri;
    
    @RequestMapping(value="/greetings", method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
       // return new Greeting(counter, String.format(template, name),1,Greeting.Type.GREAT,1);
    	return null;
    }
    @RequestMapping("/greetingFromService")
    public List<Greeting> greetingFromService(@RequestParam(value="name", defaultValue="World") String name) {
    	List<Greeting> greetings = greetingService.findMessagesGivenPriority();
    	return greetings;
    }
    @RequestMapping("/maxPriority")
    public List<Greeting> maxPriority() {
    	List<Greeting> greetings = greetingService.maxPriority();
    	return greetings;
    }
    @RequestMapping("/content")
        public List<String> getContentwithlength15() {
        	List<String> contentList = greetingService.findContentlength();
        	return contentList;
    }
    @RequestMapping("/getAllGreetings")
 	    public List<Greeting> getAllGreetings() {
 	    	List<Greeting> greetings = greetingService.getAllGreetings();
 	    	createJson(greetings);
 	    	return greetings; }
    	 
	
	@RequestMapping(value = "/savegreetings", method = RequestMethod.POST, consumes = "application/json")
	public void saveGreeting(@RequestBody Greeting greeting) {
		greetingService.saveGreeting(greeting);
	}	 
    	 
    	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Greeting> fetchgreetingBasedonID(@PathVariable Long id) {
		List<Greeting> greetings = greetingService.findGreetingById(id);
		if (greetings.isEmpty()) {
			throw new GreetingNotFoundException(id);
		}
		return greetings;
	}
    

	@ExceptionHandler(GreetingNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error GreetingException(GreetingNotFoundException ex) {
		return new Error(404, "greeting");
	}
	
	
	public void createJson(List<Greeting> greetings){
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		try {
			for (Greeting greeting : greetings) {
			json = objectMapper.writeValueAsString(greeting);
			System.out.println(json);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

		
			    	
	@RequestMapping( value="/saveandRespond",method=RequestMethod.POST ,consumes="application/json")
	public ResponseEntity<Greeting> savendRespond( @RequestBody Greeting greeting)
	{
		greetingService.saveGreeting(greeting);
		HttpHeaders headers = new HttpHeaders(); 
		URI locationUri = buildUri.path("/Greeting/") .
				path(String.valueOf(greeting.getId())) .build() .toUri();
		headers.setLocation(locationUri);
		ResponseEntity<Greeting> responseEntity = 
				new ResponseEntity<Greeting>( greeting, headers, HttpStatus.CREATED);
				return responseEntity;
	}
	
	@RequestMapping("/exposemap")
    public Map<Long,List<String> >  exposemap() {
		@SuppressWarnings("unchecked")
		Map<Long,List<String> >  map= greetingService.exposemap();
    	return map;
	}
	
		@RequestMapping("/sortedMap")
    	public Map<Long,List<Greeting>> getsortedMap(){
    		Map<Long, List<Greeting>> smap=greetingService.sortedMap();
    		return smap;
    	}
    		
    	
    
}
	
    	



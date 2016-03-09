package hello;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UIController {

	@Autowired
    private GreetingService greetingService;
    
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public ModelAndView welcome() {
		
		ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome");
         
        String str = "Hello World!";
        mav.addObject("message", str);
        mav.addObject("time", new Date());
        mav.addObject("message","Hi there");
        return mav;
	}
	
	@RequestMapping(value="/customise", method=RequestMethod.GET) 
	public String showCreateGreetingForm(){ 
		return "createGreetings"; 
	}
	
	@RequestMapping(value="/customise", method=RequestMethod.POST) 
	public String saveGreeting(Greeting greeting,Map<String, List<Greeting>> model){
		greetingService.saveGreeting(greeting);
		model.put("greetingList",greetingService.getAllGreetings());
		return "show";
	}
	
	@RequestMapping("/getAllGreetings")
	    public String getAllGreetings(Map<String, List<Greeting>> model) {
			
	    	List<Greeting> greetings = greetingService.getAllGreetings();
	    	System.out.println(greetings.size());
	    	model.put("greetingList",greetings);
	    	for (Greeting greeting : greetings) {
				
				for (Address a : greeting.getAddress()) {
					System.out.println(a.getAddress_id()+"~~~~~~~~~~~~"+a.getHouseNo());
				}
			}
	    	
	    	return "show"; 
	    	}
	
	@RequestMapping("/createAddress")
	public String createAddress(){
		greetingService.addAddress();
		return "welcome";
	}
	 

}

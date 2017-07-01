package com.dp.digip.controllers; 


import com.dp.digip.models.User;
import com.dp.digip.models.Event;
import com.dp.digip.CustomSearch;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.lang.Exception;

import static java.lang.System.out;


@Controller
public class SearchController {

	@Autowired
	private CustomSearch search;

	@RequestMapping("/freeuser")
	public String freeUserSearch( Model m){
		List<User> searchResult = null;
		
		//to q prepei na pernei timi apo front	
		String q = "petros";		

		try{
			searchResult = search.userSearch(q);
		}		
		catch ( Exception ex) { 
			out.println("exception in userSearch");
		}

		out.println("\n\n\\n");
                for (int i =0 ; i < searchResult.size() ; i++)
                {
			User user = searchResult.get(i);
		        out.println( user.getUsername());
		}
		
		if ( searchResult.size() != 0 )
			out.println("\n\n\n\n");	
		else
			out.println("result set = 0");

		//prepei na valw sto model to List searchResult
		//prepei na valw sto model to q pou psaxnoume

		return "index";
	}	

	@RequestMapping("/freeevent")
	public String freeEventSearch(Model m ){
		List<Event> searchResult = null;

		String q = "activities";
		try{
			searchResult = search.eventSearch(q);
		}
		catch( Exception ex) {
			out.println("exception in eventSearch");
		}
	 		
		out.println("\n\n\\n");
                for (int i =0 ; i < searchResult.size() ; i++)
                {
                        Event event = searchResult.get(i);
                        out.println( event.getName());
                }

                if ( searchResult.size() != 0 )
                        out.println("\n\n\n\n");
                else
                        out.println("result set = 0");

                //prepei na valw sto model to List searchResult
                //prepei na valw sto model to q pou psaxnoume
                
	        return "index";
	}




} 

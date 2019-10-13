package com.a3dm.mirchaye.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a3dm.mirchaye.domains.CityVoter;
import com.a3dm.mirchaye.domains.RegionalVoter;
import com.a3dm.mirchaye.repositories.CityVotersRepository;
import com.a3dm.mirchaye.repositories.RegionalVotersRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
  
	public CityVotersRepository cityVotersRepository;
	public RegionalVotersRepository regionalVotersRepository;
	
  @GetMapping("/a")
  public String home(Model model) {
	  Iterable<CityVoter> cityVoters=cityVotersRepository.findAll();
	  Iterable<RegionalVoter> regionalVoters=regionalVotersRepository.findAll();
	  model.addAttribute("cVoters", cityVoters);
	  model.addAttribute("rVoters",regionalVoters);
	  return "pending";    
  }
  
  @GetMapping("/test")
  public String test() {
	 // throw new RuntimeException("Test Exception");
    return "pending";    
  }
  
  @GetMapping("/testsec")
  public String testSec() {
    return "verified";    
  }

}
  

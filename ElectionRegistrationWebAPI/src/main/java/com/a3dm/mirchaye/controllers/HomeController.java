package com.a3dm.mirchaye.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a3dm.mirchaye.domains.CityVoter;
import com.a3dm.mirchaye.domains.RegionalVoter;
import com.a3dm.mirchaye.repositories.CityVotersRepository;
import com.a3dm.mirchaye.repositories.RegionalVotersRepository;

@Controller 
@RequestMapping("/")
public class HomeController {
  
	public CityVotersRepository cityVotersRepository;
	public RegionalVotersRepository regionalVotersRepository;

  	@Autowired
	public HomeController(CityVotersRepository cityService, RegionalVotersRepository regionalService) {
		this.cityVotersRepository = cityService;
		this.regionalVotersRepository = regionalService;
	}
  @GetMapping("/")
  public String home() {
	  return "index";
  }
  
  @GetMapping("/login")
  public String home(Model model) {
	  Iterable<CityVoter> cityVoters=cityVotersRepository.findAll();
	  Iterable<RegionalVoter> regionalVoters=regionalVotersRepository.findAll();
	  model.addAttribute("cVoters", cityVoters);
	  model.addAttribute("rVoters",regionalVoters);
	  return "pending";    
  }
  
}
package com.a3dm.mirchaye.api;

import java.util.Optional;

import org.apache.logging.slf4j.SLF4JLogger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.a3dm.mirchaye.domains.CityVoter;
import com.a3dm.mirchaye.domains.RegionalVoter;
import com.a3dm.mirchaye.repositories.CityVotersRepository;
import com.a3dm.mirchaye.repositories.RegionalVotersRepository;
import com.mysql.cj.log.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path="/", produces="application/json")
@CrossOrigin(origins="*")
public class VotersController {

	private CityVotersRepository cityVotersService;
	private RegionalVotersRepository regionalVotersService;
	
	public VotersController(CityVotersRepository cityVotersService,RegionalVotersRepository regionalVotersService) {
		this.cityVotersService = cityVotersService;
		this.regionalVotersService=regionalVotersService;
	}
	
	@GetMapping("/voters/city/{cityName")
	public Iterable<CityVoter> AllusersOfcity(@PathVariable("cityName") String city){
		return cityVotersService.findAll();
		//return cityVotersService.findAllByCity(city);
	}
	
	@GetMapping("/voters/city/{phoneNumber}")
	public ResponseEntity<CityVoter> userByPhone(@PathVariable("phoneNumber") String phone){
		Optional<CityVoter> user = cityVotersService.findByPhoneNumber(phone);
		if(user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(path="/voters/city", consumes="application/json")
	public ResponseEntity<CityVoter> saveCityVoter(@RequestBody CityVoter user) {
		CityVoter savedUser = cityVotersService.save(user);
		if(savedUser != null) {			
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(path="/voters/region", consumes="application/json")
	public ResponseEntity<RegionalVoter> saveRegionalVoter(@RequestBody RegionalVoter user) {
		RegionalVoter savedUser = regionalVotersService.save(user);
		if(savedUser != null) {			
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PatchMapping(path="/voters/city/{voterId}", consumes="application/json")
	public ResponseEntity<CityVoter> partialCityVoterUpdate(@PathVariable("voterId") Long id, @RequestBody CityVoter partialUser) {
		
		CityVoter user = cityVotersService.findById(id).get();
		
		if(user != null) {
			if(partialUser.status!= null) {
				user.status=partialUser.status;
			}
		}
		CityVoter savedUser = cityVotersService.save(user);
		if(savedUser != null) {			
			return new ResponseEntity<>(savedUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
	}
	
	@PatchMapping(path="/voters/region/{voterId}", consumes="application/json")
	public ResponseEntity<RegionalVoter> partialRegionalVoterUpdate(@PathVariable("voterId") Long id, @RequestBody RegionalVoter partialUser) {
		
		RegionalVoter user = regionalVotersService.findById(id).get();
		
		if(user != null) {
			if(partialUser.status!= null) {
				user.status=partialUser.status;
			}
		}
		RegionalVoter savedUser = regionalVotersService.save(user);
		if(savedUser != null) {			
			return new ResponseEntity<>(savedUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
	}	
}
package com.a3dm.mirchaye.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.a3dm.mirchaye.domains.CityVoter;
import com.a3dm.mirchaye.domains.RegionalVoter;

public interface RegionalVotersRepository extends CrudRepository<RegionalVoter, Long>{
	
	public Optional<RegionalVoter> findByPhoneNumber(String phone);
}

package com.a3dm.mirchaye.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.a3dm.mirchaye.domains.CityVoter;

public interface CityVotersRepository extends CrudRepository<CityVoter, Long>{

	public Optional<CityVoter> findByPhoneNumber(String phone);
	public Iterable<CityVoter> findAllByCity(String city);
}

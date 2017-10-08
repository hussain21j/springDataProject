package com.mkyong.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkyong.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{
	public Country save(Country country);
	public List<Country> findByCountryName(String countryName);
	public List<Country> findByCountryCode(String countryCode);
}

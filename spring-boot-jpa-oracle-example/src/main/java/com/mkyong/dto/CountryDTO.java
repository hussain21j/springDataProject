package com.mkyong.dto;

public class CountryDTO {

	String countryId;
	String countryName;
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public CountryDTO(String countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return "CountryDTO [countryId=" + countryId + ", countryName=" + countryName + "]";
	}
	
	
	
	
	
	
}

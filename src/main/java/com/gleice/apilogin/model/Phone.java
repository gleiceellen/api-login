package com.gleice.apilogin.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class Phone {
	
	@Id
	@GeneratedValue
	private Long id;
	private String number;
    private String ddd;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

}

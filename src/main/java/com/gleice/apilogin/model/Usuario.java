package com.gleice.apilogin.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;

	//@JsonIgnore
	private String password;

    private Date created;
    private Date modified;
    private Date lastLogin;
    private String token;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Phone> phones;
	
	public Usuario(String nome, String email, String password) {
		this();   
		this.nome = nome;
        this.email = email;
        this.password = password;
    }
	
	public Usuario() {
		this.created = new Date();
        this.modified = new Date();
        this.lastLogin = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void criarToken() {
		this.token = UUID.randomUUID().toString();
	}
	
	public String getToken() {
		return this.token;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

}

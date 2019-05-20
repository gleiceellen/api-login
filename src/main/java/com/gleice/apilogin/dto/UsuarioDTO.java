package com.gleice.apilogin.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gleice.apilogin.model.Phone;
import com.gleice.apilogin.model.Usuario;

import java.util.Date;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UsuarioDTO {

    private String nome;
    private String email;
    private String password;
    private List<Phone> phones;
//    private Date created;
//    private Date modified;
//    private Date lastLogin;
//    private String token;

    public Usuario transformaParaObjeto() {
        return new Usuario(getNome(), getEmail(), getPassword(), getPhones());
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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

//    public Date getCreated() {
//        return created;
//    }
//
//    public void setCreated(Date created) {
//        this.created = created;
//    }
//
//    public Date getModified() {
//        return modified;
//    }
//
//    public void setModified(Date modified) {
//        this.modified = modified;
//    }
//
//    public Date getLastLogin() {
//        return lastLogin;
//    }
//
//    public void setLastLogin(Date lastLogin) {
//        this.lastLogin = lastLogin;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
}

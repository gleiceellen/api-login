package com.gleice.apilogin.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gleice.apilogin.model.Usuario;

import java.util.Date;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UsuarioRespostaDTO {

    private Long id;
    private String nome;
    private String email;
    private String password;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private String token;

    public UsuarioRespostaDTO(Long id, String nome, String email, String password, Date created, Date modified, Date lastLogin) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
    }

    public UsuarioRespostaDTO(){

    }

    public static UsuarioRespostaDTO transformaEmDTO(Usuario usuario) {
        return new UsuarioRespostaDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPassword(), usuario.getCreated(), usuario.getModified(), usuario.getLastLogin());
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.gleice.apilogin.service;

import com.gleice.apilogin.Exception.ExistingEmailException;
import com.gleice.apilogin.Exception.NullTokenException;
import com.gleice.apilogin.Exception.SessionTimeoutExceedException;
import com.gleice.apilogin.Exception.UserNotFoundException;
import com.gleice.apilogin.configSecurity.CustomAuthenticationProvider;
import com.gleice.apilogin.model.Usuario;
import com.gleice.apilogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioPerfilService {

    private CustomAuthenticationProvider authenticationProvider;

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioPerfilService(UsuarioRepository usuarioRepository, CustomAuthenticationProvider authenticationProvider){
        this.usuarioRepository = usuarioRepository;
        this.authenticationProvider = authenticationProvider;
    }

    public UsuarioPerfilService(){}

    public Usuario perfil(Usuario usuario) {
        this.usuarioRepository.findByEmail(usuario.getEmail());
        return usuario;
    }

}

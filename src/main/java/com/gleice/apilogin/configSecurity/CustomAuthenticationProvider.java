package com.gleice.apilogin.configSecurity;


import com.gleice.apilogin.model.Usuario;
import com.gleice.apilogin.service.UsuarioCadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
	UsuarioCadastroService usuarioCadastroService;
   
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	Usuario usuario = usuarioCadastroService.retornaUsuarioPorEmail(authentication.getName());
    	if (usuario != null) {
    		String password = (String) authentication.getCredentials();
    		if (!new BCryptPasswordEncoder().matches(password, usuario.getPassword())) {
    			throw new BadCredentialsException("Senha incorreta!");
    		}

    		return new UsernamePasswordAuthenticationToken(usuario.getEmail(), password, new ArrayList<>());
    	} else {
    		throw new BadCredentialsException("Usuário e/ou senha inválidos");
    	}
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

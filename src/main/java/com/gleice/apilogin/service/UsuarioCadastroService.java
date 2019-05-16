package com.gleice.apilogin.service;

import com.gleice.apilogin.Exception.ExistingEmailException;
import com.gleice.apilogin.model.Usuario;
import com.gleice.apilogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioCadastroService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public void salvar(Usuario usuario) {
        if(usuario == null || naoContemTodosArgumentos(usuario))
            throw new IllegalArgumentException();

        if(emailExiste(usuario))
            throw new ExistingEmailException();

        usuarioRepository.save(usuario);
    }

    public boolean naoContemTodosArgumentos(Usuario usuario){
        if(usuario.getNome().isEmpty() || usuario.getEmail().isEmpty() || usuario.getPassword().isEmpty())
            return true;
        return false;
    }

    public boolean emailExiste(Usuario usuario) {
        if(!usuarioRepository.findByEmail(usuario.getEmail()).isEmpty())
            return true;

        return false;
    }
}

package com.gleice.apilogin.service;

import com.gleice.apilogin.Exception.ExistingEmailException;
import com.gleice.apilogin.Exception.UserNotFoundException;
import com.gleice.apilogin.model.Usuario;
import com.gleice.apilogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioCadastroService {

    private BCryptPasswordEncoder passwordEncoder;

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioCadastroService(UsuarioRepository usuarioRepository,  BCryptPasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioCadastroService(){}

    public Usuario salvar(Usuario usuario) {
        if(usuario == null || naoContemTodosArgumentos(usuario))
            throw new IllegalArgumentException();

        if(emailExiste(usuario) && usuario.getId() == null)
            throw new ExistingEmailException();

        if(isEdicao(usuario)){
            usuario.setModified(new Date());
            return usuarioRepository.save(usuario);
        } else {
            usuario.setCreated(new Date());
            usuario.setModified(new Date());
            usuario.setLastLogin(new Date());
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            return usuarioRepository.save(usuario);
        }
    }

    private boolean isEdicao(Usuario usuario){
        if(usuario.getCreated() != null)
            return true;
        return false;
    }


    private boolean naoContemTodosArgumentos(Usuario usuario){
        return usuario.getNome().trim().isEmpty() || usuario.getEmail().trim().isEmpty() || usuario.getPassword().trim().isEmpty();
    }

    private boolean emailExiste(Usuario usuario) {
        return !usuarioRepository.findByEmail(usuario.getEmail().trim()).isEmpty();

    }

    public Usuario retornaUsuarioPorEmail(String email) {
        List<Usuario> usuarios = usuarioRepository.findByEmail(email);
        if (usuarios.isEmpty())
            throw new UserNotFoundException();

        return usuarios.get(0);
    }
}

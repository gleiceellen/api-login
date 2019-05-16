package com.gleice.apilogin.controller;

import com.gleice.apilogin.Exception.ExistingEmailException;
import com.gleice.apilogin.model.Usuario;
import com.gleice.apilogin.service.UsuarioCadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UsuarioCadastroController {

    @Autowired
    private UsuarioCadastroService usuarioCadastroService;

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        try{
            usuarioCadastroService.salvar(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);

        } catch (ExistingEmailException exc) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já existe!", exc);
        }
    }


}

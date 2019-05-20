package com.gleice.apilogin.controller;

import com.gleice.apilogin.Exception.ExistingEmailException;
import com.gleice.apilogin.dto.UsuarioDTO;
import com.gleice.apilogin.dto.UsuarioRespostaDTO;
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

    private UsuarioCadastroService usuarioCadastroService;

    @Autowired
    public UsuarioCadastroController(UsuarioCadastroService usuarioCadastroService){
        this.usuarioCadastroService = usuarioCadastroService;
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioCadastroService.salvar(usuarioDTO.transformaParaObjeto());
        return  new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
    }


}


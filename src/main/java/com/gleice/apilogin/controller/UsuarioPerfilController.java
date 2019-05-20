package com.gleice.apilogin.controller;

import com.gleice.apilogin.dto.UsuarioDTO;
import com.gleice.apilogin.dto.UsuarioRespostaDTO;
import com.gleice.apilogin.model.Usuario;
import com.gleice.apilogin.service.UsuarioCadastroService;
import com.gleice.apilogin.service.UsuarioPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioPerfilController {

    private final UsuarioPerfilService usuarioPerfilService;

    @Autowired
    public UsuarioPerfilController(UsuarioPerfilService usuarioPerfilService){
        this.usuarioPerfilService = usuarioPerfilService;
    }

    @PostMapping("/perfil")
    public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioPerfilService.perfil(usuarioDTO.transformaParaObjeto());
        return  new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
    }
}

package com.gleice.apilogin.service;

import com.gleice.apilogin.Exception.ExistingEmailException;
import com.gleice.apilogin.model.Usuario;
import com.gleice.apilogin.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UsuarioCadastroServiceTest {

    @InjectMocks
    private UsuarioCadastroService usuarioCadastroService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarExceptionCasoUsuarioSejaNulo() {
        Usuario usuario = null;
        usuarioCadastroService.salvar(usuario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarExceptionCasoUsuarioNãoContenhaTodosAtributos() {
        Usuario gleice = new Usuario("Gleice", "gleice@hotmail.com", "123");
        gleice.setEmail("");
        usuarioCadastroService.salvar(gleice);
    }

    @Test(expected = ExistingEmailException.class)
    public void deveRetornarExceptionCasoJaEstejaCadastrado() {
        Usuario gleice = new Usuario("Gleice", "gleice@hotmail.com", "123");
        List<Usuario> listaUsuariosRetornados = new ArrayList<>();

        listaUsuariosRetornados.add(gleice);

        Mockito.when(usuarioRepository.findByEmail("gleice@hotmail.com"))
            .thenReturn(listaUsuariosRetornados);

        usuarioCadastroService.salvar(gleice);
    }

}

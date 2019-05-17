package com.gleice.apilogin.service;

import com.gleice.apilogin.Exception.ExistingEmailException;
import com.gleice.apilogin.Exception.UserNotFoundException;
import com.gleice.apilogin.model.Usuario;
import com.gleice.apilogin.repository.UsuarioRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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

    @Test(expected = UserNotFoundException.class)
    public void deveRetornarExcecaoCasoUsuarioNaoExista(){
        Usuario gleice = new Usuario("Gleice", "gleice@hotmail.com", "123");
        List<Usuario> listaUsuariosRetornados = new ArrayList<>();

        Mockito.when(usuarioRepository.findByEmail("gleicedois@hotmail.com"))
                .thenReturn(listaUsuariosRetornados);

        usuarioCadastroService.retornaUsuarioPorEmail("gleicedois@hotmail.com");
    }

    @Test
    public void deveRetornarUsuarioAtravesDoEmail(){
        Usuario gleice = new Usuario("Gleice", "gleicedois@hotmail.com", "123");
        List<Usuario> listaUsuariosRetornados = new ArrayList<>();

        listaUsuariosRetornados.add(gleice);

        Mockito.when(usuarioRepository.findByEmail("gleicedois@hotmail.com"))
                .thenReturn(listaUsuariosRetornados);

        Assert.assertEquals(gleice, usuarioCadastroService.retornaUsuarioPorEmail("gleicedois@hotmail.com"));
    }

}

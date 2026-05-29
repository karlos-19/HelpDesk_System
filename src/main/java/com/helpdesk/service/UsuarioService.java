package com.helpdesk.service;

import com.helpdesk.model.Usuario;
import com.helpdesk.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    public Usuario criarUsuario(Usuario usuario) {
      String senhaCriptografada = bCryptPasswordEncoder.encode(usuario.getSenha());
      usuario.setSenha(senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscaPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleterUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


}

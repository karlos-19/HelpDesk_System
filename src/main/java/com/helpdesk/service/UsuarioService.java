package com.helpdesk.service;

import com.helpdesk.dto.UsuarioDTO;
import com.helpdesk.model.Usuario;
import com.helpdesk.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UsuarioDTO criarUsuario(Usuario usuario) {
        String senhaCriptografada = bCryptPasswordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        Usuario salvo = usuarioRepository.save(usuario);
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(salvo.getNome());
        dto.setEmail(salvo.getEmail());
        dto.setSetor(salvo.getSetor());
        dto.setCargo(salvo.getCargo());
        dto.setRole(salvo.getRole());
        return dto;


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

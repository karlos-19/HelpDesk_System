package com.helpdesk.controller;

import com.helpdesk.dto.UsuarioDTO;
import com.helpdesk.model.Usuario;
import com.helpdesk.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscaPorId(@PathVariable Long id) {
        return usuarioService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }

    @PostMapping
    public UsuarioDTO criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleterUsuario(@PathVariable Long id) {
        usuarioService.deleterUsuario(id);
    }


}

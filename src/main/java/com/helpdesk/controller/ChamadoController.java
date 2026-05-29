package com.helpdesk.controller;

import com.helpdesk.model.Chamado;
import com.helpdesk.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    public Chamado criarChamado(@RequestBody Chamado chamado) {
        return chamadoService.criarChamado(chamado);
    }

    @GetMapping
    public List<Chamado> listarChamado() {
        return chamadoService.listarChamado();
    }

    @GetMapping("/{id}")
    public Optional<Chamado> buscaPorId(@PathVariable Long id) {
        return chamadoService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    public Chamado atualizarUsuario(@PathVariable Long id, @RequestBody Chamado chamado) {
        return chamadoService.atualizarChamado(id, chamado);
    }

    @DeleteMapping("/{id}")
    public void deleterChamado(@PathVariable Long id) {
        chamadoService.deleterChamado(id);
    }


}

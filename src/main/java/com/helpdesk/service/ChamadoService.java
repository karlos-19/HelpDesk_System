package com.helpdesk.service;

import com.helpdesk.model.Chamado;
import com.helpdesk.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;


    public Chamado criarChamado(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }

    public List<Chamado> listarChamado() {
        return chamadoRepository.findAll();
    }

    public Optional<Chamado> buscaPorId(Long id) {
        return chamadoRepository.findById(id);
    }

    public Chamado atualizarChamado(Long id, Chamado chamado) {
        return chamadoRepository.save(chamado);
    }

    public void deleterChamado(Long id) {
        chamadoRepository.deleteById(id);
    }


}

package com.helpdesk.model;

import com.helpdesk.enums.Status;
import com.helpdesk.enums.Urgencia;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "chamados")
@Data
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    @ManyToOne
    private Usuario tecnico;

    @Column(nullable = false)
    private String tituloProblema;

    @Column(nullable = false)
    private String descricaoProblema;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Urgencia urgencia;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;



}

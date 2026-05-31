package com.helpdesk.dto;

import com.helpdesk.enums.Role;
import lombok.Data;

@Data
public class UsuarioDTO {
    private String nome;
    private String email;
    private String cargo;
    private Role role;
    private String setor;
}

package com.project.app.rest.Application.Models;

import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FuncionarioDTO {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    @NotEmpty(message = "O campo não pode ser nulo")
    public String nome;

    @NotEmpty(message = "O campo não pode ser nulo")
    public String foto;

    @NotNull(message = "O campo não pode ser nulo")
    public long rg;

    @NotNull(message = "O campo não pode ser nulo")
    public int id_departamento;

}

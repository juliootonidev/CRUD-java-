package com.project.app.rest.Application.Models;

import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;

public class FuncionarioDTO {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    public String nome;

    public String foto;

    public long rg;

    public int id_departamento;

}

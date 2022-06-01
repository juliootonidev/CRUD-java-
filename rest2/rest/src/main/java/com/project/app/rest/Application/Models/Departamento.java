package com.project.app.rest.Application.Models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Departamento {

    public Departamento() {

    }

    public Departamento(String Nome, String Sigla){
        this.nome = Nome;
        this.sigla = Sigla;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    @NotEmpty(message = "O campo não pode ser nulo")
    @javax.validation.constraints.NotNull(message = "O campo não pode ser nulo")
    private String nome;

    @NotEmpty(message = "O campo não pode ser nulo")
    @NotNull(message = "O campo não pode ser nulo")
    private String sigla;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @OneToMany(
            mappedBy = "departamento",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void setFuncionarios(List<Funcionario> funcs){
        this.funcionarios = funcs;
    }
}

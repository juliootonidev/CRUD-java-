package com.project.app.rest.Application.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Departamento {

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;


    private String nome;


    private String sigla;

    @OneToMany(
            mappedBy = "departamento",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Funcionario> funcionarios = new ArrayList<>();

    public Departamento(String Nome, String Sigla){
        this.nome = Nome;
        this.sigla = Sigla;
    }

    public void setFuncionarios(List<Funcionario> funcs){
        this.funcionarios = funcs;
    }

    public Departamento() {

    }


}

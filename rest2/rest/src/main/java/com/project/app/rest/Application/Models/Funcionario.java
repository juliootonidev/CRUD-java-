package com.project.app.rest.Application.Models;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Funcionario {

    public Funcionario() {

    }

    public Funcionario (String nome, String Foto, long Rg, Departamento departamento) {
        this.nome = nome;
        this.foto = Foto;
        this.rg = Rg;
        this.departamento = departamento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    @Column
    public String nome;

    @Column
    public String foto;

    @Column
    public long rg;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }
}

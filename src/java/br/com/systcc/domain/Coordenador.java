package br.com.systcc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "matricula")
@NamedQueries({
    @NamedQuery(name = "Coordenador.listar", query = "SELECT coordenador FROM Coordenador coordenador"),
    @NamedQuery(name = "Coordenador.buscarPorMatricula", query = "SELECT coordenador FROM Coordenador coordenador WHERE coordenador.matricula = :matricula")
})
public class Coordenador extends Usuario {
    
    @Column(nullable = false, length = 120)
    private String formacao_academica;
    
    public String getFormacao_academica() {
        return formacao_academica;
    }

    public void setFormacao_academica(String formacao_academica) {
        this.formacao_academica = formacao_academica;
    }
    
    public Coordenador(String nome, String cpf, String login, String senha, String nivelUsuario, String formacao_acaemica){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setLogin(login);
        super.setSenha(senha);
        super.setNivelUsuario(nivelUsuario);
        this.formacao_academica = formacao_academica;
    }
    
    public Coordenador() {
    }
    
    @Override
    public String toString() {
        return "[" + super.getMatricula() + "] Nome: " + super.getNome() + " :: " + " Formado em "+ getFormacao_academica();
    }    
    
    
}

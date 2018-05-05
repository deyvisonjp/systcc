package br.com.systcc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn (name = "matricula")
@NamedQueries({
    @NamedQuery(name = "Orientador.listar", query = "SELECT orientador FROM Orientador orientador"),
        @NamedQuery(name = "Orientador.logar", query = "SELECT orientador FROM Orientador orientador WHERE orientador.login = :login AND orientador.senha = :senha "),
    @NamedQuery(name = "Orientador.buscarPorMatricula", query = "SELECT orientador FROM Orientador orientador WHERE orientador.matricula = :matricula")
})
public class Orientador extends Usuario{
    
    @Column(name = "formAcademica", length = 120, nullable = false)
    private String formAcademica;
    
    @Column(name = "areaAtuacao", length = 50, nullable = false)
    private String areaAtuacao;
    
    public Orientador(String nome, String cpf, String login, String senha, String nivelUsuario, String areaAtuacao, String formAcademica){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setLogin(login);
        super.setSenha(senha);
        super.setNivelUsuario(nivelUsuario);
        this.areaAtuacao = areaAtuacao;
        this.formAcademica = formAcademica;
    }
    
    public Orientador() {
    }
    
    public String getFormAcademica() {
        return formAcademica;
    }

    public void setFormAcademica(String formAcademica) {
        this.formAcademica = formAcademica;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    
     @Override
    public String toString() {
        return "[" + super.getMatricula() + "] Nome: " + super.getNome() + " :: " + " Atuação: "+ getAreaAtuacao();
    }    
    
}

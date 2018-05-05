package br.com.systcc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@PrimaryKeyJoinColumn(name = "matricula")
@NamedQueries({
    @NamedQuery(name = "Aluno.listar", query = "SELECT aluno FROM Aluno aluno"),
    @NamedQuery(name = "Aluno.buscarPorMatricula", query = "SELECT aluno FROM Aluno aluno WHERE aluno.matricula = :matricula"),
    @NamedQuery(name = "Aluno.logar", query = "SELECT aluno FROM Aluno aluno WHERE aluno.login = :login AND aluno.senha = :senha")
})

public class Aluno extends Usuario {

    @NotEmpty(message = "O Campo curso é obrigatório")
    @Column (name = "curso", length = 30, nullable = false)
    private String curso;
    
    @Column (length = 30, nullable = false)
    private String polo;
    
    @ManyToOne (fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL )
    @JoinColumn (name = "idTcc_aluno", referencedColumnName = "id_tcc")
    private Tcc tcc;

    public Aluno(String nome, String cpf, String login, String senha, String nivelUsuario, String curso, String polo ){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setLogin(login);
        super.setSenha(senha);
        super.setNivelUsuario(nivelUsuario);
        this.curso = curso;
        this.polo = polo;
    }
    
    public Aluno() {
    }
 
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPolo() {
        return polo;
    }

    public void setPolo(String polo) {
        this.polo = polo;
    }

    public Tcc getTcc() {
        return tcc;
    }

    public void setTcc(Tcc tcc) {
        this.tcc = tcc;
    }

    

    @Override
    public String toString() {
        return "[" + super.getMatricula() + "] Nome: " + super.getNome() + " :: " + curso + " :: polo: " + polo + " :: tcc=" + tcc;
    }    
    
}

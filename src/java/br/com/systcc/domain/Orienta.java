package br.com.systcc.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Orienta.listar", query = "SELECT orienta FROM Orienta orienta"),
    @NamedQuery(name = "Orienta.buscarPorCodigo", query = "SELECT orienta FROM Orienta orienta WHERE orienta.id_orienta = :id_orienta")
})
    public class Orienta {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id_orienta;
    
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Orientador.class)
    @JoinColumn(name = "orientador_matricula", referencedColumnName = "matricula")
    private Orientador orientador;
    //private List<Orientador> orientador;
    
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Aluno.class)
    @JoinColumn(name = "aluno_matricula", referencedColumnName = "matricula")
    private Aluno aluno;
    //private List<Aluno> aluno;

    public Long getId_orienta() {
        return id_orienta;
    }

    public void setId_orienta(Long id_orienta) {
        this.id_orienta = id_orienta;
    }
    
    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
    
    /*
    public List<Orientador> getOrientador() {
        return orientador;
    }

    public void setOrientador(List<Orientador> orientador) {
        this.orientador = orientador;
    }

    public List<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }
    */

    @Override
    public String toString() {
        return "Orienta{" + " id_orienta = " + id_orienta + " :: orientador = " + orientador + " :: aluno = " + aluno + '}';
    }
    
}

package br.com.systcc.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "avalia")
@NamedQueries({
    @NamedQuery(name = "Avalia.listar", query = "SELECT avalia FROM Avalia avalia"),
    @NamedQuery(name = "Avalia.buscarPorId", query = "SELECT avalia FROM Avalia avalia WHERE avalia.id_avalia = :id_avalia")
})
public class Avalia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_avalia;
    
    @Column(nullable = false, precision = 4, scale = 2)
    private double nota;
    
    @Column(nullable = false, length = 1000)
    private String observacao;

    
    @ManyToOne (fetch = FetchType.EAGER, targetEntity = Avaliador.class)
    @JoinColumn(name = "avalia_avaliador", referencedColumnName = "matricula")
    private Avaliador avaliador;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Orientador.class)
    @JoinColumn(name = "avalia_orientador", referencedColumnName = "matricula")
    private Orientador orientador;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Aluno.class)
    @JoinColumn(name = "avalia_aluno", referencedColumnName = "matricula")
    private Aluno aluno;
    
    public Long getId_avalia() {
        return id_avalia;
    }

    public void setId_avalia(Long id_avalia) {
        this.id_avalia = id_avalia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avalia other = (Avalia) obj;
        if (!Objects.equals(this.id_avalia, other.id_avalia)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Avaliação [" + id_avalia + "] -> nota: " + nota + " - observacao: " + observacao + 
                "\n Aluno avaliado: " + aluno.getNome() + " - Avaliador: " + avaliador.getNome() + " - Orientador " + orientador;
    }
 

}

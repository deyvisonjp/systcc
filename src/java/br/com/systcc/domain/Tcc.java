package br.com.systcc.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Deyvison and Maurilio
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "Tcc.listar", query = "SELECT tcc FROM Tcc tcc"),
    @NamedQuery(name = "Tcc.buscarPorId", query = "SELECT tcc FROM Tcc tcc WHERE tcc.id_tcc = :id_tcc")
})

public class Tcc {    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id_tcc;
    
    @Column (length = 120, nullable = false)
    private String tema;

    @Column (length = 400, nullable = false)
    private String descricao;

    @Column (name = "nota_final", nullable = true)
    private double nota;
    
    @Column (name = "data_inicio", nullable = false)
    @Temporal (value = TemporalType.DATE)
    private Date data;
    
    @OneToMany(mappedBy = "tcc", cascade = CascadeType.ALL, targetEntity = Etapa.class, fetch = FetchType.EAGER)
    private List<Etapa> etapas;
    
    public Long getId_tcc() {
        return id_tcc;
    }

    public void setId_tcc(Long id_tcc) {
        this.id_tcc = id_tcc;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id_tcc);
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
        final Tcc other = (Tcc) obj;
        if (!Objects.equals(this.id_tcc, other.id_tcc)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString(){
        return "TCC nº [" + getId_tcc() + "] :: Tema: " + getTema() + " :: Data: " + getData();
    }
}

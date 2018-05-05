package br.com.systcc.domain;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "etapa")
@NamedQueries({
    @NamedQuery(name = "Etapa.listar", query = "SELECT etapa FROM Etapa etapa"),
    @NamedQuery(name = "Etapa.buscarPorId", query = "SELECT etapa FROM Etapa etapa WHERE etapa.id_etapa = :id_etapa")
})
public class Etapa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_etapa;
    
    @Column(nullable = false)
    private int etapa_num;
    
    @Column (nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Date dataLimEtapa;
    
    @Column(nullable = false)
    private boolean cumEtapa;
    
    @Column(nullable = false, precision = 4, scale = 2)
    private double notaEtapa;
    
    @Column(nullable = true)
    private String observacao;

    @ManyToOne(fetch = FetchType.EAGER) //https://www.ibm.com/developerworks/community/blogs/fd26864d-cb41-49cf-b719-d89c6b072893/entry/como_criar_relacionamento_onetomany_com_hibernate?lang=en
    @JoinColumn(name = "idTcc_etapa") 
    private Tcc tcc;
    
    
    public Long getId_etapa() {
        return id_etapa;
    }

    public void setId_etapa(Long id_etapa) {
        this.id_etapa = id_etapa;
    }

    public int getEtapa_num() {
        return etapa_num;
    }

    public void setEtapa_num(int etapa_num) {
        this.etapa_num = etapa_num;
    }
    
    
    
    public Date getDataLimEtapa() {
        return dataLimEtapa;
    }

    public void setDataLimEtapa(Date dataLimEtapa) {
        this.dataLimEtapa = dataLimEtapa;
    }

    public boolean isCumEtapa() {
        return cumEtapa;
    }
    
    public void setCumEtapa(boolean cumEtapa) {
        this.cumEtapa = cumEtapa;
    }

    public double getNotaEtapa() {
        return notaEtapa;
    }

    public void setNotaEtapa(double notaEtapa) {
        this.notaEtapa = notaEtapa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Tcc getTcc() {
        return tcc;
    }

    public void setTcc(Tcc tcc) {
        this.tcc = tcc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id_etapa);
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
        final Etapa other = (Etapa) obj;
        if (!Objects.equals(this.id_etapa, other.id_etapa)) {
            return false;
        }
        return true;
    }

     
    
    @Override
    public String toString() {
        return "Etapa [" + id_etapa + "] -> Etapa: ||" + etapa_num + "|| " + " - Data Lim: " + dataLimEtapa + " - cumEtapa: " + cumEtapa + " : notaEtapa: " + notaEtapa + " \n observacao: " + observacao + "\n tcc=" + tcc + '}';
    }
    
    
    
}

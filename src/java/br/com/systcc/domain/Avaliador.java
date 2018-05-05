package br.com.systcc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "matricula")
@NamedQueries({
    @NamedQuery(name = "Avaliador.listar", query = "SELECT avaliador FROM Avaliador avaliador"),
    @NamedQuery(name = "Avaliador.buscarPorMatricula", query = "SELECT avaliador FROM Avaliador avaliador WHERE avaliador.matricula = :matricula")
})
public class Avaliador extends Usuario {
    
    @Column(length = 50, nullable = false)
    private String titulacao;
    
    @Column(length = 45, nullable = false)
    private String instituicao;
    
    @Column (length = 60, nullable = false)
    private String area;

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    @Override
    public String toString() {
        return "[" + super.getMatricula() + "] Nome: " + super.getNome() + " :: " + " Instituição: " + getInstituicao() + " :: Titulação: " + getTitulacao();
    }  
    
}

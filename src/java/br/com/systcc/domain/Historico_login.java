package br.com.systcc.domain;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Deyvison
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "Logado.listar", query= "SELECT hist_log FROM Historico_login hist_log"),
    @NamedQuery(name = "Logado.buscarPorId", query= "SELECT hist_log FROM Historico_login hist_log WHERE hist_log.id_login= :id_login")
})
public class Historico_login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_login;
    
    @Column (nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Date hora_entrada;
    
    @Column (nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Date hora_saida;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "histLogin_matricula", referencedColumnName = "matricula")
    private Usuario usuario; 

    public Long getId_login() {
        return id_login;
    }

    public void setId_login(Long id_login) {
        this.id_login = id_login;
    }

    public Date getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Date hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Date getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(Date hora_saida) {
        this.hora_saida = hora_saida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Historico login [" + id_login + "] :: hora entrada: " + hora_entrada + " :: hora_saida: " + hora_saida + " :: usuario: " + usuario.getNome();
    }
    
    
    
}

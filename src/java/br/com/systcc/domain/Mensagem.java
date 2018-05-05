package br.com.systcc.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({
    @NamedQuery(name = "Mensagem.listar", query = "SELECT mensagem FROM Mensagem mensagem"),
    @NamedQuery(name = "Mensagem.buscarPorId", query = "SELECT mensagem FROM Mensagem mensagem WHERE mensagem.id_mensagem= :id_mensagem")
})
public class Mensagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_mensagem;
    
    @Lob
    @Column (nullable = false)
    private String texto_mensagem;
    
    @Temporal (TemporalType.TIMESTAMP)
    @Column
    private Date data;
    
    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_remetente", referencedColumnName = "matricula")
    private Usuario usuario_remetente;
    
    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_destinatario", referencedColumnName = "matricula")
    private Usuario usuario_destinatario;

    public Long getId_mensagem() {
        return id_mensagem;
    }

    public void setId_mensagem(Long id_mensagem) {
        this.id_mensagem = id_mensagem;
    }

    public String getTexto_mensagem() {
        return texto_mensagem;
    }

    public void setTexto_mensagem(String texto_mensagem) {
        this.texto_mensagem = texto_mensagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario_remetente() {
        return usuario_remetente;
    }

    public void setUsuario_remetente(Usuario usuario_remetente) {
        this.usuario_remetente = usuario_remetente;
    }

    public Usuario getUsuario_destinatario() {
        return usuario_destinatario;
    }

    public void setUsuario_destinatario(Usuario usuario_destinatario) {
        this.usuario_destinatario = usuario_destinatario;
    }

    @Override
    public String toString() {
        return "Mensagem [" + id_mensagem + "] -> Texto: \n" + texto_mensagem + "\n Data: " + data + "\n Remetente: " + usuario_remetente.getNome() + " <-> Destinatario: " + usuario_destinatario.getNome();
    }
    
    
    
}

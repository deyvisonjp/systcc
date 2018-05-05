package br.com.systcc.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
/*@NamedQueries({
    @NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
    @NamedQuery(name = "Usuario.buscarPorMatricula", query = "SELECT usuario FROM Usuario usuario WHERE usuario.matricula =: matricula"),
    @NamedQuery(name = "Usuario.logar", query = "SELECT usuario FROM Usuario usuario WHERE usuario.login = :login AND usuario.senha = :senha")
})*/
public class Usuario implements Serializable{

    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long matricula;
   
   @NotEmpty(message = "O campo nome é obrigatório")
   @Size(min = 5, max = 80, message = "Tamanho inválido para o campo nome.")
   @Column(name="nome", length = 50, nullable = false)
   private String nome;
   
   @CPF (message = "O CPF informado é inválido!")
   @Column(name = "cpf", length = 14, nullable = false, unique = true)
   private String cpf;
   
   @Column(name = "login", length = 60, nullable = false, unique = true)
   private String login;
   
   @NotEmpty(message = "Campo senha não pode ser vazio!")
   @Size(min = 6, max = 8, message = "Sua senha deve conter 6 a 8 caracteres")
   @Column(name = "senha", length = 32, nullable = false)
   private String senha;
   
   
   @Column(name = "nivelUsuario", length = 40, nullable = false)
   private String nivelUsuario;   
   
    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(String nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.matricula);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
   
    
   
    
}

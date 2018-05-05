package br.com.systcc.dao;

import br.com.systcc.domain.Aluno;
import br.com.systcc.domain.Usuario;
import br.com.systcc.domain.Usuario;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {
    
    //SALVAR
    public void salvar(Usuario usuario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(usuario);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex; //Propagar o erro
        } finally {
            sessao.close();
        }
    }
    
    
    //LISTAR
    public List<Usuario> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> usuarios = null;
        try {
            Query consulta = sessao.getNamedQuery("Usuario.listar");
            usuarios = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return usuarios;
    }

    //BUSCAR P/ CODIGO
    public Usuario buscarPorUsuario(Long mat) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;
        try {
            Query consulta = sessao.getNamedQuery("Usuario.buscarPorMatricula");
            consulta.setLong("matricula", mat);
            usuario = (Usuario) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return usuario;
    }

    //EXCLUSÃO
    public void excluir(Usuario usuario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(usuario);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex; //Propagar o erro
        } finally {
            sessao.close();
        }
    }

    //EDIÇÃO
    public void editar(Usuario usuario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(usuario);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex; //Propagar o erro
        } finally {
            sessao.close();
        }
    }
    
    //LOGAR
    public Usuario Logar(String login, String senha) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;
        Usuario aluno = null;
        Usuario orientador = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Aluno.logar");
            Query consulta2 = sessao.getNamedQuery("Orientador.logar");
            consulta.setString("login", login);
            consulta2.setString("login", login);
            consulta.setString("senha", senha);
            consulta2.setString("senha", senha);
            
            aluno = (Usuario) consulta.uniqueResult();
            if(aluno != null){
                usuario = aluno;
            }else { 
                usuario = (Usuario) consulta2.uniqueResult();
            }
            
        } catch (RuntimeException ex) {
            throw ex;
        
        } finally {
            sessao.close();
        }
        
        return usuario;
    }

}

package br.com.systcc.dao;

import br.com.systcc.domain.Aluno;
import br.com.systcc.domain.Orientador;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrientadorDAO {
    //SALVAR
    public void salvar(Orientador orientador){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            sessao.save(orientador);
            transacao.commit();
        }catch (RuntimeException ex) {
            if (transacao != null){
                transacao.rollback();
            }
        }finally {
            sessao.close();
        }  
    }
    
    //LISTAR
    public List<Orientador> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Orientador> orientadores = null;
        try {
            Query consulta = sessao.getNamedQuery("Orientador.listar");
            orientadores = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return orientadores;
    }

    //BUSCAR P/ CODIGO
    public Orientador buscarPorMatricula(Long mat) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Orientador orientador = null;
        try {
            Query consulta = sessao.getNamedQuery("Orientador.buscarPorMatricula");
            consulta.setLong("matricula", mat);
            orientador = (Orientador) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return orientador;
    }

    //EXCLUSÃO
    public void excluir(Orientador orientador) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(orientador);
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
    public void editar(Orientador orientador) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(orientador);
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
    public Orientador Logar(String login, String senha) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Orientador orientador = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Orientador.logar");
            consulta.setString("login", login);
            consulta.setString("senha", senha);
            orientador = (Orientador) consulta.uniqueResult();
            
        } catch (RuntimeException ex) {
            throw ex;
        
        } finally {
            sessao.close();
        }
        
        return orientador;
    }

    
    
}

package br.com.systcc.dao;

import br.com.systcc.domain.Historico_login;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Historico_loginDAO {

        public void salvar(Historico_login login){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            sessao.save(login);
            transacao.commit();
        }catch (RuntimeException ex){
            if (transacao != null){
                transacao.rollback();
            }
        } finally {
            sessao.close();
        }
    }
    
    //LISTAR
    public List<Historico_login> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Historico_login> logins = null;
        try {
            Query consulta = sessao.getNamedQuery("Logado.listar");
            logins = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return logins;
    }

    //BUSCAR P/ CODIGO
    public Historico_login buscarPorId(Long id_login) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Historico_login login = null;
        try {
            Query consulta = sessao.getNamedQuery("Logado.buscarPorId");
            consulta.setLong("id_login", id_login);
            login = (Historico_login) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return login;
    }

    //EXCLUSÃO
    public void excluir(Historico_login login) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(login);
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
    public void editar(Historico_login login) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.update(login);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }
   
}

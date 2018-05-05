package br.com.systcc.dao;

import br.com.systcc.domain.Orienta;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrientaDAO {
    public void salvar(Orienta orienta){
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            sessao.save(orienta);
            transacao.commit();
        }catch (RuntimeException ex){
            if (transacao != null){
                transacao.rollback();
            }
            throw ex;
        } finally{
            sessao.close();
        }
    }
    
    //LISTAR
    public List<Orienta> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Orienta> orientas = null;
        try {
            Query consulta = sessao.getNamedQuery("Orienta.listar");
            orientas = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return orientas;
    }

    //BUSCAR P/ CODIGO
    public Orienta buscarPorOrienta(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Orienta orienta = null;
        try {
            Query consulta = sessao.getNamedQuery("Orienta.buscarPorCodigo");
            consulta.setLong("id_orienta", id);
            orienta = (Orienta) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return orienta;
    }

    //EXCLUSÃO
    public void excluir(Orienta orienta) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(orienta);
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
    public void editar(Orienta orienta) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(orienta);
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

    
}

package br.com.systcc.dao;

import br.com.systcc.domain.Tcc;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TccDAO {

    public void salvar(Tcc tcc) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(tcc);
            transacao.commit();
        } catch (Exception ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public void excluir(Tcc tcc) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(tcc);
            transacao.commit();
        } catch (Exception ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public List<Tcc> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Tcc> tccs = null;

        try {
            Query consulta = sessao.getNamedQuery("Tcc.listar");
            tccs = consulta.list();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }

        return tccs;
    }


    public Tcc buscarPorId(Long id_tcc) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Tcc tcc = null;
        try {
            Query consulta = sessao.getNamedQuery("Tcc.buscarPorId");
            consulta.setLong("id_tcc", id_tcc);
            tcc = (Tcc) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return tcc;
    }

    
    public void editar(Tcc tcc) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.update(tcc);
            transacao.commit();
        } catch (Exception ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

}

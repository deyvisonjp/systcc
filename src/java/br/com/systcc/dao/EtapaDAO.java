package br.com.systcc.dao;

import br.com.systcc.domain.Aluno;
import br.com.systcc.domain.Etapa;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EtapaDAO {

    //SALVAR
    public void salvar(Etapa etapa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(etapa);
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
    public List<Etapa> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Etapa> etapas = null;
        try {
            Query consulta = sessao.getNamedQuery("Etapa.listar");
            etapas = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return etapas;
    }

    //BUSCAR P/ CODIGO
    public Etapa buscarPorEtapa(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Etapa etapa = null;
        try {
            Query consulta = sessao.getNamedQuery("Etapa.buscarPorId");
            consulta.setLong("id_etapa", id);
            etapa = (Etapa) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return etapa;
    }

    //EXCLUSÃO
    public void excluir(Etapa etapa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(etapa);
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
    public void editar(Etapa etapa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(etapa);
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

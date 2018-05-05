package br.com.systcc.dao;

import br.com.systcc.domain.Avalia;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AvaliaDAO {
    public void salvar(Avalia avalia){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            sessao.save(avalia);
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
    public List<Avalia> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Avalia> avaliacoes = null;
        try {
            Query consulta = sessao.getNamedQuery("Avalia.listar");
            avaliacoes = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return avaliacoes;
    }

    //BUSCAR P/ CODIGO
    public Avalia buscarPorId(Long id_avalia) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Avalia avalia = null;
        try {
            Query consulta = sessao.getNamedQuery("Avalia.buscarPorId");
            consulta.setLong("id_avalia", id_avalia);
            avalia = (Avalia) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return avalia;
    }

    //EXCLUSÃO
    public void excluir(Avalia avalia) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(avalia);
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
    public void editar(Avalia avalia) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(avalia);
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

package br.com.systcc.dao;

import br.com.systcc.domain.Avaliador;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AvaliadorDAO {
    
    //SALVAR
    public void salvar(Avaliador avaliador){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            sessao.save(avaliador);
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
    public List<Avaliador> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Avaliador> avaliadores = null;
        try {
            Query consulta = sessao.getNamedQuery("Avaliador.listar");
            avaliadores = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return avaliadores;
    }

    //BUSCAR P/ CODIGO
    public Avaliador buscarPorMatricula(Long mat) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Avaliador avaliador = null;
        try {
            Query consulta = sessao.getNamedQuery("Avaliador.buscarPorMatricula");
            consulta.setLong("matricula", mat);
            avaliador = (Avaliador) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return avaliador;
    }

    //EXCLUSÃO
    public void excluir(Avaliador avaliador) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(avaliador);
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
    public void editar(Avaliador avaliador) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(avaliador);
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

package br.com.systcc.dao;

import br.com.systcc.domain.Coordenador;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Deyvison
 */

public class CoordenadorDAO {
        //SALVAR
    public void salvar(Coordenador coordenador) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(coordenador);
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
    public List<Coordenador> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Coordenador> coordenadors = null;
        try {
            Query consulta = sessao.getNamedQuery("Coordenador.listar");
            coordenadors = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return coordenadors;
    }

    //BUSCAR P/ CODIGO
    public Coordenador buscarPorCoordenador(Long mat) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Coordenador coordenador = null;
        try {
            Query consulta = sessao.getNamedQuery("Coordenador.buscarPorMatricula");
            consulta.setLong("matricula", mat);
            coordenador = (Coordenador) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return coordenador;
    }

    //EXCLUSÃO
    public void excluir(Coordenador coordenador) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(coordenador);
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
    public void editar(Coordenador coordenador) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(coordenador);
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

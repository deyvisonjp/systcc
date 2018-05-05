package br.com.systcc.dao;

import br.com.systcc.domain.Aluno;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AlunoDAO {

    //SALVAR
    public void salvar(Aluno aluno) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(aluno);
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
    public List<Aluno> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Aluno> alunos = null;
        try {
            Query consulta = sessao.getNamedQuery("Aluno.listar");
            alunos = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return alunos;
    }

    //BUSCAR P/ CODIGO
    public Aluno buscarPorAluno(Long mat) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Aluno aluno = null;
        try {
            Query consulta = sessao.getNamedQuery("Aluno.buscarPorMatricula");
            consulta.setLong("matricula", mat);
            aluno = (Aluno) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return aluno;
    }

    //EXCLUSÃO
    public void excluir(Aluno aluno) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(aluno);
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
    public void editar(Aluno aluno) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(aluno);
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
    public Aluno Logar(String login, String senha) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Aluno aluno = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Aluno.logar");
            consulta.setString("login", login);
            consulta.setString("senha", senha);
            aluno = (Aluno) consulta.uniqueResult();
            
        } catch (RuntimeException ex) {
            throw ex;
        
        } finally {
            sessao.close();
        }
        
        return aluno;
    }

}

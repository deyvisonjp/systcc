package br.com.systcc.dao;

import br.com.systcc.domain.Mensagem;
import br.com.systcc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MensagemDAO {

    public void salvar(Mensagem mensagem){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            sessao.save(mensagem);
            transacao.commit();
        }catch (RuntimeException ex){
            if (transacao != null){
                transacao.rollback();
            }
            throw ex;
        }finally {
            sessao.close();
        }
    }
    
    public void excluir(Mensagem mensagem){
         Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            sessao.delete(mensagem);
            transacao.commit();
        }catch (RuntimeException ex){
            if (transacao != null){
                transacao.rollback();
            }
            throw ex;
        }finally {
            sessao.close();
        }
    }
    
    public List<Mensagem> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Mensagem> mensagens = null;
        try {
            Query consulta = sessao.getNamedQuery("Mensagem.listar");
            mensagens = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return mensagens;
    }
    
    public Mensagem buscarPorMensagemId(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Mensagem mensagem = null;
        try {
            Query consulta = sessao.getNamedQuery("Mensagem.buscarPorId");
            consulta.setLong("id_mensagem", id);
            mensagem = (Mensagem) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return mensagem;
    }
    
    public void editar(Mensagem mensagem) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        // Partindo da ideia que a tela obrigará o usuário a preencher todos os dados
        try {
            transacao = sessao.beginTransaction();
            sessao.update(mensagem);
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

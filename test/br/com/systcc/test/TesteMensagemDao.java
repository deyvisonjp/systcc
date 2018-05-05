package br.com.systcc.test;

import br.com.systcc.dao.MensagemDAO;
import br.com.systcc.domain.Mensagem;
import br.com.systcc.domain.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TesteMensagemDao {
    
    @Test
    @Ignore
    public void salvar(){
        Usuario user1 = new Usuario();
        Usuario user2 = new Usuario();
        user1.setMatricula(1L);
        user2.setMatricula(3L);
        
        Mensagem msg = new Mensagem();
        msg.setData(new Date());
        msg.setTexto_mensagem("Mais um cliente satisfeito");
        msg.setUsuario_destinatario(user2);
        msg.setUsuario_remetente(user1);
        
        MensagemDAO dao = new MensagemDAO();
        dao.salvar(msg);
    }
    
    @Test
    @Ignore
    public void exluir(){
        Mensagem msg = new Mensagem();
        MensagemDAO dao = new MensagemDAO();
        
        msg.setId_mensagem(2L);
        dao.excluir(msg);
    }
    
    @Test
    public void Listar(){
        List<Mensagem> mensagens = new ArrayList<>();
        MensagemDAO dao = new MensagemDAO();
        
        mensagens = dao.listar();
        for(Mensagem msg : mensagens){
            System.out.println(msg);
        }
    }
    
    @Test
    @Ignore
    public void BuscarporId(){
        Mensagem msg = new Mensagem();
        MensagemDAO dao = new MensagemDAO();
        msg = dao.buscarPorMensagemId(2L);
        System.out.println(msg);
    }
    
    @Test
    @Ignore
    public void Editar(){

    }
    
}

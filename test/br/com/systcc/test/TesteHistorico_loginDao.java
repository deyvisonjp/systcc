package br.com.systcc.test;

import br.com.systcc.dao.Historico_loginDAO;
import br.com.systcc.dao.UsuarioDAO;
import br.com.systcc.domain.Historico_login;
import br.com.systcc.domain.Usuario;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TesteHistorico_loginDao {
    
    @Test
    @Ignore
    public void salvar(){
        Usuario usuario = new Usuario();
        UsuarioDAO daoUsuario = new UsuarioDAO();
        //Obs. Duvida queanto ao get
        usuario.setMatricula(4L);
        
        Historico_login hl = new Historico_login();
        hl.setHora_entrada(new Date());
        hl.setHora_saida(new Date());
        hl.setUsuario(usuario);
        
        Historico_loginDAO dao = new Historico_loginDAO();
        dao.salvar(hl);
    }
    
    @Test
    @Ignore
    public void buscarPorId(){
        Historico_loginDAO dao = new Historico_loginDAO();
        Historico_login hl = dao.buscarPorId(3L);
            System.out.println(hl);
    }

    
    @Test
    @Ignore
    public void excluir(){
        Historico_loginDAO dao = new Historico_loginDAO();
        Historico_login login = dao.buscarPorId(3L);
        if(login != null){
            dao.excluir(login);
        }
    }

    
    @Test
    public void Listar(){
        Historico_loginDAO dao = new Historico_loginDAO();
        List<Historico_login> logins = dao.listar();
        
        for (Historico_login login : logins){
            System.out.println(login);
        }
    }
    
    @Test
    
    public void editar() throws ParseException{
        
        Usuario usuario = new Usuario();
        UsuarioDAO daoUsuario = new UsuarioDAO();
        //Obs. Duvida queanto ao get
        usuario.setMatricula(4L);
        
        
        Historico_login hl = new Historico_login();
        hl.setId_login(2L);
        hl.setHora_entrada(new Date());
        hl.setHora_saida(new Date());
        hl.setUsuario(usuario);
        
        Historico_loginDAO dao = new Historico_loginDAO();
        dao.editar(hl);
        
    }

    
}

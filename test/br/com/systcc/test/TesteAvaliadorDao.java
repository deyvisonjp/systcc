package br.com.systcc.test;

import br.com.systcc.dao.AvaliadorDAO;
import br.com.systcc.domain.Avaliador;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TesteAvaliadorDao {
    
    @Test
    @Ignore
    public void salvar(){
        Avaliador av = new Avaliador();
        av.setCpf("123.123.123-12");
        av.setLogin("Ava");
        av.setNivelUsuario("Avaliador");
        av.setNome("Ava");
        av.setSenha("123456");
        av.setArea("Programação");
        av.setInstituicao("UFF");
        av.setTitulacao("Mestre em TI");
        
        AvaliadorDAO dao = new AvaliadorDAO();
        dao.salvar(av);
    }

        
    @Test
    @Ignore
    public void listar(){
        AvaliadorDAO dao = new AvaliadorDAO();
        List<Avaliador> avaliadors = dao.listar();
        
        for (Avaliador avaliador : avaliadors){
            System.out.println(avaliador);
        }       
    }
    
    @Test
    @Ignore
    public void buscarPorMatricula(){
        AvaliadorDAO dao = new AvaliadorDAO();
        Avaliador or = dao.buscarPorMatricula(16L);
            System.out.println(or);
    }
    
    @Test
    @Ignore
    public void excluir(){
        AvaliadorDAO dao = new AvaliadorDAO();
        Avaliador ab = dao.buscarPorMatricula(7L);
        if(ab != null){
            dao.excluir(ab);
        }
    }
    
    @Test
    public void editar(){
        //Desta forma todos os campos deverão ser preenchidos
        Avaliador avaliador = new Avaliador();
        avaliador.setMatricula(16L);
        avaliador.setNome("Avaliador 1");
        avaliador.setCpf("151.222.171-11");
        avaliador.setLogin("Avaliador");
        avaliador.setNivelUsuario("Avaliador");
        avaliador.setSenha("5489");
        avaliador.setArea("Programação");
        avaliador.setInstituicao("UFF");
        avaliador.setTitulacao("Mestre em TI");
        AvaliadorDAO dao = new AvaliadorDAO();
        dao.editar(avaliador);
    }
}

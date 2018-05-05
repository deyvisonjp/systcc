package br.com.systcc.test;

import br.com.systcc.dao.CoordenadorDAO;
import br.com.systcc.domain.Coordenador;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TesteCoordenadorDao {
    
    @Test
    @Ignore
    public void salvar(){
        Coordenador c1 = new Coordenador();
        c1.setCpf("111.111.151-12");
        c1.setLogin("Administrador");
        c1.setNivelUsuario("Coordenador");
        c1.setNome("Administrador");
        c1.setSenha("123456");
        c1.setFormacao_academica("Bacharel em TI");
        
        Coordenador c2 = new Coordenador();
        c2.setCpf("123.456.879-56");
        c2.setLogin("coordenador 2");
        c2.setNivelUsuario("Coordenador");
        c2.setNome("Coordenador");
        c2.setSenha("123456");
        c2.setFormacao_academica("Tecnologo em Computação");
        
        CoordenadorDAO dao = new CoordenadorDAO();
        dao.salvar(c1);
        dao.salvar(c2);
    }

        
    @Test
    @Ignore
    public void listar(){
        CoordenadorDAO dao = new CoordenadorDAO();
        List<Coordenador> coordenadors = dao.listar();
        
        for (Coordenador coordenador : coordenadors){
            System.out.println(coordenador);
        }       
    }
    
    @Test
    @Ignore
    public void buscarPorMatricula(){
        CoordenadorDAO dao = new CoordenadorDAO();
        Coordenador co = dao.buscarPorCoordenador(13L);
            System.out.println(co);
    }
    
    @Test
    public void excluir(){
        CoordenadorDAO dao = new CoordenadorDAO();
        Coordenador ab = dao.buscarPorCoordenador(7L);
        if(ab != null){
            dao.excluir(ab);
        }
    }
    
    @Test
    @Ignore
    public void editar(){
        //Desta forma todos os campos deverão ser preenchidos
        Coordenador coordenador = new Coordenador();
        coordenador.setMatricula(13L);
        coordenador.setNome("coord");
        coordenador.setCpf("111.511.111-11");
        coordenador.setLogin("coord");
        coordenador.setNivelUsuario("Coordenador");
        coordenador.setSenha("123456");
        coordenador.setFormacao_academica("Bacharel em TI");
        CoordenadorDAO dao = new CoordenadorDAO();
        dao.editar(coordenador);
    }
    
}

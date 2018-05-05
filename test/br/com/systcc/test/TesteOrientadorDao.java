/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.systcc.test;

import br.com.systcc.dao.OrientadorDAO;
import br.com.systcc.domain.Orientador;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ContabilDP
 */
public class TesteOrientadorDao {
    
    @Test
    @Ignore
    public void salvar(){
        Orientador or = new Orientador();
        or.setCpf("272.856.330-62");
        or.setLogin("Rafael");
        or.setNivelUsuario("Orientador");
        or.setNome("Rafael");
        or.setSenha("123456");
        or.setAreaAtuacao("Analista");
        or.setFormAcademica("Tecnologia de Computação");
        
        OrientadorDAO dao = new OrientadorDAO();
        dao.salvar(or);
    }

    @Ignore
    @Test
    public void listar(){
        OrientadorDAO dao = new OrientadorDAO();
        List<Orientador> orientadors = dao.listar();
        
        for (Orientador orientador : orientadors){
            System.out.println(orientador);
        }       
    }
    
    @Test
    @Ignore
    public void buscarPorMatricula(){
        OrientadorDAO dao = new OrientadorDAO();
        Orientador or = dao.buscarPorMatricula(15L);
            System.out.println(or);
    }
    
    @Test
    @Ignore
    public void excluir(){
        OrientadorDAO dao = new OrientadorDAO();
        Orientador ab = dao.buscarPorMatricula(7L);
        if(ab != null){
            dao.excluir(ab);
        }
    }
    
    @Test
    @Ignore
    public void editar(){
        //Desta forma todos os campos deverão ser preenchidos
        Orientador orientador = new Orientador();
        orientador.setMatricula(15L);
        orientador.setNome("Rafael");
        orientador.setCpf("111.222.111-11");
        orientador.setLogin("Rafael");
        orientador.setNivelUsuario("Orientador");
        orientador.setSenha("123456");
        orientador.setAreaAtuacao("Analista");
        orientador.setFormAcademica("Tecnologia de Computação");
        OrientadorDAO dao = new OrientadorDAO();
        dao.editar(orientador);
    }
    
}

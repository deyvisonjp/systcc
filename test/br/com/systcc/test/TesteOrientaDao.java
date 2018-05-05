package br.com.systcc.test;

import br.com.systcc.dao.AlunoDAO;
import br.com.systcc.dao.OrientadorDAO;
import br.com.systcc.dao.OrientaDAO;
import br.com.systcc.domain.Aluno;
import br.com.systcc.domain.Orienta;
import br.com.systcc.domain.Orientador;
import java.text.ParseException;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;


public class TesteOrientaDao {
    
    @Test
    @Ignore
    public void salvar(){
        Aluno aluno = new Aluno();
        AlunoDAO daoAluno = new AlunoDAO();
        
        Orientador orientador = new Orientador();
        OrientadorDAO daoOrientador = new OrientadorDAO();
        
        aluno = daoAluno.buscarPorAluno(3L);
        orientador = daoOrientador.buscarPorMatricula(6L);
        
        Orienta orienta = new Orienta();
        orienta.setAluno(aluno);
        orienta.setOrientador(orientador);
        
        OrientaDAO dao = new OrientaDAO();
        dao.salvar(orienta);        
    }
    
    @Test
    public void buscarPorMatricula(){
        OrientaDAO dao = new OrientaDAO();
        Orienta or = dao.buscarPorOrienta(5L);
            System.out.println(or);
    }

    
    @Test
    @Ignore
    public void excluir(){
        OrientaDAO dao = new OrientaDAO();
        Orienta or = dao.buscarPorOrienta(2L);
        if(or != null){
            dao.excluir(or);
        }
    }

    
    @Test
    @Ignore
    public void listar(){
        OrientaDAO dao = new OrientaDAO();
        List<Orienta> orientacoes = dao.listar();
        
        for (Orienta orienta : orientacoes){
            System.out.println(orienta);
        }
        
    }
    
    
    @Test
    @Ignore
    public void editar() throws ParseException{
        Orienta orienta1 = new Orienta();
        
        Aluno aluno = new Aluno();
        AlunoDAO daoAluno = new AlunoDAO();
        aluno = daoAluno.buscarPorAluno(3L);
        Orientador orientador = new Orientador();
        OrientadorDAO daoOrientador = new OrientadorDAO();
        orientador = daoOrientador.buscarPorMatricula(6L);
        
        orienta1.setId_orienta(2L);
        orienta1.setAluno(aluno);
        orienta1.setOrientador(orientador);
        
        OrientaDAO dao = new OrientaDAO();
        dao.editar(orienta1);
    }

    
}

package br.com.systcc.test;

import br.com.systcc.dao.AlunoDAO;
import br.com.systcc.dao.AvaliaDAO;
import br.com.systcc.dao.AvaliadorDAO;
import br.com.systcc.dao.OrientadorDAO;
import br.com.systcc.domain.Aluno;
import br.com.systcc.domain.Avalia;
import br.com.systcc.domain.Avaliador;
import br.com.systcc.domain.Orientador;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TesteAvaliaDao {
    
    @Test
    public void salvar(){
        Aluno aluno = new Aluno();
        AlunoDAO daoAluno = new AlunoDAO();
        aluno = daoAluno.buscarPorAluno(21L);
        //aluno.add(daoAluno.buscarPorAluno(21L));   
        
        
        Orientador ori = new Orientador();
        OrientadorDAO daoOri = new OrientadorDAO();
        ori = daoOri.buscarPorMatricula(15L);
        
        Avaliador ava = new Avaliador();
        AvaliadorDAO daoAva = new AvaliadorDAO();
        ava = daoAva.buscarPorMatricula(16L);

        Avalia avalia = new Avalia();
        avalia.setNota(8.2);
        avalia.setObservacao("hjdfhkçskhd sdah dfkds hf kçdsçhkhd khçdfskçhds fdskh fdskhldsal");
        avalia.setAluno(aluno);
        avalia.setOrientador(ori);
        avalia.setAvaliador(ava);
        
        AvaliaDAO dao = new AvaliaDAO();
        dao.salvar(avalia);
    }
    
    @Test
    public void listar(){
        AvaliaDAO dao = new AvaliaDAO();
        List<Avalia> avas = dao.listar();
        
        for(Avalia ava: avas){
            System.out.println(ava);
        }
    }
    
    @Test
    @Ignore
    public void buscarPorId(){
        AvaliaDAO dao = new AvaliaDAO();
        Avalia a1 = dao.buscarPorId(2L);
        
        System.out.println(a1);
    }
    
    @Test
    @Ignore
    public void excluir(){
        AvaliaDAO dao = new AvaliaDAO();
        Avalia ab = dao.buscarPorId(1L);
        if(ab != null){
            dao.excluir(ab);
        }
    }
    
    @Test
    @Ignore
    public void editar(){
        Avalia avalia = new Avalia();
        avalia.setId_avalia(2L);
        avalia.setNota(9.5);
        avalia.setObservacao("Sistema Funcional, ótima interface!");
        
        AvaliaDAO dao = new AvaliaDAO();
        dao.editar(avalia);
    }
}

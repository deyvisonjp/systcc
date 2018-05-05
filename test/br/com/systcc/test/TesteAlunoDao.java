package br.com.systcc.test;

import br.com.systcc.dao.AlunoDAO;
import br.com.systcc.dao.TccDAO;
import br.com.systcc.domain.Aluno;
import br.com.systcc.domain.Tcc;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TesteAlunoDao {
    
    @Test
    @Ignore
    public void salvar(){
        Aluno a1 = new Aluno();
        //TccDAO daoTcc = new TccDAO();
        //Tcc tcc = daoTcc.buscarPorId(1L);
        a1.setCpf("181.198.811-11");
        a1.setLogin("Thanos");
        a1.setNivelUsuario("Aluno");
        a1.setNome("Thanos");
        a1.setSenha("XYZ");
        a1.setCurso("TSC");
        a1.setPolo("Itaperuna");
        //a1.setTcc(tcc);
        /*
        
        Aluno a2 = new Aluno();
        a1.setCpf("222.222.222-22");
        a1.setLogin("ciclano@");
        a1.setNivelUsuario("Aluno");
        a1.setNome("Ciclano");
        a1.setSenha("123456");
        a1.setCurso("TSC");
        a1.setPolo("Volta Redonda");
        a1.setMatricula(Long.MAX_VALUE);
        */
        AlunoDAO dao = new AlunoDAO();
        dao.salvar(a1);
        //dao.salvar(a2);
    }
    
    @Test
    @Ignore
    public void salvar2(){
        Aluno a3 = new Aluno("Deyvison", "111.222.333-45", "deyvison", "123", "Aluno", "Tecnologia", "Itaperuna");
        AlunoDAO dao = new AlunoDAO();
        dao.salvar(a3);
    }
        
    @Test
    @Ignore
    public void listar(){
        AlunoDAO dao = new AlunoDAO();
        List<Aluno> alunos = dao.listar();
        
        for (Aluno aluno : alunos){
            System.out.println(aluno);
        }       
    }
    
    @Test
    @Ignore
    public void buscarPorCodigo(){
        AlunoDAO dao = new AlunoDAO();
        Aluno b1 = dao.buscarPorAluno(1L);
        
        System.out.println(b1);
    }
    
    @Test
    @Ignore
    public void excluir(){
        AlunoDAO dao = new AlunoDAO();
        Aluno ab = dao.buscarPorAluno(2L);
        if(ab != null){
            dao.excluir(ab);
        }
    }
    
    @Test
    @Ignore
    public void editar(){
        //Desta forma todos os campos deverão ser preenchidos
        Aluno aluno = new Aluno();        
        aluno.setMatricula(5L);
        aluno.setNome("Jose");
        aluno.setCpf("111.181.879-11");
        aluno.setLogin("jose");
        aluno.setNivelUsuario("Aluno");
        aluno.setSenha("4567");
        aluno.setCurso("TSC");
        aluno.setPolo("Italva");
        
        TccDAO daoTcc = new TccDAO();
        Tcc tcc = daoTcc.buscarPorId(2L);
        aluno.setTcc(tcc);
        
        AlunoDAO dao = new AlunoDAO();
        dao.editar(aluno);
    }
    
    @Test
    public void logar(){
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = dao.Logar("suzana", "suzana");
        System.out.println("Aluno: " + aluno);
    }
    
}
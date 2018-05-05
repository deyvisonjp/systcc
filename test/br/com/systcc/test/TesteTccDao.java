package br.com.systcc.test;


import br.com.systcc.dao.TccDAO;
import br.com.systcc.domain.Tcc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TesteTccDao {
    
    @Test
    @Ignore
    //http://blog.alura.com.br/como-converter-string-para-date-em-java/
    public void salvar() throws ParseException{
        Tcc tcc1 = new Tcc();
        tcc1.setDescricao("Trabalho com foco em auxiliar no desenvolvimento de Trabalhos de Conclusão de Curso");
        tcc1.setTema("TCC TI");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("05/02/2018");
        tcc1.setData(data);
        
        TccDAO dao = new TccDAO();
        
        dao.salvar(tcc1);
    }
    
    @Test
    @Ignore
    public void excluir(){
        TccDAO dao = new TccDAO();
        Tcc te = dao.buscarPorId(3L);
        if(te != null){
            dao.excluir(te);
        }
    }
    
    @Test
    public void listar(){
        TccDAO dao = new TccDAO();
        List<Tcc> tccs = dao.listar();
        
        for (Tcc tcc : tccs){
            System.out.println(tcc);
        }
        
    }
    
    
    @Test
    @Ignore
    public void editar() throws ParseException{
        
        Tcc tcc1 = new Tcc();
        
        tcc1.setId_tcc(2L);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("15/02/2018");
        tcc1.setData(data);
        tcc1.setDescricao("Trabalho com foco em sistematizar o trabalho de Administração Publica");
        tcc1.setTema("TCC COMPUTAÇÃO ADM");
        
        TccDAO dao = new TccDAO();
        
        dao.editar(tcc1);
    }
    
}


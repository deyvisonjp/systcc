package br.com.systcc.test;

import br.com.systcc.dao.EtapaDAO;
import br.com.systcc.dao.TccDAO;
import br.com.systcc.domain.Etapa;
import br.com.systcc.domain.Tcc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TesteEtapaDao {
    
    @Test
    @Ignore
    public void salvar() throws ParseException{
        Tcc tcc = new Tcc();
        TccDAO daoTcc = new TccDAO();
        tcc = daoTcc.buscarPorId(1L);
        
        Etapa etapa1 = new Etapa();
        etapa1.setCumEtapa(true);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("20/03/2018");
        etapa1.setDataLimEtapa(data);
        etapa1.setNotaEtapa(8.0);
        etapa1.setObservacao("Ok.");
        etapa1.setTcc(tcc);
        
        EtapaDAO dao = new EtapaDAO();
        dao.salvar(etapa1);
    }
    
    @Test
    @Ignore
    public void buscarPorMatricula(){
        EtapaDAO dao = new EtapaDAO();
        Etapa et = dao.buscarPorEtapa(3L);
            System.out.println(et);
    }

    
    @Test
    @Ignore
    public void excluir(){
        EtapaDAO dao = new EtapaDAO();
        Etapa etp = dao.buscarPorEtapa(4L);
        if(etp != null){
            dao.excluir(etp);
        }
    }

    
    @Test
    public void listar(){
        EtapaDAO dao = new EtapaDAO();
        List<Etapa> etapas = dao.listar();
        
        for (Etapa etapa : etapas){
            System.out.println(etapa);
        }
        
    }
    
    
    @Test
    @Ignore
    public void editar() throws ParseException{
        
        Tcc tcc = new Tcc();
        TccDAO daoTcc = new TccDAO();
        tcc = daoTcc.buscarPorId(1L);
        
        Etapa etapa1 = new Etapa();
        etapa1.setId_etapa(2L);
        etapa1.setEtapa_num(1);
        etapa1.setCumEtapa(true);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("20/03/2018");
        etapa1.setDataLimEtapa(data);
        etapa1.setNotaEtapa(5.6);
        etapa1.setObservacao("Ok.");
        etapa1.setTcc(tcc);
        
        EtapaDAO dao = new EtapaDAO();
        dao.editar(etapa1);
        
    }


    
}

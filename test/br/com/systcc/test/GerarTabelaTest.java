package br.com.systcc.test;

import br.com.systcc.util.HibernateUtil;
import org.junit.Test;

public class GerarTabelaTest {
    @Test
    public void gerar(){
        HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();
    }
}

package br.com.systcc.main;

import br.com.systcc.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
                HibernateUtil.getSessionFactory().close();
	}
        

}

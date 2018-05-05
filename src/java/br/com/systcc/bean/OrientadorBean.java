package br.com.systcc.bean;


import br.com.systcc.dao.OrientadorDAO;
import br.com.systcc.domain.Orientador;
import br.com.systcc.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Deyvison
 */
@ManagedBean
@ViewScoped
public class OrientadorBean {

    //Criando ------------------------------------------------------------------
    private Orientador orientadorCad;

    public Orientador getOrientadorCad() {
        if (orientadorCad == null) {
            orientadorCad = new Orientador();
            orientadorCad.setNivelUsuario("Orientador");
        }

        return orientadorCad;
    }

    public void setOrientadorCad(Orientador orientador) {
        orientador = orientadorCad;
    }

    //CRIANDO UM SELECT --------------------------------------------------------
    private Orientador selectOrientador;

    public Orientador getSelectOrientador() {
        return selectOrientador;
    }

    public void setSelectOrientador(Orientador selectOrientador) {
        this.selectOrientador = selectOrientador;
    }

    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            OrientadorDAO dao = new OrientadorDAO();
            orientadorCad.setNivelUsuario("Orientador");
            dao.salvar(orientadorCad);
            FacesUtil.addMsgInfo("Orientador salvo com sucesso!");
            orientadorCad = new Orientador();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro ao salvar o orientador: " + ex.getMessage());
        }
    }

    //EXCLUIR ------------------------------------------------------------------
    public void excluir() {
        try {
            OrientadorDAO dao = new OrientadorDAO();
            dao.excluir(selectOrientador);
            FacesUtil.addMsgInfo("Orientador removido com sucesso!");
            selectOrientador = null;
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao remover o orientador: " + ex.getMessage());
        }
    }

    //EDITAR -------------------------------------------------------------------
    public void editar() {
        try {
            OrientadorDAO dao = new OrientadorDAO();
            dao.editar(selectOrientador);
            FacesUtil.addMsgInfo("Alteração realizada com sucesso!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro na alteração do orientador: " + ex.getMessage());
        }
    }

    //LISTAR Orientadores BEAN
    private List<Orientador> listaOrientador;
    private List<Orientador> listaOrientadorFiltro;

    public List<Orientador> getListaOrientador() {
        return listaOrientador;
    }

    public void setListaOrientador(List<Orientador> listaOrientador) {
        this.listaOrientador = listaOrientador;
    }

    public List<Orientador> getListaOrientadorFiltro() {
        return listaOrientadorFiltro;
    }

    public void setListaOrientadorFiltro(List<Orientador> listaOrientadorFiltro) {
        this.listaOrientadorFiltro = listaOrientadorFiltro;
    }

    public void carregar() {
        try {
            OrientadorDAO dao = new OrientadorDAO();
            listaOrientador = dao.listar();
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao listar os orientadores: " + ex.getMessage());
        }
    }

    /*
    public void carregarCadastro() {
        try {
            String valor = FacesUtil.getParam("orCod");
            if (valor != null) {
                Long mat = Long.parseLong(valor);
                AlunoDAO dao = new AlunoDAO();
                alunoCad = dao.buscarPorAluno(mat);
            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao carregar a  tabela: " + ex.getMessage());
        }
    }
     */
    
    /*
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg;
        msg = new FacesMessage("Aluno Selecionado", ((Aluno) event.getObject()).getMatricula().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    */

    public String listar() {
        return "OrientadorBD.xhtml?faces-redirect=true\"";
    }

}

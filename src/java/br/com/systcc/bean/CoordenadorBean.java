package br.com.systcc.bean;


import br.com.systcc.dao.CoordenadorDAO;
import br.com.systcc.domain.Coordenador;
import br.com.systcc.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Deyvison
 */
@ManagedBean
@ViewScoped
public class CoordenadorBean {

    //Criando ------------------------------------------------------------------
    private Coordenador coordenadorCad;

    public Coordenador getCoordenadorCad() {
        if (coordenadorCad == null) {
            coordenadorCad = new Coordenador();
            coordenadorCad.setNivelUsuario("Coordenador");
        }

        return coordenadorCad;
    }

    public void setCoordenadorCad(Coordenador coordenador) {
        coordenador = coordenadorCad;
    }

    //CRIANDO UM SELECT --------------------------------------------------------
    private Coordenador selectCoordenador;

    public Coordenador getSelectCoordenador() {
        return selectCoordenador;
    }

    public void setSelectCoordenador(Coordenador selectCoordenador) {
        this.selectCoordenador = selectCoordenador;
    }

    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            CoordenadorDAO dao = new CoordenadorDAO();
            coordenadorCad.setNivelUsuario("Coordenador");
            dao.salvar(coordenadorCad);
            FacesUtil.addMsgInfo("Coordenador salvo com sucesso!");
            coordenadorCad = new Coordenador();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro ao salvar o coordenador: " + ex.getMessage());
        }
    }

    //EXCLUIR ------------------------------------------------------------------
    public void excluir() {
        try {
            CoordenadorDAO dao = new CoordenadorDAO();
            dao.excluir(selectCoordenador);
            FacesUtil.addMsgInfo("Coordenador removido com sucesso!");
            selectCoordenador = null;
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao remover o coordenador: " + ex.getMessage());
        }
    }

    //EDITAR -------------------------------------------------------------------
    public void editar() {
        try {
            CoordenadorDAO dao = new CoordenadorDAO();
            dao.editar(selectCoordenador);
            FacesUtil.addMsgInfo("Alteração realizada com sucesso!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro na alteração do coordenador: " + ex.getMessage());
        }
    }

    //LISTAR Coordenadores BEAN
    private List<Coordenador> listaCoordenador;
    private List<Coordenador> listaCoordenadorFiltro;

    public List<Coordenador> getListaCoordenador() {
        return listaCoordenador;
    }

    public void setListaCoordenador(List<Coordenador> listaCoordenador) {
        this.listaCoordenador = listaCoordenador;
    }

    public List<Coordenador> getListaCoordenadorFiltro() {
        return listaCoordenadorFiltro;
    }

    public void setListaCoordenadorFiltro(List<Coordenador> listaCoordenadorFiltro) {
        this.listaCoordenadorFiltro = listaCoordenadorFiltro;
    }

    public void carregar() {
        try {
            CoordenadorDAO dao = new CoordenadorDAO();
            listaCoordenador = dao.listar();
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao listar os coordenadores: " + ex.getMessage());
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
        return "CoordenadorBD.xhtml?faces-redirect=true\"";
    }

}

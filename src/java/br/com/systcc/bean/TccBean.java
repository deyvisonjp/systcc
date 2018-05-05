package br.com.systcc.bean;


import br.com.systcc.dao.TccDAO;
import br.com.systcc.domain.Tcc;
import br.com.systcc.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Deyvison
 */
@ManagedBean
@ViewScoped
public class TccBean {

    //Criando ------------------------------------------------------------------
    private Tcc tccCad;

    public Tcc getTccCad() {
        if (tccCad == null) {
            tccCad = new Tcc();
        }

        return tccCad;
    }

    public void setTccCad(Tcc tcc) {
        tcc = tccCad;
    }

    //CRIANDO UM SELECT --------------------------------------------------------
    private Tcc selectTcc;

    public Tcc getSelectTcc() {
        return selectTcc;
    }

    public void setSelectTcc(Tcc selectTcc) {
        this.selectTcc = selectTcc;
    }

    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            TccDAO dao = new TccDAO();
            dao.salvar(tccCad);
            FacesUtil.addMsgInfo("Tcc salvo com sucesso!");
            tccCad = new Tcc();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro ao salvar o tcc: " + ex.getMessage());
        }
    }

    //EXCLUIR ------------------------------------------------------------------
    public void excluir() {
        try {
            TccDAO dao = new TccDAO();
            dao.excluir(selectTcc);
            FacesUtil.addMsgInfo("Tcc removido com sucesso!");
            selectTcc = null;
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao remover o tcc: " + ex.getMessage());
        }
    }

    //EDITAR -------------------------------------------------------------------
    public void editar() {
        try {
            TccDAO dao = new TccDAO();
            dao.editar(selectTcc);
            FacesUtil.addMsgInfo("Alteração realizada com sucesso!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro na alteração do tcc: " + ex.getMessage());
        }
    }

    //LISTAR Tcces BEAN
    private List<Tcc> listaTcc;
    private List<Tcc> listaTccFiltro;

    public List<Tcc> getListaTcc() {
        return listaTcc;
    }

    public void setListaTcc(List<Tcc> listaTcc) {
        this.listaTcc = listaTcc;
    }

    public List<Tcc> getListaTccFiltro() {
        return listaTccFiltro;
    }

    public void setListaTccFiltro(List<Tcc> listaTccFiltro) {
        this.listaTccFiltro = listaTccFiltro;
    }

    public void carregar() {
        try {
            TccDAO dao = new TccDAO();
            listaTcc = dao.listar();
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao listar os tcces: " + ex.getMessage());
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
        return "TccBD.xhtml?faces-redirect=true\"";
    }

}

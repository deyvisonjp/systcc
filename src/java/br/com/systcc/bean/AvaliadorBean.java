package br.com.systcc.bean;


import br.com.systcc.dao.AvaliadorDAO;
import br.com.systcc.domain.Avaliador;
import br.com.systcc.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Deyvison
 */
@ManagedBean
@ViewScoped
public class AvaliadorBean {

    //Criando ------------------------------------------------------------------
    private Avaliador avaliadorCad;

    public Avaliador getAvaliadorCad() {
        if (avaliadorCad == null) {
            avaliadorCad = new Avaliador();
            avaliadorCad.setNivelUsuario("Avaliador");
        }

        return avaliadorCad;
    }

    public void setAvaliadorCad(Avaliador avaliador) {
        avaliador = avaliadorCad;
    }

    //CRIANDO UM SELECT --------------------------------------------------------
    private Avaliador selectAvaliador;

    public Avaliador getSelectAvaliador() {
        return selectAvaliador;
    }

    public void setSelectAvaliador(Avaliador selectAvaliador) {
        this.selectAvaliador = selectAvaliador;
    }

    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            AvaliadorDAO dao = new AvaliadorDAO();
            avaliadorCad.setNivelUsuario("Avaliador");
            dao.salvar(avaliadorCad);
            FacesUtil.addMsgInfo("Avaliador salvo com sucesso!");
            avaliadorCad = new Avaliador();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro ao salvar o avaliador: " + ex.getMessage());
        }
    }

    //EXCLUIR ------------------------------------------------------------------
    public void excluir() {
        try {
            AvaliadorDAO dao = new AvaliadorDAO();
            dao.excluir(selectAvaliador);
            FacesUtil.addMsgInfo("Avaliador removido com sucesso!");
            selectAvaliador = null;
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao remover o avaliador: " + ex.getMessage());
        }
    }

    //EDITAR -------------------------------------------------------------------
    public void editar() {
        try {
            AvaliadorDAO dao = new AvaliadorDAO();
            dao.editar(selectAvaliador);
            FacesUtil.addMsgInfo("Alteração realizada com sucesso!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro na alteração do avaliador: " + ex.getMessage());
        }
    }

    //LISTAR Avaliadores BEAN
    private List<Avaliador> listaAvaliador;
    private List<Avaliador> listaAvaliadorFiltro;

    public List<Avaliador> getListaAvaliador() {
        return listaAvaliador;
    }

    public void setListaAvaliador(List<Avaliador> listaAvaliador) {
        this.listaAvaliador = listaAvaliador;
    }

    public List<Avaliador> getListaAvaliadorFiltro() {
        return listaAvaliadorFiltro;
    }

    public void setListaAvaliadorFiltro(List<Avaliador> listaAvaliadorFiltro) {
        this.listaAvaliadorFiltro = listaAvaliadorFiltro;
    }

    public void carregar() {
        try {
            AvaliadorDAO dao = new AvaliadorDAO();
            listaAvaliador = dao.listar();
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao listar os avaliadores: " + ex.getMessage());
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
        return "AvaliadorBD.xhtml?faces-redirect=true\"";
    }

}

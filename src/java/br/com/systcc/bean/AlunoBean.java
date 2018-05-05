package br.com.systcc.bean;

import br.com.systcc.dao.AlunoDAO;
import br.com.systcc.dao.TccDAO;
import br.com.systcc.domain.Aluno;
import br.com.systcc.domain.Tcc;
import br.com.systcc.util.FacesUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 * @author Deyvison
 */
@ManagedBean
@ViewScoped
public class AlunoBean {

    //Criando Aluno ------------------------------------------------------------
    private Aluno alunoCad;

    public Aluno getAlunoCad() {
        if (alunoCad == null) {
            alunoCad = new Aluno();
            alunoCad.setNivelUsuario("Aluno");
        }

        return alunoCad;
    }

    public void setAlunoCad(Aluno aluno) {
        aluno = alunoCad;
    }

    //CRIANDO UMA LISTA PARA BUSCAR DE TCC -------------------------------------
    public List<Tcc> listaTcc;

    public List<Tcc> getListaTcc() {
        return listaTcc;
    }

    public void setListaTcc(List<Tcc> listaTcc) {
        this.listaTcc = listaTcc;
    }

    //CRIANDO UM SELECT ALUNO --------------------------------------------------
    private Aluno selectAluno;

    public Aluno getSelectAluno() {
        return selectAluno;
    }

    public void setSelectAluno(Aluno selectAluno) {
        this.selectAluno = selectAluno;
    }

    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            AlunoDAO dao = new AlunoDAO();
            alunoCad.setNivelUsuario("Aluno");
            dao.salvar(alunoCad);
            FacesUtil.addMsgInfo("Aluno salvo com sucesso!");
            alunoCad = new Aluno();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro ao salvar o aluno: " + ex.getMessage());
        }
    }

    //EXCLUIR ------------------------------------------------------------------
    public void excluir() {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.excluir(selectAluno);
            FacesUtil.addMsgInfo("Aluno removido com sucesso!");
            selectAluno = null;
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao remover o aluno: " + ex.getMessage());
        }
    }

    //EDITAR -------------------------------------------------------------------
    public void editar() {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.editar(selectAluno);
            FacesUtil.addMsgInfo("O Aluno foi editado com sucesso!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro na alteração do aluno: " + ex.getMessage());
        }
    }

    //LISTAR ALUNOS BEAN
    private List<Aluno> listaAlunos;
    private List<Aluno> listaAlunosFiltro;

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunosFiltro(List<Aluno> listaAlunosFiltro) {
        this.listaAlunosFiltro = listaAlunosFiltro;
    }

    public List<Aluno> getListaAlunosFiltro() {
        return listaAlunosFiltro;
    }

    public void carregar() {
        try {
            AlunoDAO dao = new AlunoDAO();
            listaAlunos = dao.listar();

            TccDAO daoTcc = new TccDAO();
            listaTcc = daoTcc.listar();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao listar os alunos: " + ex.getMessage());
        }
    }

    public void carregarCadastro() {
        try {
            String valor = FacesUtil.getParam("alCod");
            if (valor != null) {
                Long mat = Long.parseLong(valor);
                AlunoDAO dao = new AlunoDAO();
                alunoCad = dao.buscarPorAluno(mat);
            }
            TccDAO daoTcc = new TccDAO();
            listaTcc = daoTcc.listar();
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao carregar a  tabela: " + ex.getMessage());
        }
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg;
        msg = new FacesMessage("Aluno Selecionado", ((Aluno) event.getObject()).getMatricula().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String listar() {
        return "AlunoBD.xhtml?faces-redirect=true\"";
    }

}

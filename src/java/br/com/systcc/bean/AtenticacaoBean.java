package br.com.systcc.bean;

import br.com.systcc.dao.UsuarioDAO;
import br.com.systcc.domain.Usuario;
import br.com.systcc.util.FacesUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Deyvison Jose de Paula e Maurlio Costa Bastos
 */
@ManagedBean
@SessionScoped //Enquanto usuario estiver logado
public class AtenticacaoBean {

    private Usuario usuarioLogado;

    public Usuario getUsuarioLogado() {
        if (usuarioLogado == null) {
            usuarioLogado = new Usuario();
        }
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String logar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuarioLogado = dao.Logar(usuarioLogado.getLogin(), usuarioLogado.getSenha());
            if (usuarioLogado == null) {
                FacesUtil.addMsgError("Login e/ou senha inválidos");
            } else {
                FacesUtil.addMsgInfo("Usuário autenticado com sucesso");
                return "principal.xhtml";
            }

        } catch (RuntimeException ex) {
            ex.printStackTrace();
            FacesUtil.addMsgError("Erro ao logar no sistema: " + ex.getMessage());
        }
        return "";
    }

}

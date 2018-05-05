package br.com.systcc.converter;

import br.com.systcc.dao.TccDAO;
import br.com.systcc.domain.Tcc;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//https://youtu.be/o87oK_PLnb8?list=PL_GwGUsBlNydMdSOh8nYYRwD4tvPX1EIV&t=466
@FacesConverter("tccConverter")
public class TccConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
        try{
            Long id = Long.parseLong(valor);
            TccDAO dao = new TccDAO();
            Tcc tcc = dao.buscarPorId(id);
            return tcc;
        }catch (RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
        try{
            Tcc tcc = (Tcc) objeto;
            Long id = tcc.getId_tcc();
            return id.toString();
        }catch (RuntimeException ex){
            return null;
        }
    }
    
}

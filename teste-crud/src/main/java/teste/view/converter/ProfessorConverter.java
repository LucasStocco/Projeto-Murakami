package teste.view.converter;  // corresponde à pasta converter

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import teste.model.Curso;
import teste.model.dao.ProfessorDao;
import teste.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Curso.class)
public class ProfessorConverter implements Converter<Object> {

    private ProfessorDao professorDAO;

    public ProfessorConverter() {
        this.professorDAO = CDIServiceLocator.getBean(ProfessorDao.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            return professorDAO.buscarPeloCodigo(Long.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long id = ((Curso) value).getId();
            return (id == null ? null : id.toString());
        }
        return "";
    }
}

package teste.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import teste.model.Curso;
import teste.service.ManterCursoService;

@Getter
@Setter
@Named
@ViewScoped
public class ManterCursoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ManterCursoService manterCursoService;

    private Curso curso = new Curso();
    private List<Curso> cursos = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        this.cursos = manterCursoService.buscarTodos();
        limpar();
    }

    public void salvar() {
        manterCursoService.salvar(curso);
        this.cursos = manterCursoService.buscarTodos();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso salvo com sucesso!", null));
        limpar();
    }

    public void excluir() {
        try {
            manterCursoService.excluir(curso);
            this.cursos = manterCursoService.buscarTodos();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso excluído com sucesso!", null));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um problema ao excluir", null));
        }
    }

    public void limpar() {
        this.curso = new Curso();
    }
}

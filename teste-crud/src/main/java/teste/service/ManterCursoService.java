package teste.service;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import teste.model.Curso;
import teste.model.dao.CursoDao;

@Named
@ApplicationScoped
public class ManterCursoService {

    @Inject
    private CursoDao cursoDao;

    public void salvar(Curso curso) {
        cursoDao.salvar(curso);
    }

    public void excluir(Curso curso) {
        cursoDao.excluir(curso);
    }

    public List<Curso> buscarTodos() {
        return cursoDao.buscarTodos();
    }
}

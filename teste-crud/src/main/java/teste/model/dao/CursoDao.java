package teste.model.dao;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import teste.model.Curso;

public class CursoDao {

    @Inject
    private EntityManager em;

    public void salvar(Curso curso) {
        if (curso.getId() == null) {
            em.persist(curso);
        } else {
            em.merge(curso);
        }
    }

    public void excluir(Curso curso) {
        curso = em.find(Curso.class, curso.getId());
        if (curso != null) {
            em.remove(curso);
        }
    }

    public List<Curso> buscarTodos() {
        TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c", Curso.class);
        return query.getResultList();
    }
}

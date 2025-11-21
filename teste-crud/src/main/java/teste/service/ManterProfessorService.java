package teste.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import teste.model.Curso;
import teste.model.dao.ProfessorDao;

public class ManterProfessorService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject	
	private ProfessorDao professorDao;
	
	public void salvar(Curso professor) {
		professorDao.salvar(professor);
	}
	
	public void excluir(Curso professor) {
		this.professorDao.excluir(professor);
	}

	public List<Curso> buscarTodos() {
		
		return professorDao.buscarTodos();
	}
}

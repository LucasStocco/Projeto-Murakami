package teste.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teste.model.Curso;
import teste.util.jpa.Transactional;

public class ProfessorDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	//Esse é o EntityManager, e é ele quem faz toda a persistência real com o banco de dados.
	private EntityManager manager;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorDao.class);
	
	@Transactional
	//merge() → se o objeto já existe, atualiza; se não, insere.
	//Aqui o EntityManager faz o CRUD de persistência real.
	public Curso salvar(Curso professor) throws PersistenceException {
		
		LOGGER.info("salvar DAO... professor = " + professor);
		
		try {
			return manager.merge(professor);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public void excluir(Curso professor) throws PersistenceException {

		try {
			Curso a = manager.find(Curso.class, professor.getId());
			manager.remove(a);
			manager.flush();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw e;
		} 
	}
	
	public Curso buscarPeloCodigo(Long id) {
		return manager.find(Curso.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Curso> buscarTodos() {
		
		String query="select a from Professor a";
		
		Query q = manager.createQuery(query);
		
		return q.getResultList();
	}	
}

//Bean (ManterProfessorBean) → não há EntityManager, ele só chama o service

//Service (ManterProfessorService) → também não há EntityManager, ele só chama o DAO

//DAO (ProfessorDao) → aqui está o EntityManager, que faz todas as operações reais de persistência

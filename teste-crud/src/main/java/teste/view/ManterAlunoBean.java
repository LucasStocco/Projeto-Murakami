//Ajuda o Java a organizar classes. Aqui a classe pertence ao pacote teste.view.
package teste.view;

import java.io.Serializable;
//coleções para armazenar alunos/professores.
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
//classes do JSF para mostrar mensagens na interface.
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import teste.model.Aluno;
import teste.model.Curso;
import teste.service.ManterAlunoService;
import teste.service.ManterProfessorService;

//Lombok gera automaticamente getters/setters em tempo de compilação.
@Log4j
@Getter
@Setter
@Named

//define o escopo: a bean permanece viva enquanto você estiver na mesma view (ou seja, enquanto o usuário não mudar de página).
@ViewScoped
//Essa classe pode ser transformada em bytes e reconstruida depois 
public class ManterAlunoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ManterAlunoService manterAlunoService;
	@Inject
	private ManterProfessorService manteProfessorService;
	private Aluno aluno = new Aluno();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Curso> professores = new ArrayList<Curso>();

	
	@PostConstruct
	public void inicializar() {
		log.debug("init pesquisa"); 
		this.setAlunos(manterAlunoService.buscarTodos());
		this.setProfessores(manteProfessorService.buscarTodos());
		limpar();
	}
	
	public void salvar() {
		//Registra no log o estado atual do aluno
		log.info(aluno.toString());
		manterAlunoService.salvar(aluno);
		this.setAlunos(manterAlunoService.buscarTodos());

		FacesContext.getCurrentInstance().
        addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
        		"O aluno foi gravado com sucesso!", 
        		aluno.toString()));
		
		limpar();
		log.info("aluno: " + aluno.toString());
	}
	
	public void excluir() {
		try {
			manterAlunoService.excluir(aluno);
			this.alunos = manterAlunoService.buscarTodos();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Aluno " + aluno.getNome() + " excluído com sucesso.", null));
			log.info("aluno excluido = " + aluno.getNome());
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um problema", null));
		}
	}
		
	public void limpar() {

		this.aluno = new Aluno();
	}
	
}

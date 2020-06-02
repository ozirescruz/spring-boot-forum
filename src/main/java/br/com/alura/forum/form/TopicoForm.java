package br.com.alura.forum.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoForm {
	@NotNull
	@NotEmpty
	private String titulo;
	@NotNull
	@NotEmpty
	private String mensagem;
	@NotNull
	@NotEmpty
	private String nomeCurso;

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(getNomeCurso());

		return new Topico(getTitulo(), getMensagem(), curso);
	}
}

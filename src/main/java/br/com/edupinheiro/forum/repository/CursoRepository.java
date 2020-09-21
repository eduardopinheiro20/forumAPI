package br.com.edupinheiro.forum.repository;

import br.com.edupinheiro.forum.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository  extends JpaRepository<Curso, Long> {

    Curso findByNome(String nomeCurso);
}

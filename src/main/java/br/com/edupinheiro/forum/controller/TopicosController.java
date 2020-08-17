package br.com.edupinheiro.forum.controller;

import br.com.edupinheiro.forum.controller.dto.TopicoDto;
import br.com.edupinheiro.forum.modelo.Curso;
import br.com.edupinheiro.forum.modelo.Topico;
import br.com.edupinheiro.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(String name) {

        if(name == null){
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.findByCursoNome(name);
            return TopicoDto.converter(topicos);
        }
    }
}

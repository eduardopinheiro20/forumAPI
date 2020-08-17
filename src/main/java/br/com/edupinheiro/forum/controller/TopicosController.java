package br.com.edupinheiro.forum.controller;

import br.com.edupinheiro.forum.controller.dto.TopicoDto;
import br.com.edupinheiro.forum.modelo.Curso;
import br.com.edupinheiro.forum.modelo.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        Topico topico = new Topico("Dúvida", "Dúvida Spring", new Curso("Spring", "Programação Edu"));

        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }
}
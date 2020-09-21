package br.com.edupinheiro.forum.controller.dto;

import br.com.edupinheiro.forum.modelo.Resposta;
import java.time.LocalDateTime;

/**
 *
 * @author eduardo-pinheiro
 */
class RespostaDto {
    
    private Long id;
    private String mansagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    
    
    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.mansagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getMansagem() {
        return mansagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
    
    
    
    
}

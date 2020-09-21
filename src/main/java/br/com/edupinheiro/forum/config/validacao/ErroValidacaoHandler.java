package br.com.edupinheiro.forum.config.validacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author eduardo-pinheiro
 */

@RestControllerAdvice
public class ErroValidacaoHandler {
    
    @Autowired
    private MessageSource messageSource;
    
    /* 
     *  Sempre que houver um erro, uma exception, de 
     *  algum metodo de qualquer cotroler ele chama automaticamente 
     *  esse interceptador. 
    */
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormularioDto> handle(MethodArgumentNotValidException exception){
        List<ErroFormularioDto> dto = new ArrayList<>();
        List<FieldError> fieldErrors =  exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroFormularioDto erro = new ErroFormularioDto(e.getField(), mensagem);
            dto.add(erro);
        });
        
        return dto;
    }
    
}

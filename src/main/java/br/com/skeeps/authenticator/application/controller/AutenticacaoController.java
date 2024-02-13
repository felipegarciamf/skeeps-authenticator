package br.com.skeeps.authenticator.application.controller;


import br.com.skeeps.authenticator.application.dto.AutenticacaoRequest;
import br.com.skeeps.authenticator.domain.service.IAutenticacaoUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {


    private final IAutenticacaoUsuarioService autenticacaoUsuarioService;

    public AutenticacaoController(IAutenticacaoUsuarioService autenticacaoUsuarioService) {
        this.autenticacaoUsuarioService = autenticacaoUsuarioService;
    }

    @PostMapping
    public ResponseEntity autenticar(@RequestBody AutenticacaoRequest request){
        this.autenticacaoUsuarioService.autenticar(request.getEmail(), request.getSenha());
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

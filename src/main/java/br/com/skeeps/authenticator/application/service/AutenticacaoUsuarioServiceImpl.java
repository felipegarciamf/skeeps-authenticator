package br.com.skeeps.authenticator.application.service;

import br.com.skeeps.authenticator.domain.entity.Usuario;
import br.com.skeeps.authenticator.domain.service.IAutenticacaoUsuarioService;
import br.com.skeeps.authenticator.infra.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
class AutenticacaoUsuarioServiceImpl implements IAutenticacaoUsuarioService {

    private final UsuarioRepository usuarioRepository;

    AutenticacaoUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public void autenticar(String email, String senha) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmailAndBySenha(email, senha);
        if(usuarioOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos");
        }
    }


}

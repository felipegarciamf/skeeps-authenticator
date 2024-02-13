package br.com.skeeps.authenticator.domain.service;

public interface IAutenticacaoUsuarioService {
    void autenticar(String email, String senha);

}

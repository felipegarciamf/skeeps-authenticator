package br.com.skeeps.authenticator.infra.repository;

import br.com.skeeps.authenticator.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByEmailAndSenha(String email, String senha);

}

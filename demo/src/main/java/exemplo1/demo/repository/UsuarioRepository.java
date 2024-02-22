package exemplo1.demo.repository;

import exemplo1.demo.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    @Query("select u from Usuario u where u.login = ?1")
    Usuario findUserByLogin(String login);
}

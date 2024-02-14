package exemplo1.demo.repository;

import exemplo1.demo.model.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
    @Query("select p from Pessoa p where p.nome like %?1% ")
    List<Pessoa> findPessoaByNome(String nome);
}

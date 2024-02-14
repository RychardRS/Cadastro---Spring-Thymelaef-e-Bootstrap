package exemplo1.demo.controllers;

import exemplo1.demo.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import exemplo1.demo.repository.PessoaRepository;

import java.util.Optional;

@Controller
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("**/cadastro/cadastropessoa")
    public ModelAndView inicio() {

        ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
        mv.addObject("pessoas", pessoasIt);
        mv.addObject("pessoaobj", new Pessoa());
        return mv;
    }

    @PostMapping("**/salvarpessoa")
    public ModelAndView salvar(Pessoa pessoa){
        pessoaRepository.save(pessoa);
        ModelAndView mv = new ModelAndView("redirect:/cadastro/listarpessoas");
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
        mv.addObject("pessoas", pessoasIt);
        mv.addObject("pessoaobj", new Pessoa());
        return mv;
    }

    @GetMapping("/cadastro/listarpessoas")
    public ModelAndView pessoas(){
        ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
        mv.addObject("pessoas", pessoasIt);
        mv.addObject("pessoaobj", new Pessoa());
        return mv;
    }

    @GetMapping("/editarpessoa/{idpessoa}")
    public ModelAndView editar(@PathVariable("idpessoa") Long idpessoa){
        Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa);
        ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
        mv.addObject("pessoaobj", pessoa.get());
        return mv;
    }

    @GetMapping("/removerpessoa/{idpessoa}")
    public ModelAndView excluir(@PathVariable("idpessoa") Long idpessoa){
        pessoaRepository.deleteById(idpessoa);
        ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
        mv.addObject("pessoas", pessoaRepository.findAll());
        mv.addObject("pessoaobj", new Pessoa());
        return mv;
    }

    @GetMapping ("**/pesquisarpessoa")
    public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa){
        ModelAndView mv = new ModelAndView(("cadastro/cadastropessoa"));
        mv.addObject("pessoas", pessoaRepository.findPessoaByNome(nomepesquisa));
        mv.addObject("pessoaobj", new Pessoa());
        return mv;
    }
}

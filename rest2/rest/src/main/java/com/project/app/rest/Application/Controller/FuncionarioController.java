package com.project.app.rest.Application.Controller;

import com.project.app.rest.Application.Models.Funcionario;
import com.project.app.rest.Application.Models.FuncionarioDTO;
import com.project.app.rest.Application.repo.DepartamentoRepository;
import com.project.app.rest.Application.repo.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private DepartamentoRepository departamentoRepository;

    Funcionario func;

    public FuncionarioController(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @GetMapping(value = "/func")
    public List<Funcionario> getFunc() {
        return funcionarioRepository.findAll();
    }

    @PostMapping(value = "/func")
    public String saveDepart(@RequestBody @Valid FuncionarioDTO func) {

        var dept = departamentoRepository.findById(func.id_departamento).orElse(null);

        if (dept != null){
            Funcionario funcionario = new Funcionario(func.nome,
                    func.foto,
                    func.rg,
                    dept);

            funcionarioRepository.save(funcionario);
            return "Saved";
        }
        else {
            return "Erro ao salvar";
        }
    }

    @PutMapping("/func/{id}")
    public Funcionario atualizarFunc(@RequestBody @Valid FuncionarioDTO func, @PathVariable int id) {

        var funcs = funcionarioRepository.findById(id);

        if (funcs != null){

            funcs.setNome(func.nome);
            funcs.setRg(func.rg);

            funcionarioRepository.save(funcs);
        }
        return funcs;
    }

    @DeleteMapping("/delete-func/{id}")
    public String deleteFunc(@PathVariable("id") int id) {

        funcionarioRepository.deleteById(id);

        return "Deletou";
    }
}

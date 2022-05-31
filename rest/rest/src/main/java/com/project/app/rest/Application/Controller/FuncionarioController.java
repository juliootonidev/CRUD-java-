package com.project.app.rest.Application.Controller;

import com.project.app.rest.Application.Models.Funcionario;
import com.project.app.rest.Application.Models.FuncionarioDTO;
import com.project.app.rest.Application.repo.DepartamentoRepository;
import com.project.app.rest.Application.repo.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public String saveDepart(@RequestBody FuncionarioDTO func) {

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

//    @PutMapping("{id}")
//    public Produto atualizar(@RequestBody Produto produto, @PathVariable int id) {
//        produto.setCodigo(id);
//        return produtoRepository.save(produto);
//    }

    @DeleteMapping("/delete-func/{id}")
    public String deleteFunc(@PathVariable("id") int id) {

        funcionarioRepository.deleteById(id);

        return "Deletou";
    }
}

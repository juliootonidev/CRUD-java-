package com.project.app.rest.Application.Controller;

import com.project.app.rest.Application.Models.Departamento;
import com.project.app.rest.Application.repo.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping(value = "/")
    public String getPage() {
            return "Hello world!";
    }

    @GetMapping(value = "/depart")
    public List<Departamento> getDepartamentorepo() {
        return departamentoRepository.findAll();
    }

    @PostMapping(value = "/depart")
    public String saveDepart(@RequestBody Departamento departamento) {
        departamentoRepository.save(departamento);
        return "Saved";
    }
    
    @DeleteMapping("/depart/{id}")
    public String deleteDpt(@PathVariable("id") int id) {

        departamentoRepository.deleteById(id);

        return "Deletou";
    }

}

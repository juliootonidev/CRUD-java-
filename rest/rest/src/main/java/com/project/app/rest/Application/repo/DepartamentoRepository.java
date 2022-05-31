package com.project.app.rest.Application.repo;

import com.project.app.rest.Application.Models.Departamento;
import org.apache.commons.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {



}
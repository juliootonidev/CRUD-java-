package com.project.app.rest.Application.repo;

import com.project.app.rest.Application.Models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f FROM Funcionario f WHERE f.Id = ?1")
    Funcionario findById(int Id);

    @Modifying
    @Query("delete from Funcionario f where f.Id=:id")
    void deleteById(@Param("id") int id);
}


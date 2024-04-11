package com.teste.wswork.carregisterAPI.repositories;

import com.teste.wswork.carregisterAPI.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}

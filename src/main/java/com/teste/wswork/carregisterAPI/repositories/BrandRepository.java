package com.teste.wswork.carregisterAPI.repositories;

import com.teste.wswork.carregisterAPI.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}

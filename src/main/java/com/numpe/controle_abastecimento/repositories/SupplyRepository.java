package com.numpe.controle_abastecimento.repositories;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.numpe.controle_abastecimento.entities.Supply;

public interface SupplyRepository extends JpaRepository<Supply, Long> {
    
    Page<Supply> findAll(Pageable pageable);
    
    @Query("FROM Supply s WHERE UPPER(s.plate) like %:plate%")
    Page<Supply> findByPlate(Pageable pageable, String plate);
}

package com.numpe.controle_abastecimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numpe.controle_abastecimento.entities.Supply;

public interface SupplyRepository extends JpaRepository<Supply, Long> {

}

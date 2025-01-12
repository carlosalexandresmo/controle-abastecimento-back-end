package com.numpe.controle_abastecimento.controller;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.numpe.controle_abastecimento.dto.SupplyDTO;
import com.numpe.controle_abastecimento.entities.Supply;
import com.numpe.controle_abastecimento.services.SupplyService;

@RestController
@RequestMapping(value = "/abastecimentos")
public class SupplyController {

    @Autowired
    private SupplyService supplyService;
    
    @GetMapping
    public Page<SupplyDTO> findAll(@RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "5") Integer size,
                                   @RequestParam(value = "placa", required = false) String plate) {
        if (plate != null) {
            return supplyService.findByPlate(page, size, plate);
        } else {
            return supplyService.findAll(page, size);
        }
    }
    
    @PostMapping
    public Supply insert(@RequestBody Supply supply) {

        //adicionar validação do requestBody
        // if (supply.getPlate() == null || supply.getPlate().isEmpty()) {
        //     throw new IllegalArgumentException("Placa não pode ser vazia");
        // }

        // if (supply.getFuel() == null || supply.getFuel().isEmpty()) {
        //     throw new IllegalArgumentException("Combustível não pode ser vazio");
        // }

        // if (supply.getLiters() == null || supply.getLiters() <= 0) {
        //     throw new IllegalArgumentException("Litros deve ser maior que zero");
        // }

        // if (supply.getValue() == null || supply.getValue() <= 0) {
        //     throw new IllegalArgumentException("Valor deve ser maior que zero");
        // }

        // if (supply.getDate() == null) {
        //     throw new IllegalArgumentException("Data não pode ser vazia");
        // }

        // if (supply.getGasStation() == null || supply.getGasStation().isEmpty()) {
        //     throw new IllegalArgumentException("Posto não pode ser vazio");
        // }

    	Supply result = supplyService.insert(supply);
    	return result;
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	supplyService.delete(id);
    }

}

package com.numpe.controle_abastecimento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<SupplyDTO> findAll() {
        List<SupplyDTO> result = supplyService.findAll();
        return result;
    }
    
    @PostMapping
    public Supply insert(@RequestBody Supply supply) {
    	Supply result = supplyService.insert(supply);
    	return result;
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
    	supplyService.delete(id);
    }

}

package com.numpe.controle_abastecimento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.numpe.controle_abastecimento.dto.SupplyDTO;
import com.numpe.controle_abastecimento.entities.Supply;
import com.numpe.controle_abastecimento.repositories.SupplyRepository;

@Service
public class SupplyService {

    @Autowired
    private SupplyRepository supplyRepository;

    @Transactional(readOnly = true)
    public List<SupplyDTO> findAll() {
        List<Supply> result = supplyRepository.findAll();
        return result.stream().map(SupplyDTO::new).toList();
    }
    
    @Transactional
    public Supply insert(Supply supply) {
    	return supplyRepository.save(supply);
    }
    
    public void delete(Long id) {
    	Supply supply = supplyRepository.findById(id).get();
    	supplyRepository.delete(supply);
    }
}

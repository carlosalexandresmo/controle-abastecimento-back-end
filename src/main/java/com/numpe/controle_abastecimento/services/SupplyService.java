package com.numpe.controle_abastecimento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<SupplyDTO> findAll(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Supply> result = supplyRepository.findAll(pageRequest);
        return result.map(x -> new SupplyDTO(x));
    }
    
    @Transactional
    public Supply insert(Supply supply) {
    	return supplyRepository.save(supply);
    }

    @Transactional
    public Page<SupplyDTO> findByPlate(Integer page, Integer size, String plate) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Supply> result = supplyRepository.findByPlate(pageRequest, plate.toUpperCase());
        return result.map(x -> new SupplyDTO(x));
    }
    
    public void delete(Long id) {
    	Supply supply = supplyRepository.findById(id).get();
    	supplyRepository.delete(supply);
    }
}

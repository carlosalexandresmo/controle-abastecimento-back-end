package com.numpe.controle_abastecimento.dto;

import org.springframework.beans.BeanUtils;

import com.numpe.controle_abastecimento.entities.Supply;

public class SupplyDTO {

	private Long id;
	private Double mileage;
	private String plate;
	private String createdAt;
	private Integer total;
	
	public SupplyDTO(Supply supply) {
		BeanUtils.copyProperties(supply, this);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getMileage() {
		return mileage;
	}
	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}

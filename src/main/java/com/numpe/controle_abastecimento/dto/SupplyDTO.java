package com.numpe.controle_abastecimento.dto;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;

import com.numpe.controle_abastecimento.entities.Supply;

public class SupplyDTO {

	private Long id;
	private int mileage;
	private String plate;
	private Timestamp createdAt;
	private double total;
	
	public SupplyDTO(Supply supply) {
		BeanUtils.copyProperties(supply, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

}

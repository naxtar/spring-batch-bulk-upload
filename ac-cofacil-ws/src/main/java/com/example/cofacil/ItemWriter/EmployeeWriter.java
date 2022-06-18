package com.example.cofacil.ItemWriter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.cofacil.dto.EmployeeDTO;

public class EmployeeWriter implements ItemWriter<EmployeeDTO>{

	@Override
	public void write(List<? extends EmployeeDTO> items) throws Exception {
		
		for(EmployeeDTO employeeDTO: items) {
			System.out.println(employeeDTO.toString());
		}
		
	}

}

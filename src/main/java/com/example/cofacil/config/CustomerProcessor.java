package com.example.cofacil.config;

import org.springframework.batch.item.ItemProcessor;

import com.example.cofacil.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer,Customer>{

	@Override
	public Customer process(Customer customer) throws Exception {
	
		return customer;
	}
	
	//Si quisieramos realizar algun filtro::Devuelva los registros correspondientes a un tipo de país
//	@Override
//    public Customer process(Customer customer) throws Exception {
//        if(customer.getCountry().equals("United States")) {
//            return customer;
//        }else{
//            return null;
//        }
//    }

}

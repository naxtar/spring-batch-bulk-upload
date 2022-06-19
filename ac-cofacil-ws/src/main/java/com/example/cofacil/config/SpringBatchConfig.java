package com.example.cofacil.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.cofacil.entity.Customer;
import com.example.cofacil.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

	private JobBuilderFactory jobBuilderFactory;
	
	private StepBuilderFactory stepBuilderFactory;
	
	private CustomerRepository customerRepository;
	
	
	public FlatFileItemReader<Customer> reader(){
		FlatFileItemReader itemReader=new FlatFileItemReader();
		
		//Necesito indicarle donde esta mi archivo .csv
		itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		
		return itemReader;
	}


	private LineMapper<Customer> lineMapper() {
	     DefaultLineMapper<Customer> lineMapper=new DefaultLineMapper<>();
	     
	     DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
	     lineTokenizer.setDelimiter(",");
	     lineTokenizer.setStrict(false);
	     lineTokenizer.setNames("id","firstName","lastName","email","gender","contactNo","country","dob");
		 
	     
	     BeanWrapperFieldSetMapper<Customer> fieldSetMapper=new BeanWrapperFieldSetMapper<>();
	     fieldSetMapper.setTargetType(Customer.class);
	     
	     lineMapper.setLineTokenizer(lineTokenizer);
	     lineMapper.setFieldSetMapper(fieldSetMapper);
	     return lineMapper;
	     
	}
}

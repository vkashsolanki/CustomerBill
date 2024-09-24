package com.customer.bill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.bill.dto.CustomerDto;
import com.customer.bill.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("")
	public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.createCustomer(customerDto);

	}

	@GetMapping("/findAll")
	public List<CustomerDto> getAllCustomers() {
		return customerService.getAllCustomers();

	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getByIdCustomer(@PathVariable("id") int customer_Id) {
		return customerService.getByIdCustomer(customer_Id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{customer_Id}")
	public ResponseEntity<CustomerDto> updateCustomers(@PathVariable("customer_Id") int customer_Id,
			@RequestBody CustomerDto customerDto) {

		return customerService.getByIdCustomer(customer_Id).map(existingCustomers -> {

			customerDto.setCustomer_Id(existingCustomers.getCustomer_Id());

			return ResponseEntity.ok(customerService.createCustomer(customerDto));

		}).orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("/{customer_Id}")
	public ResponseEntity deleteCustomer(@PathVariable("customer_Id") int customer_Id) {
		
	//	customerService.deleteById(customer_Id);
		
		return customerService.getByIdCustomer(customer_Id).map(ecustomer->{
			customerService.deleteById(customer_Id);
				return ResponseEntity.noContent().build();
		})
		.orElse(ResponseEntity.notFound().build());

	
	}

}

/*
 * ////////////////////
 * 
 * @PostMapping("/saveAll") public List<CustomerDto>
 * saveAllCustomer(@RequestBody CustomerDto customerDtos) { return
 * customerService.createAllCustomer((CustomerDto) customerDtos);
 * 
 * }
 */

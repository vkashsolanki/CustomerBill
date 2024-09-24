package com.customer.bill.dto;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	
	
	private int customer_Id;
	private String customer_Name;
	private String customer_Address;
	private String company_Name;
	private int serial_Number; 
	private String description;
	private int quantity;
	private float rate;
	private double amount;
	private int invoice_Number;
	private Date invoice_Date;

}

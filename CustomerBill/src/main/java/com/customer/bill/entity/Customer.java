package com.customer.bill.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER_BILL")
public class Customer {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
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
	@JsonFormat(pattern = "yyyy-MM-dd") 
	private Date invoice_Date;

}

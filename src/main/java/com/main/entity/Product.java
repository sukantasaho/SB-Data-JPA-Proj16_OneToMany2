package com.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

 
@Entity
@Table(name="JPA_PRODUCT_TAB01")
@AllArgsConstructor
//@NoArgsConstructor
@Setter
@Getter
@RequiredArgsConstructor
public class Product 
{
     
	@Id
	@GeneratedValue
	private Integer pid;
	
	@NonNull
	private String pname;
	
	@NonNull
	private Integer qty;
	
	@NonNull
	private Double price;
	
	@ManyToOne(targetEntity = Customer.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id", referencedColumnName = "cid")
	private Customer customerInfo;

	public Product()
	{
		System.out.println("Product::0-param constructor");
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
	}
	
	
	
}

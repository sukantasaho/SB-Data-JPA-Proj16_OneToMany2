package com.main.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_CUSTOMER_TAB01")
@Setter
@Getter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class Customer 
{
	  @Id
	  @GeneratedValue
      private Integer cid;
	  
	  @NonNull
      private String cname;
	  
	  @NonNull
      private String caddr;
	  
	  @NonNull
      private String email;
      
      @OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customerInfo")
      //@JoinColumn(name="cp_fk", referencedColumnName = "cid")
      private List<Product> products;

      
      public Customer()
      {
    	  System.out.println("Customer::0-param constructor");
      }
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddr=" + caddr + ", email=" + email + "]";
	}
      
      
}

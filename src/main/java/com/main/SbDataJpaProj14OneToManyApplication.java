package com.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.entity.Customer;
import com.main.entity.Product;
import com.main.repository.CustomerRepository;
import com.main.service.IOToMAssociationMgntService;
 

@SpringBootApplication
public class SbDataJpaProj14OneToManyApplication
{

	 
	public static void main(String[] args) 
	{
		 ApplicationContext ctx = SpringApplication.run(SbDataJpaProj14OneToManyApplication.class, args);
		  
		IOToMAssociationMgntService service  =  ctx.getBean("cService", IOToMAssociationMgntService.class);
		 //service.saveDataUsingParent();
		 //service.saveDataUsingChild();
		 //service.loadDataUsingParent();
	      service.loadDataUsingChild();
	      
	     ((ConfigurableApplicationContext) ctx).close();
	     
	}

}

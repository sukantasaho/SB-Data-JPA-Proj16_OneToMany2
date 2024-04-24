package com.main.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Customer;
import com.main.entity.Product;
import com.main.repository.CustomerRepository;
import com.main.repository.ProductRepository;

@Service("cService")
public class OToMAssociationMgntServiceImp implements IOToMAssociationMgntService
{

	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Override
	public void saveDataUsingParent() {
		
		Customer c1 = new Customer("Niranjana","Kothar","nr@gmail.com");
		Product p1 = new Product("Sandisk 32gb memory",2,965d);
		Product p2 = new Product("Sandisk 16gb memory",2,457d);
		Product p3 = new Product("USB C-Type Cable",2,189d);
		p1.setCustomerInfo(c1); p2.setCustomerInfo(c1); p3.setCustomerInfo(c1);
		c1.setProducts(List.of(p1, p2, p3));
		
		
		System.out.println("Customer and his associated Products are saved(parent to child)---"+custRepo.save(c1).getCid());
	}

	@Override
	public void saveDataUsingChild()
	{
		Customer c = new Customer("Narayan","Bhadrak","narayan@gmail.com");
		 Product p1 = new Product("HP LAPTOP-1",4,45000D);
		 Product p2 = new Product("HP LAPTOP-2",3,89000D);
		 p1.setCustomerInfo(c);
		 p2.setCustomerInfo(c);
		 
		 List<Product> list = new ArrayList<>();
		 list.add(p1);
		 list.add(p2);
		 c.setProducts(list);
		 
		  prodRepo.save(p1);
		  prodRepo.save(p2);
		  
		 System.out.println("Customer and his associated Products are saved(Child to Parent)");
		
	}

	@Override
	public void loadDataUsingParent()
	{
		//get Parent details
		List<Customer> cList = custRepo.findAll();
		 cList.forEach(cust->{
			 System.out.println("Customer::"+cust);
			  List<Product> childs = cust.getProducts();
			  childs.forEach(p->System.out.println(p));
		 });
		
		 
		
	}

	@Override
	public void loadDataUsingChild() 
	{
		 List<Product> pList =  prodRepo.findAll();
		pList.forEach(p->{
			System.out.println("Child::"+p);
			//getting parent object
			Customer cust = p.getCustomerInfo();
			System.out.println(cust);
			 
		});
	}

	 
 
}

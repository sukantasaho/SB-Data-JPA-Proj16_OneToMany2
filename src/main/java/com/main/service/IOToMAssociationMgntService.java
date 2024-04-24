package com.main.service;

import com.main.entity.Customer;
import com.main.entity.Product;

public interface IOToMAssociationMgntService
{
       public void saveDataUsingParent();
       public void saveDataUsingChild();
       public void loadDataUsingParent();
       public void loadDataUsingChild();
        
       
}

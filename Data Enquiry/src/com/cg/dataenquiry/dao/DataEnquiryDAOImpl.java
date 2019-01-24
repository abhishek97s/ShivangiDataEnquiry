package com.cg.dataenquiry.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.dataenquiry.bean.Customer;

public class DataEnquiryDAOImpl implements DataEnquiryDAO{

	
	Map<Integer, Customer> customers= new HashMap<>();
	public static int CUSTOMER_ID=0;
	@Override
	public Customer save(Customer customer) {
		customer.setCustId(++CUSTOMER_ID);
		customers.put(customer.getCustId(), customer);
		return customer;
	}
	@Override
	public Customer find(int custId) {
		return customers.get(custId);
	}

}

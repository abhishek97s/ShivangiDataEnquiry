package com.cg.dataenquiry.dao;

import com.cg.dataenquiry.bean.Customer;

public interface DataEnquiryDAO {
public Customer save(Customer customer);
public  Customer find(int custId);
}

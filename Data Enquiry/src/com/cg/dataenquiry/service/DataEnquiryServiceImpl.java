package com.cg.dataenquiry.service;

import com.cg.dataenquiry.bean.Customer;
import com.cg.dataenquiry.dao.DataEnquiryDAO;
import com.cg.dataenquiry.dao.DataEnquiryDAOImpl;
import com.cg.dataenquiry.exception.CustomerInvalidDetailsException;
import com.cg.dataenquiry.exception.DetailsNotFoundException;
import com.cg.dataenquiry.exception.InvalidPhoneNumberException;
public class DataEnquiryServiceImpl implements DataEnquiryService{
DataEnquiryDAO dataEnquiryDAO= new DataEnquiryDAOImpl();

@Override
public int acceptDetails(String firstName, String lastName, String domain, String location, String phoneNumber) throws CustomerInvalidDetailsException, InvalidPhoneNumberException {
	if(firstName.equals("")||lastName.equals("")|| domain.equals("")||location.equals(""))throw new CustomerInvalidDetailsException("Enter valid Details.");
	if(phoneNumber.length()!=10)throw new InvalidPhoneNumberException();
	Customer customer=new Customer(firstName, lastName, domain, location, phoneNumber);
	dataEnquiryDAO.save(customer);
	return customer.getCustId();
}

@Override
public Customer getEnquiryDetails(int custId) throws DetailsNotFoundException {
	Customer customer = dataEnquiryDAO.find(custId);
	if(customer == null)throw new DetailsNotFoundException("Details not found");
	return customer;
}
}

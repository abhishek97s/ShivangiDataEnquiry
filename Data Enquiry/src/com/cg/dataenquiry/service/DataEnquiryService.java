package com.cg.dataenquiry.service;

import com.cg.dataenquiry.bean.Customer;
import com.cg.dataenquiry.exception.CustomerInvalidDetailsException;
import com.cg.dataenquiry.exception.DetailsNotFoundException;
import com.cg.dataenquiry.exception.InvalidPhoneNumberException;

public interface DataEnquiryService {
	 int acceptDetails( String firstName, String lastName, String domain, String location, String phoneNumber) throws CustomerInvalidDetailsException, InvalidPhoneNumberException;
	Customer getEnquiryDetails(int custId) throws DetailsNotFoundException;

}

package com.cg.dataenquiry.client;

import java.util.Scanner;

import com.cg.dataenquiry.bean.Customer;
import com.cg.dataenquiry.exception.CustomerInvalidDetailsException;
import com.cg.dataenquiry.exception.DetailsNotFoundException;
import com.cg.dataenquiry.exception.InvalidPhoneNumberException;
import com.cg.dataenquiry.service.DataEnquiryService;
import com.cg.dataenquiry.service.DataEnquiryServiceImpl;

public class MainClass {
	public static void main(String[] args) {
		DataEnquiryService dataEnquiryService= new DataEnquiryServiceImpl();
		Scanner scanner = new Scanner(System.in);
		int choice,custId=0;
		String firstName,lastName,domain,location,phoneNumber;

		do {
			System.out.println("**************Enquiry System***********");
			System.out.println("choose an option");
			System.out.println("1. Enter Enquiry Details");
			System.out.println("2.View Enquiry Details On Id");
			System.out.println("3.Exit");
			choice=scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter First Name");
				firstName=scanner.nextLine();
				System.out.println("Enter Last Name");
				lastName=scanner.nextLine();
				System.out.println("Enter Contact Number");
				phoneNumber=scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter Prefered Domain");
				domain=scanner.nextLine();
				System.out.println("Enter Preferd Location");
				location=scanner.nextLine();

				try {
					custId =dataEnquiryService.acceptDetails(firstName, lastName, domain, location, phoneNumber);
					System.out.println("Thank you"+firstName+" "+lastName+"your Unique id is "+custId+"we will contact you shortly");
				} catch (InvalidPhoneNumberException e) {
					e.printStackTrace();
				}
				catch (CustomerInvalidDetailsException e) {
					e.printStackTrace();
				}
				

				break;
			case 2:
				System.out.println("Enter the enquiry Number");
				custId=scanner.nextInt();
				Customer customer;
				try {
					customer = dataEnquiryService.getEnquiryDetails(custId);
					System.out.println("Detail are"+customer.toString());
				} catch (DetailsNotFoundException e) {
					
					e.printStackTrace();
				}
				
				break;
			case 3:				
				System.out.println("Thanku");
				System.exit(0);
				break;
			default:
				System.out.println("Enter valid choice");
				break;
			}

		}while(choice!=3);
	}
}

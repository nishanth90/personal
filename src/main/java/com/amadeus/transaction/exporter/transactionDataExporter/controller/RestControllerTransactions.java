package com.amadeus.transaction.exporter.transactionDataExporter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTransactions {
	
	@RequestMapping("/transactions")
	public void getTransactions() {
		System.out.println("Hello Transactions!!!");
	}

}

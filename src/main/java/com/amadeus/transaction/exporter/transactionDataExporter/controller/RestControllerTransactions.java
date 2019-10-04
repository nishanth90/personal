package com.amadeus.transaction.exporter.transactionDataExporter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTransactions {
	
	@RequestMapping(value = "/transactions", method= RequestMethod.GET)
	public String getTransactions() {
		return "Hello from Google Cloud Kubernetes!!!";
	}

}

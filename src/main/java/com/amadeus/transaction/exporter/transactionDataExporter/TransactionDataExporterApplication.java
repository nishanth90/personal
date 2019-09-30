package com.amadeus.transaction.exporter.transactionDataExporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TransactionDataExporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionDataExporterApplication.class, args);
		System.out.println("Hello");
	}

}

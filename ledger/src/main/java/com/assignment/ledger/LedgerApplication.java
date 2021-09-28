package com.assignment.ledger;

import com.assignment.ledger.service.CommandReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.assignment.ledger.repository")
public class LedgerApplication {

	private static CommandReaderService CommandReaderService;

	private static Logger LOGGER = LoggerFactory.getLogger(CommandReaderService.class);

	@Autowired
	public LedgerApplication(CommandReaderService CommandReaderService){
		this.CommandReaderService = CommandReaderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(LedgerApplication.class, args);
		if(args.length>=1) {
			String filename = args[0];
			CommandReaderService.run(filename);
		}
		else{
			LOGGER.info("Please provide file name!!!");
		}
	}

}

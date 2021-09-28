package com.assignment.ledger.service;

import com.assignment.ledger.handler.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class CommandReaderService {

    @Autowired
    private CommandHandler commandHandler;

    private Logger LOGGER = LoggerFactory.getLogger(CommandReaderService.class);

    public void run(String filename)  {
        try{
            File file = new File(filename);
            if (file.length() == 0) {
                LOGGER.info("File is empty!!!");
                System.exit(0);
            }
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line=br.readLine();
            while(line!=null)
            {
                commandHandler.getCommand(line);
                line=br.readLine();
            }
            br.close();
        }
        catch(IOException ioException){
            LOGGER.info("Error occurred inside CommandLineService while reading file: " +ioException.getMessage());
        }
    }
}
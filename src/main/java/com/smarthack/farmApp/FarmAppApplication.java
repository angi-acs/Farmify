package com.smarthack.farmApp;

import com.smarthack.farmApp.data.DataProcessing;
import com.smarthack.farmApp.data.ScriptProduct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class FarmAppApplication {

	public static void main(String[] args) throws IOException, URISyntaxException {
		SpringApplication.run(FarmAppApplication.class, args);
		DataProcessing dataProcessing = new DataProcessing();
		dataProcessing.executePredictScript();
		dataProcessing.readPredictScript();
		dataProcessing.executeSeleniumScript();
		dataProcessing.processData();
		Float m = dataProcessing.getFruits().get("Mere").getPrice();



	}

}

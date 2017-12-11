package com.whiteclarke.autoparking;
/**
 * AutoParkingApplication
 * Application class. This is the one Spring is going to call to init the program.  
 * 
 * @author vhblasco
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.whiteclarke.autoparking.beans.AutoParking;

@SpringBootApplication
public class AutoParkingApplication {
	
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AutoParkingApplication.class, args);
		
		AutoParking autoparking = context.getBean(AutoParking.class);
		for (int i = 0; i < args.length; i++) {
			autoparking.calculateNewPosition(args[i]);
		}
	}

}

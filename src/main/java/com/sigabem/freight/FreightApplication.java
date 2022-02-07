package com.sigabem.freight;
import com.sigabem.freight.services.FreightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = "com.sigabem.freight")
@EntityScan(basePackages = "com.sigabem.freight.models")
public class FreightApplication {
    
	@Autowired
    public FreightService freightService() {
		return new FreightService();
	}

	public static void main(String[] args) {
		SpringApplication.run(FreightApplication.class, args);
	}

}

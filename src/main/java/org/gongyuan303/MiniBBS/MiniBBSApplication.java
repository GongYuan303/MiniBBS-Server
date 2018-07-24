package org.gongyuan303.MiniBBS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.gongyuan303.MiniBBS")
public class MiniBBSApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniBBSApplication.class, args);
	}
}

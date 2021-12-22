package com.haud;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.haud.controller.CustomerController;

@SpringBootApplication
public class HaudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaudTaskApplication.class, args);
		
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}

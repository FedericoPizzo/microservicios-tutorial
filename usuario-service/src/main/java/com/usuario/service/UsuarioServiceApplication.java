package com.usuario.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Para comunicar pero con Feing que es de spring cloud
@EnableFeignClients
//https://www.youtube.com/watch?v=icTg6iTqpUk&ab_channel=LaTecnolog%C3%ADaAvanza
@SpringBootApplication
public class UsuarioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioServiceApplication.class, args);
	}

}

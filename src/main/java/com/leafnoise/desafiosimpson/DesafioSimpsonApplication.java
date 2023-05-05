package com.leafnoise.desafiosimpson;

import com.leafnoise.desafiosimpson.entitys.Homero;
import com.leafnoise.desafiosimpson.entitys.PatoBalancin;
import com.leafnoise.desafiosimpson.entitys.SrBurns;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioSimpsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSimpsonApplication.class, args);


		SrBurns burns = new SrBurns(37);
		Homero homero = new Homero(24);
		PatoBalancin patoBalancin = new PatoBalancin(10,3);

		System.out.println("estas en banca rota burns?" + burns.isBancaRota()+"\n");

		System.out.println("Homero esta loco? "+ homero.isLoco());
		System.out.println("Homero esta distraido? "+ homero.isDistraido() +"\n");

		System.out.println("Pato esta loco?" + patoBalancin.isLoco());
		System.out.println("pato esta distraido? " + patoBalancin.isDistraido());

	}

}

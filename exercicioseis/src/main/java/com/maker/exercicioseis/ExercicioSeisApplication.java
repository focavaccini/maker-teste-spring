package com.maker.exercicioseis;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercicioSeisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioSeisApplication.class, args);
		
		String xml = "<student>\r\n" + 
				"	<firstName>John</firstName>\r\n" + 
				"	<id>1</id>\r\n" + 
				"	<lastName>Smith</lastName>\r\n" + 
				"</student>";
		  
		System.out.println(converterToJson(xml));
	}

	private static JSONObject converterToJson(String xml) {
		return XML.toJSONObject(xml);
	}

}

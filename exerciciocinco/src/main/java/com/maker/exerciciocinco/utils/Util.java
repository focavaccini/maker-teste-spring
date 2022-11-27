package com.maker.exerciciocinco.utils;

import lombok.Data;

@Data
public class Util {

	public static <T> T nvl(Object originalInstance, T returnIfNull) {
        if (originalInstance instanceof String) {
            String a = (String) originalInstance;
            if (a.trim().isEmpty()) {
                return returnIfNull;
            }
        }
        return (T) ((originalInstance == null) ? returnIfNull : originalInstance);
    }
	
	public static boolean isNullOrEmpty(String str) {
	    return str == null || str.trim().isEmpty() || str.equalsIgnoreCase("null");
	}
	
	public static boolean isNullOrEmpty(Object str) {
	        return str == null || str.toString().trim().isEmpty();
	}
}

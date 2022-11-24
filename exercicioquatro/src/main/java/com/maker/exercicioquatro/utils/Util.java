package com.maker.exercicioquatro.utils;

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
}

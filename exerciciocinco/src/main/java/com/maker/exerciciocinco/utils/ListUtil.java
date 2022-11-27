package com.maker.exerciciocinco.utils;

import java.util.Collection;

public class ListUtil {

	public static boolean isNullOrEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNullOrEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotNullOrNotEmpty(Collection<?> list) {
        return !isNullOrEmpty(list);
    }
}

package com.maker.exercicioquatro.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class Converter {

	private final ModelMapper mapper = new ModelMapper();
	
    public <S, D> D convert(S source, Class<D> destClass) {
        return this.mapper.map(source, destClass);
    }

    
    @SuppressWarnings("unchecked")
    public <T, D> List<T> convert(List<?> list, Class<D> destClass) {
        List<D> convertList = new ArrayList<>();
        list.forEach( element -> {
            convertList.add(this.mapper.map(element, destClass));
        });
        return (List<T>) convertList;
    }
}

package com.module.library.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApplicationUtil {

	@Autowired
	private ModelMapper modelMapper;

	public static <D, T> List<D> mapAll(final Collection<T> source, Class<D> destClass) {
		return source.stream().map(entity -> map(entity, destClass)).collect(Collectors.toList());
	}

	public static <D, T> D map(T source, Class<D> destClass) {
		return modelMapper.map(source, destClass);
	}

}

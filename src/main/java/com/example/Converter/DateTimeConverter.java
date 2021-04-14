package com.example.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateTimeConverter implements Converter<String, LocalDate> {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	
	@Override
	public LocalDate convert(String value) {
		return LocalDate.parse(value, formatter);
	}

}

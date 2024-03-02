package com.nikil.medical.research.microserviceone.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Define your date format
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please provide the date in yyyy-MM-dd format.", e);
        }
	}
	
	

}

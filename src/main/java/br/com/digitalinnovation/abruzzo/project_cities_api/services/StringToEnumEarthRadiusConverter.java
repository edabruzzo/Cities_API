package br.com.digitalinnovation.abruzzo.project_cities_api.services;

import org.springframework.core.convert.converter.Converter;

public class StringToEnumEarthRadiusConverter implements Converter<String, EarthRadius> {

    @Override
    public EarthRadius convert(String source) {
        try {
            return EarthRadius.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return EarthRadius.KILOMETERS;
        }
    }
}

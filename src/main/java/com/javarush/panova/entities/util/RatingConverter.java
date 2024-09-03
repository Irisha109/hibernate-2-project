package com.javarush.panova.entities.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static java.util.Objects.isNull;
@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String value) {
        Rating[] ratings = Rating.values();
            for (Rating rating: ratings){
                if(rating.getValue().equals(value))
                    return rating;
            }
         return null;
    }
}

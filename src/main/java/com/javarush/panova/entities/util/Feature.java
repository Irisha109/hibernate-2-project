package com.javarush.panova.entities.util;

import static java.util.Objects.isNull;

public enum Feature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");
    private String value;

    Feature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static Feature getFeatureByValue(String value){
        Feature[] features = Feature.values();
        if(!isNull(value)){
            for (Feature feature: features){
                if(feature.getValue().equals(value))
                    return feature;
            }
        } return null;
    }
}

package com.example.Uppgift1RestAPI.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plants")
public class Plant {
    @Id
    private String id;
    private String trivialName;
    private String scientificName;
    private enum Size {
        SMALL, MEDIUM, LARGE
    }
    private String lightRequirement;
    private String waterRequirement;
    private int[] maintainingDifficulty = new int[]{1, 2, 3, 4, 5};
    private String requests;
    private double price;
    private String url;
    private enum Status {
        AVAILABLE, RESERVED, EXCHANGED, SOLD
    }
}

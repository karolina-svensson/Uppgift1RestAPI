package com.example.Uppgift1RestAPI.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plants")
public class Plant {
    @Id
    private String id;
    private String trivialName;
    private String scientificName;
    private String userId;
    private enum Size {
        SMALL, MEDIUM, LARGE
    }
    private String lightRequirement;
    private String waterRequirement;
    private int maintainingDifficulty;
    private String requests;
    private double price;
    private String photo;
    private enum Status {
        AVAILABLE, RESERVED, EXCHANGED, SOLD
    }

    public Plant() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrivialName() {
        return trivialName;
    }

    public void setTrivialName(String trivialName) {
        this.trivialName = trivialName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getLightRequirement() {
        return lightRequirement;
    }

    public void setLightRequirement(String lightRequirement) {
        this.lightRequirement = lightRequirement;
    }

    public String getWaterRequirement() {
        return waterRequirement;
    }

    public void setWaterRequirement(String waterRequirement) {
        this.waterRequirement = waterRequirement;
    }

    public int getMaintainingDifficulty() {
        return maintainingDifficulty;
    }

    public void setMaintainingDifficulty(int maintainingDifficulty) {
        this.maintainingDifficulty = maintainingDifficulty;
    }

    public String getRequests() {
        return requests;
    }

    public void setRequests(String requests) {
        this.requests = requests;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

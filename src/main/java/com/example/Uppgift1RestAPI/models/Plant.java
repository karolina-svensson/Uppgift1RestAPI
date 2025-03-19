package com.example.Uppgift1RestAPI.models;


import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plants")
public class Plant {
    @Id
    private String id;
    @NotNull
    private String trivialName;
    @NotNull
    private String scientificName;

    @DBRef User user;

    @NotNull
    private Size size;
    @NotNull
    private String lightRequirement;
    @NotNull
    private String waterRequirement;

    @NotNull
    @Min(value = 1, message = "Mantaining difficulty can not be less than 1")
    @Max(value = 5, message = "Mantaining difficulty can not be more than 5")
    private int maintainingDifficulty;
    @NotNull
    private String requests;

    // Validering för pris (måste vara mellan 50-1000)
    @PositiveOrZero(message = "Price can not be negative")
    @Positive(message = "Price must be more than 0")
    @Min(50)
    @Max(1000)
    private double price;
    private String photo;
    private  Status status;

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
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Size size() {
        return size;
    }

    public void setSize (Size size) {
        this.size = size;
    }

    public Status status() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;

    }

}

package com.cesi.pizzaapp.model;

import android.media.Image;

import java.util.List;

public class Pizza {
    private String nom;
    private Float prix;
    private List<String> mIngredient;
    private String image;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public List<String> getIngredient() {
        return mIngredient;
    }

    public void setIngredient(List<String> ingredient) {
        mIngredient = ingredient;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Pizza(String nom, Float prix, List<String> ingredient, String image) {
        this.nom = nom;
        this.prix = prix;
        mIngredient = ingredient;
        this.image = image;
    }

    public String getImgURI() {
        return null;
    }
}

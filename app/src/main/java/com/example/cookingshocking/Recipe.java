package com.example.cookingshocking;

public class Recipe {
    public String id;
    public String name;
    public String time;
    public String description;
    public String ingredient;

    public Recipe(String id, String name, String time, String description, String ingredient) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.description = description;
        this.ingredient = ingredient;
    }
}

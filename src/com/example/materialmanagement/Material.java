package com.example.materialmanagement;

public class Material {
    private int id;
    private String name;
    private int quantity;

    private static int idCounter = 0;

    public Material(String name, int quantity) {
        this.id = ++idCounter;
        this.name = name;
        this.quantity = quantity;
    }

    public Material(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
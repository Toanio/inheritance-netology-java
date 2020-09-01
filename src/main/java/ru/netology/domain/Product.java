package ru.netology.domain;


public class Product {
    private int id;
    private String name;
    private int cost;


    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public boolean matches(String search) {
            if (search.equalsIgnoreCase(name)) {
                return true;
            }
            return false;
    }
}

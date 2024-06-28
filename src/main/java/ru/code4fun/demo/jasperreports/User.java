package ru.code4fun.demo.jasperreports;

public class User {
    private String name;
    private String country;

    public User(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}

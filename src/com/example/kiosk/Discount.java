package com.example.kiosk;

public enum Discount {
    NationalMerit(0.9),
    Soldier(0.95),
    Student(0.97),
    Person(1.0);

    private final double discountPrice;

    Discount(double discountPrice){
        this.discountPrice = discountPrice;
    }

    public double getDiscount() {
        return discountPrice;
    }
}

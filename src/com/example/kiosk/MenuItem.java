package com.example.kiosk;

public class MenuItem {

    //속성
    private String name;
    private double price;
    private String info;
    private Menu.Category category;


    //생성자
    public MenuItem(String name, double price, String info,Menu.Category category){
        this.name=name;
        this.price=price;
        this.info=info;
        this.category=category;
    }


    public String getName(){
        return  name;
    }

    public double getPrice(){
        return price;
    }

    public String getInfo(){
        return info;
    }

    public Menu.Category getCategory(){
        return category;
    }


    //기능
    @Override
    public String toString() {
        return (name + " | ₩ " + price + " | " + info);

    }
    }

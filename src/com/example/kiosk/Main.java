package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Map<Menu.Category, Menu> menus = ForMenu.getMenus();


        Kiosk kiosk = new Kiosk(List.of(
                menus.get(Menu.Category.burger),
                menus.get(Menu.Category.side),
                menus.get(Menu.Category.drink)
        ));


        kiosk.start();


    }


}


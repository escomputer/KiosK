package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


            List<MenuItem> menuList = new ArrayList<>();

            menuList.add(new MenuItem("ShackBurger",6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
            menuList.add(new MenuItem("SmokeShack",8.9, "베이컨과 체리 페퍼가 추가된 치즈버거"));
            menuList.add(new MenuItem("Cheesburger",6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
            menuList.add(new MenuItem("Hamburger",5.4, "고기 패티만 들어간 기본 버거"));


            for ( int i=0; i<menuList.size();i++){
                System.out.println((i+1)+". "+menuList.get(i));

            }
            System.out.println("0. 종료");

//


    }
}

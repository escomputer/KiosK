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

        Scanner sc = new Scanner(System.in);


        while(true) {

            for (int i = 0; i < menuList.size(); i++) {
                System.out.println((i + 1) + ". " + menuList.get(i));

            }
            System.out.println("0. 종료");

            System.out.println(" 번호를 선택해주세요. ");
            int idx=sc.nextInt();

            if (idx==0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }
            else {
                System.out.println("=============추가============");
                System.out.println(idx+". "+menuList.get(idx-1));
                System.out.println("============================");
            }

        }





//


    }
}

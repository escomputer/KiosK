package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KiosK {
    List<MenuItem> menuItems = new ArrayList<>();

    public KiosK(List<MenuItem> menuItems){
        this.menuItems=menuItems;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);


        while(true) {

            for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));

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
                System.out.println(idx+". "+menuItems.get(idx-1));
                System.out.println("============================");
            }
    }


}}

package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KiosK {

    //속성
    private List<Menu> menus ; // Menu에서 관리되는 리스트를 활용한다.


    //생성자
    public KiosK(List<Menu> menus){
        this.menus = menus;
    }


    //기능
    public void addMenu(Menu menu){
        menus.add(menu);
    }
    public void start(){
        Scanner sc = new Scanner(System.in);


        while(true) {
            System.out.println("어떤 메뉴를 드시겠습니까?");
            for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());

            }
            System.out.println("0. 종료");

            System.out.println(" 번호를 선택해주세요. ");
            int idx=sc.nextInt();

            if (idx==0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }
            else if (idx>0 && idx<=menus.size()){
                System.out.println("=============추가============");
                System.out.println(idx+". "+menus.get(idx-1));
                System.out.println("============================");
            } else System.out.println("항목에 있는 번호를 입력해주세요.");
    }

        sc.close();
}
}

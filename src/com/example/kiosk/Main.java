package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();
        KiosK kiosk = new KiosK(menus);

//      리스트에 카테고리 추가하기
        menus.add(new Menu(Menu.Category.burger));
        menus.add(new Menu(Menu.Category.side));
        menus.add(new Menu(Menu.Category.drink));


        //메뉴  -버거
        menus.get(0).addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거", Menu.Category.burger));
        menus.get(0).addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", Menu.Category.burger));
        menus.get(0).addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨과 체리 페퍼가 추가된 치즈버거", Menu.Category.burger));
        menus.get(0).addMenuItem(new MenuItem("HamBurger", 5.4, "고기 패티만 들어간 기본 버거", Menu.Category.burger));
        //메뉴 - 사이드
        menus.get(1).addMenuItem(new MenuItem("프라이", 4.9, "바삭하고 담백한 크링클 컷 프라이", Menu.Category.side));
        menus.get(1).addMenuItem(new MenuItem("치즈 프라이", 6.0, "고소하고 진한 치즈 소스를 듬뿍 올린 크링클 컷 프라이", Menu.Category.side));
        menus.get(1).addMenuItem(new MenuItem("핫 도그", 5.1, "참나무 칩으로 훈연한 비프 소시지와 토종효모 포테이토 번을 사용한 핫 도그", Menu.Category.side));


        //메뉴 - 음료
        menus.get(2).addMenuItem(new MenuItem("탄산음료", 2.9, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프, 환타 파인애플", Menu.Category.drink));
        menus.get(2).addMenuItem(new MenuItem("레몬에이드", 4.5, "매장에서 직접 만드는 상큼한 레몬에이드", Menu.Category.drink));
        menus.get(2).addMenuItem(new MenuItem("쉐이크", 6.8, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크(바닐라/초콜릿/스트로베리/블랙 & 화이트/솔티드 카라멜/피넛 버터/커피)", Menu.Category.drink));


        kiosk.start();


    }


}


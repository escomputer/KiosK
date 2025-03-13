package com.example.kiosk;

import java.util.List;
import java.util.Map;

public class ForMenu {
    public static Map<Menu.Category, Menu> getMenus() {
//한번에 보내려고 map 사용

        //버거 추가
        Menu burgerMenu = new Menu(Menu.Category.burger);
        burgerMenu.addMenuItems(List.of(
                new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거", Menu.Category.burger),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", Menu.Category.burger),
                new MenuItem("SmokeShack", 8.9, "베이컨과 체리 페퍼가 추가된 치즈버거", Menu.Category.burger),
                new MenuItem("HamBurger", 5.4, "고기 패티만 들어간 기본 버거", Menu.Category.burger)

        ));

        //사이드 추가
        Menu sideMenu = new Menu(Menu.Category.side);
        sideMenu.addMenuItems(List.of(
                new MenuItem("Fries", 4.9, "바삭하고 담백한 크링클 컷 프라이", Menu.Category.side),
                new MenuItem("Cheese Fries", 6.0, "고소하고 진한 치즈 소스를 듬뿍 올린 크링클 컷 프라이", Menu.Category.side),
                new MenuItem("Hot dog", 5.1, "참나무 칩으로 훈연한 비프 소시지와 토종효모 포테이토 번을 사용한 핫 도그", Menu.Category.side)

        ));


        //음료 추가
        Menu drinkMenu = new Menu(Menu.Category.drink);
        drinkMenu.addMenuItems(List.of(
                new MenuItem("Soft drink", 2.9, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프, 환타 파인애플", Menu.Category.drink),
                new MenuItem("Lemon ade", 4.5, "매장에서 직접 만드는 상큼한 레몬에이드", Menu.Category.drink),
                new MenuItem("Shake", 6.8, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크(바닐라/초콜릿/스트로베리/블랙 & 화이트/솔티드 카라멜/피넛 버터/커피)", Menu.Category.drink)
        ));


        return Map.of(Menu.Category.burger, burgerMenu,
                Menu.Category.side, sideMenu,
                Menu.Category.drink, drinkMenu );

    }
}

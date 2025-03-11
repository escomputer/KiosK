package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    String Category;
    List<MenuItem> menuItems = new ArrayList<>();


    public Menu(String Category){
        this.menuItems= menuItems;
        this.Category = Category;
    } // 카테고리 추가 카테고리에는 카테고리와 메뉴들로 구성되어있음.

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public String getCategory(){
        return Category;
    }

    public List<MenuItem> getMenu(){
        return menuItems;
    }//상세 메뉴 목록

    public String toString(){
        return Category;
    }//카테고리명 문자열로 출력하기 위해서
}

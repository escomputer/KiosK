package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    enum Category{
        burger,side,drink
    }
    private Category category;
    private List<MenuItem> menuItems ;


    public Menu(Category category){
        this.menuItems= new ArrayList<>();
        this.category = category;
    } // 카테고리 추가 카테고리에는 카테고리와 메뉴들로 구성되어있음.

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public Category getCategory(){
        return category;
    }

    public List<MenuItem> getMenu(){
        return menuItems;
    }//상세 메뉴 목록

    public String toString(){
        return category.toString();
    }//카테고리명 문자열로 출력하기 위해서
}

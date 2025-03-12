package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<MenuItem> cartList;

    public Cart(){
        this.cartList = new ArrayList<>();
    }

    public void addCart(MenuItem item){
        cartList.add(item);
        System.out.println(item.getName()+"이 장바구니에 추가되었습니다.");
    }
}

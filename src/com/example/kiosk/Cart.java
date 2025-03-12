package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<MenuItem> selectToCart;

    public Cart(){
        this.selectToCart = new ArrayList<>();
    }

    public void addCart(MenuItem item){
        selectToCart.add(item);
        System.out.println(item.getName()+"이 장바구니에 추가되었습니다.");
    }
}

package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //필드
    private List<MenuItem> cartList;


    //생성자
    public Cart(){
        this.cartList = new ArrayList<>();
    }

    //기능
    public void addCart(MenuItem item){
        cartList.add(item);
        System.out.println(item.getName()+"이 장바구니에 추가되었습니다.");
    }

    public void showCart(){
        if (cartList.isEmpty()){
            System.out.println("장바구니가 비어있습니다.");
            return;
        }
        double total = 0;
        System.out.println("====장바구니====");
        for (int i =0;i<cartList.size();i++){
            MenuItem item = cartList.get(i);
            System.out.println((i+1)+". "+item.getName()+" | ₩ "+item.getPrice()+" | "+item.getInfo());
            total+=item.getPrice();
        }

        System.out.println("============================");
        System.out.println("총 금액 : "+ total);
        System.out.println("============================");
    }
}

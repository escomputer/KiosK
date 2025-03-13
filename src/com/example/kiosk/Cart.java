package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

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


        System.out.println("====장바구니====");
        cartList.forEach(System.out::println);// cartList의 요소인 MenuItem 순회 -> toString 오버라이드해서 양식 거기서 갖다씀.

        double total=cartList.stream()
                        .mapToDouble(MenuItem::getPrice)
                                .sum();

        System.out.println("============================");
        System.out.println("총 금액 : ₩"+ total);

    }

    public boolean isEmpty(){
        return cartList.isEmpty();
    }

    public void clearCart() {
        cartList.clear();
    }

    public double getTotalPrice(Discount discount){
        double total=cartList.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
        double discountPrice = discount.getDiscount();
        return total*discountPrice;
    }

    public boolean removeName(Scanner sc){
        System.out.println("어떤 항목을 삭제하시겠습니까?");
        if (sc.hasNextLine()) sc.nextLine(); //버퍼 비우기용
        String name = sc.nextLine();


        boolean exist = cartList.stream()
                .anyMatch(item->item.getName().equalsIgnoreCase(name));

        if (!exist) {System.out.println("장바구니에 " + name + "이(가) 없습니다. 다시 입력해주세요.");
           return false;

        }
            cartList=cartList.stream()
                    .filter(item->!item.getName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
            System.out.println(name+"을 장바구니에서 제거합니다.");
            return true;


   }
}

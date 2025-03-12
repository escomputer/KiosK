package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class KiosK {

    //속성
    private List<Menu> menus; // Menu에서 관리되는 리스트를 활용한다.
    private Cart cart;

    //생성자
    public KiosK(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart();
    }


    //기능
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("어떤 메뉴를 드시겠습니까?");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategory());

            }
            if(!cart.isEmpty()){
                System.out.println("\n[ ORDER MENU ]");
                System.out.println((menus.size()+1)+". Orders  | 장바구니를 확인 후 주문합니다.");
                System.out.println((menus.size()+2)+". Cancel  | 진행 중인 주문을 취소합니다.");

            }


            System.out.println("0. 종료");

            try {
                System.out.println("번호를 선택해주세요. ");
                int idx = sc.nextInt();

                if (idx == 0) {
                    System.out.println("키오스크를 종료합니다.");

                    break;
                }
                if (idx >= 1 && idx <= menus.size()) {
                    showMenus(menus.get(idx - 1), sc); // 두 조건문에 안걸림 -> 정상 입력 됐을때 처리하는
                } else if(idx==menus.size()+1||idx==menus.size()+2) {
                    if (cart.isEmpty()) throw new IllegalArgumentException();
                    else showOrderMenu(idx,sc);
                    break;
                } else {
                    throw new IllegalArgumentException();
                }





            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine(); //버퍼 비우기 !!
            } catch (IllegalArgumentException e) {
                System.out.println("항목에 있는 번호를 눌러주세요.");
                sc.nextLine();
            }

        }

        sc.close(); // start -> showMenus -> start 할 경우 대비해서 start가 완전히 끝날때 sc.close()
    }

    private void showOrderMenu(int idx, Scanner sc) {
        try{
            if (idx==menus.size()+1) {
                cart.showCart();
                System.out.println("위와 같이 주문 하시겠습니까?");
                System.out.println("1.주문    2.메뉴판으로 돌아가기");
                int orderIdx = sc.nextInt();
                if (orderIdx == 1) {
                    order();
                } else if (orderIdx == 2) {
                } else throw new IllegalArgumentException();
            }
                else {
                cart.clearCart(); //주문 취소했기때문에 장바구니에 담겨있던것도 지운다 !
                start();
            }
        }catch(IllegalArgumentException e){
            System.out.println("항목에 있는 번호를 눌러주세요.");
            sc.nextLine();
        }


    }

    private void order() {
        System.out.println("주문할건지 묻는 함수");
    }

    private void showMenus(Menu menu ,Scanner sc) {



            List<MenuItem> items = menu.getMenu();
            System.out.println("\n====" + menu.getCategory() + "====");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));

            }
            System.out.println("0. 뒤로가기");

            try {
                System.out.println("번호를 선택해주세요. ");

                int idx = sc.nextInt();

                if (idx == 0) {
                    start(); // start()처음으로 돌아감. 상위 단계가 start라서 뒤로가기 효과있음
                }
                if (idx < 0 || idx > items.size()) {
                    throw new IllegalArgumentException();
                }
                MenuItem selectedItem = items.get(idx-1);
                System.out.println("선택한 항목 : " + selectedItem);

                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인       2. 선택 취소(뒤로 가기)");

                int cartidx = sc.nextInt();
                if(cartidx==1) cart.addCart(selectedItem);
                else if (cartidx==2) start(); //다시 처음으로 돌아감
                else throw new IllegalArgumentException();

            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine(); //버퍼 비우기 !!
            } catch (IllegalArgumentException e) {
                System.out.println("항목에 있는 번호를 눌러주세요.");
                sc.nextLine();
            }
        }


    private void showOrderMenus(Scanner sc){
        System.out.println("\n===== [ ORDER MENU ] =====");
        System.out.println("4. Orders  | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel  | 진행중인 주문을 취소합니다.");

    }

}


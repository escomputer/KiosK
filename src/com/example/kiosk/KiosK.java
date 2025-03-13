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



    public void start() {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("어떤 메뉴를 드시겠습니까?");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategory());

            }
            if (!cart.isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println((menus.size() + 1) + ". Orders  | 장바구니를 확인 후 주문합니다.");
                System.out.println((menus.size() + 2) + ". Cancel  | 진행 중인 주문을 취소합니다.");

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
                } else if (idx == menus.size() + 1 || idx == menus.size() + 2) {
                    if (cart.isEmpty()) throw new IllegalArgumentException("장바구니가 비어있어 해당번호는 비활성화 상태입니다.");
                    else showOrderMenu(idx, sc);
                    break;
                } else {
                    throw new IllegalArgumentException("항목에 있는 번호를 눌러주세요.");
                }


            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine(); //버퍼 비우기 !!
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }

        sc.close(); // start -> showMenus -> start 할 경우 대비해서 start가 완전히 끝날때 sc.close()
    }

    private void showOrderMenu(int idx, Scanner sc) {
        try {
            if (idx == menus.size() + 1) {
                cart.showCart();
                System.out.println("위와 같이 주문 하시겠습니까?");
                System.out.println("1.주문    2.메뉴판으로 돌아가기");
                int orderIdx = sc.nextInt();
                if (orderIdx == 1) {
                    Order(sc);


                } else if (orderIdx == 2) {
                    start();
                } else throw new IllegalArgumentException("항목에 있는 번호를 눌러주세요.");
            } else {
                cart.clearCart(); //주문 취소했기때문에 장바구니에 담겨있던것도 지운다 !
                start();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }


    }

    private void Order(Scanner sc){
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10% ");
        System.out.println("2. 군인     :  5%");
        System.out.println("3. 학생     :  3%");
        System.out.println("4. 일반     :  0%");

        int discountIdx = sc.nextInt();
        Discount discount = switch(discountIdx){
            case 1 -> Discount.NationalMerit;
            case 2->Discount.Soldier;
            case 3->Discount.Student;
            case 4->Discount.Person;
            default -> throw new IllegalArgumentException("항목에 있는 번호를 눌러주세요");
        };

        double totalPrice = cart.getTotalPrice(discount);
        System.out.println("주문이 완료되었습니다. 금액은 ₩ " + totalPrice + " 입니다.");





    }


    private void showMenus(Menu menu, Scanner sc) {


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
                throw new IllegalArgumentException("올바른 메뉴를 눌러주세요.\n처음으로 돌아갑니다.1");
            }
            MenuItem selectedItem = items.get(idx - 1);
            System.out.println("선택한 항목 : " + selectedItem);

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인       2. 선택 취소(뒤로 가기)");

            int cartidx = sc.nextInt();
            if (cartidx == 1) cart.addCart(selectedItem);
            else if (cartidx == 2) start(); //다시 처음으로 돌아감
            else throw new IllegalArgumentException("항목에 있는 번호를 눌러주세요.");

        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요.");
            sc.nextLine(); //버퍼 비우기 !!
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }
    }


}


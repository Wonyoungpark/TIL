package ex0213.hw;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ProfileHw prof = new ProfileHw();

    public void printMenu() throws Exception {
        while(true){
            System.out.println("1. 프로필 저장 2. 프로필 불러오기 3. 종료");
            System.out.print("메뉴선택> ");
            String no = sc.nextLine();
            switch (no){
                case "1":
                    this.profInput();
                    break;
                case "2":
                    this.searchFile();
                    break;
                case "3": System.exit(0);
                default:
                    System.out.println("메뉴를 입력하세요");
            }
        }
    }

    public void profInput() throws Exception {
        System.out.print("이름> ");
        String name = sc.nextLine();
        System.out.print("몸무게> ");
        int weight = Integer.parseInt(sc.nextLine());
        System.out.print("비밀번호> ");
        String pwd = sc.nextLine();
        System.out.println("입력 완료");
        new ProfileHw(name, weight, pwd);
    }

    public void searchFile() throws Exception{
        System.out.print("이름> ");
        String name = sc.nextLine();
        new ProfileHw(name);
    }
}

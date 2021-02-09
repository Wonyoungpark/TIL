package org.calculator;

import java.util.*;

public class Calculator {

	public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);
        String con;
		do {
			System.out.println("두 개의 숫자를 입력하세요.");
	        double num1 = Scanner.nextDouble();
	        double num2 = Scanner.nextDouble();
	
	        System.out.println("연산자를 입력하세요.");
	        String operator = Scanner.next();
	
	        if (operator.equals("+")) {
	               System.out.println("결과 : " + num1 + " + " + num2 + " = " + (num1 + num2));
	        } else if (operator.equals("-")) {
	               System.out.println("결과 : " + num1 + " - " + num2 + " = " + (num1 - num2));
	        } else if (operator.equals("*")) {
	               System.out.println("결과 : " + num1 + " * " + num2 + " = " + (num1 * num2));
	        } else if (operator.equals("/")) {
	               System.out.println("결과 : " + num1 + " / " + num2 + " = " + (num1 / num2));
	        } else {
	               System.out.println("잘못 입력하셨습니다. (연산자 : +, -, *, /)");
	        }
	        
	        System.out.print("계산을 계속 하시려면  y 혹은 Y를 입력해 주세요 : ");
            con = Scanner.next();
            if(con.equals("y") || con.equals("Y") ){
                continue;
                }
                else{
                    System.out.println("종료합니다.");
                    break;
                }    
		} while(true);
			
		

    }

}

package ex0206.list;

import java.util.ArrayList;
import java.util.Collections;

//List 상속
public class ListExam01 extends ArrayList<Integer> {
    public ListExam01(){
        super(5);

        System.out.println("요소의 개수 :"+size());

        //추가
        this.add(5);
        this.add(15);
        super.add(2);
        super.add(20);
        super.add(40);
        super.add(20);
        System.out.println("추가 후 요소의 개수 :"+size());

        //list 안 요소 꺼내기 => 언박싱
        for (int i=0;i<size();i++) {
            int n = super.get(i);
            System.out.print(n+" ");
        }

        System.out.println("\nthis = "+this);

        //요소 제거
        super.remove(2);
        super.remove(4);

        for(Integer n:this) System.out.print(n+" ");

        //정렬
        Collections.sort(this);
        System.out.println(this);

        Collections.sort(this,Collections.reverseOrder()); //desc
    }
    public static void main(String[] args) {
        new ListExam01();
    }
}

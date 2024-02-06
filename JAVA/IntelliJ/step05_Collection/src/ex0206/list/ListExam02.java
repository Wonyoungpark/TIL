package ex0206.list;

import java.util.*;

//List 생성
public class ListExam02 {
//    List<Integer> list = new ArrayList<Integer>(5);
//    List<Integer> list = new LinkedList<Integer>();
    List<Integer> list = new Vector<Integer>(5);

    public ListExam02(){

        System.out.println("요소의 개수 :"+list.size());

        //추가
        list.add(5);
        list.add(15);
        list.add(2);
        list.add(20);
        list.add(40);
        list.add(20);
        System.out.println("추가 후 요소의 개수 :"+list.size());

        //list 안 요소 꺼내기 => 언박싱
        for (int i=0;i<list.size();i++) {
            int n = list.get(i);
            System.out.print(n+" ");
        }

        System.out.println("\nthis = "+this);

        //요소 제거
        list.remove(2);
        list.remove(4);

        for(Integer n:list) System.out.print(n+" ");

        //정렬
        Collections.sort(list);
        Collections.sort(list,Collections.reverseOrder()); //desc
        System.out.println(list);
    }
    public static void main(String[] args) {
        new ListExam02();
    }
}

package Programmers.daily.java_study;

class Solution0 {
	public long solution(String numbers) {
        long answer = 0;
        numbers = numbers.replace("zero", "0");
        numbers = numbers.replace("one", "1");
        numbers = numbers.replace("two", "2");
        numbers = numbers.replace("three","3");
        numbers = numbers.replace("four","4");
        numbers = numbers.replace("five", "5");
        numbers = numbers.replace("six","6");
        numbers = numbers.replace("seven","7");
        numbers = numbers.replace("eight","8");
        numbers = numbers.replace("nine","9");
        answer = Long.parseLong(numbers);
        return answer;
    }
}
public class 영어가싫어요 {
	public static void main(String[] args) {
		Solution0 s = new Solution0();
		System.out.println(s.solution("onetwothreefourfivesixseveneightnine"));
		System.out.println(s.solution("onefourzerosixseven"));
	}

}

//참고사이트 : https://yongku.tistory.com/entry/프로그래머스-영어가-싫어요-자바JAVA

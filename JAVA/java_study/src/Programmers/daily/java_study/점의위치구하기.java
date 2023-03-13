package Programmers.daily.java_study;

class Solutio26 {
    public int solution(int[] dot) {
        if (dot[0]>0){
            if (dot[1]>0) return 1;
            else return 4;
        } else {
            if (dot[1]>0) return 2;
            else return 3;
        }
    }
}

public class 점의위치구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

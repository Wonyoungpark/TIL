package Programmers.daily.java_study;

import java.util.Collection;

class Solution10 {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        
        if (db.length==0) return "fail";
        
        for(int i=0;i<db.length;i++){
            if (db[i][0].equals(id_pw[0])){
                if (db[i][1].equals(id_pw[1])) return "login";
                else return "wrong pw";
            } else answer = "fail";
        }
        
        return answer;
    }
}

public class 로그인성공 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

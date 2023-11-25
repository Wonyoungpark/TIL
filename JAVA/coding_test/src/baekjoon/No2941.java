package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		int cnt = 0;
		
		while(0<str.length()) {
			Boolean flag = true;
			for(String a:arr) {
				int len = a.length();
				if(len<=str.length() && str.substring(0,len).equals(a)){
					str = str.substring(len);
					cnt++;
					flag = false;
				}
			}
			if(flag) {
				str = str.substring(1);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

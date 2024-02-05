package ex0205.hw;

public class AgeException extends Exception {
	public static int cnt;
	public AgeException() {
		System.out.println("애들은 가라");
		cnt++;
		}
	public AgeException(String s) {
		super(s);
		cnt++;
	}
}
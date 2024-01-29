package ch07.sec11;

//Director는 일반 클래스
public class Director extends Manager {
	@Override
	public void work() {
		System.out.println("제품을 기획합니다.");
	}
}

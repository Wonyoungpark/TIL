package ch09.sec07.exam03;

public class Button {
	//정적 멤버 인터페이스
	public static interface ClickListener {
		//추상 메소드
		void onClick(); //모든 ClickListener는 onClick()메소드를 사용한다. -> 처리방식은 모두 동일
	}
	
	//필드
	private ClickListener clickListener; // 최종 저장 위치
	
	//메소드
	public void setClickListener(ClickListener clickListener) { //Setter
		this.clickListener = clickListener;
	}
	
	//Button 클릭시 실행 메소드
	public void click() {
		this.clickListener.onClick();
	}
}
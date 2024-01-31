package ch09.sec06.exam02;

public class Button {
	//정적 멤버 인터페이스
	public static interface ClickListener{ //중첩 인터페이스가 static
		//추상메소드
		void onClick();
		}
	
		//field
		private ClickListener clickListener; //필드 타입은 중첩 인터페이스 타입
		
		//method
		// 외부에서 구현객체(ClickListener)를 받아서 Setter생성
		public void setClickListener(ClickListener clickListener) {
			this.clickListener = clickListener; //this.clickListener는 private으로 선언한 필드
		}
		
		//Button 클래스가 실행돼었을 때, click()실행
		public void click() {
			//실제 onClick()이 실행되는 객체는 이 클래스에는 없음
			//이벤트 객체가 실행되면서 onClick()이 실행된다.(다형성)
			this.clickListener.onClick();
	}
}

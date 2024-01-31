package ch09.sec06.exam03;

public class ButtonExample {
	public static void main(String[] args) {
		//OK버튼 객체 생성
		Button btnOk = new Button();
		
		//구현 객체 생성
		//OK버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class OkListener implements Button.ClickListener{
			@Override
			public void onClick() {
				System.out.println("OK버튼을 클릭");
			}
		}
		
		//OK버튼 객체에 ClickListener 구현 객체 할당
		btnOk.setClickListener(new OkListener());
		
		//OK버튼 클릭하기
		btnOk.click();
		
		
		//Cancel 버튼 객체 생성
		Button btnCancel = new Button();
		
		//Cancel 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
		class CancelListener implements Button.ClickListener{
			@Override
			public void onClick() {
				System.out.println("Cancel버튼을 클릭");
			}
		}
		
		//Cancel버튼 객체에 ClickListener 구현 객체에 주입
		btnCancel.setClickListener(new CancelListener()); //.click()이 실행될 때 실제로 실행되는 코드
		
		//Cancel버튼 클릭
		btnCancel.click();
	}
}

package ch09.sec07.exam03;

public class ButtonExample {
	public static void main(String[] args) {
		//OK버튼 객체 생성
		Button btnOk = new Button();
		//Cancel 버튼 객체 생성
		Button btnCancel = new Button();
		
		

		// 버튼이 클릭되었을 때, 처리해야할 리스너 객체를 익명구현 객체를 만들어서, 해당 메서드에 이벤트 처리를 넣어준다.
		btnOk.setClickListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("OK버튼 클릭");
			}
		});
		
		//Cancel버튼 객체에 ClickListener 구현 객체에 주입
		btnCancel.setClickListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("Cancel버튼 클릭");
			}
		});
		
		//OK버튼 클릭하기
		btnOk.click();
		//Cancel버튼 클릭
		btnCancel.click();
	}
}

package ch07.sec03.exam02;

public class SmartPhone extends Phone{

	public SmartPhone(String model, String color) {
//		super(); //부모가 매개변수가 있어서 오류 발생 ->컴파일 할 때 매개변수 없는 super()가 자동으로 실행돼서 오류 발생
		super(model,color);
		
		// 부모에서 이미 생성했기 때문에 또 실행할 필요 없음
//		this.model = model;
//		this.color = color;
		
		System.out.println("SmartPhone(String model, String color(String model, String color)생성자 실행");
	}

}

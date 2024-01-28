package ch07.sec04.exam02;

public class SupersonicAirplane extends Airplane{
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	public int flyMode = NORMAL; //상태 필드 선언
	
	//메소드 재정의
	@Override
	public void fly() {
		if(flyMode==SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		} else super.fly(); //Airplane객체의 fly()메소드 호출
	}
}

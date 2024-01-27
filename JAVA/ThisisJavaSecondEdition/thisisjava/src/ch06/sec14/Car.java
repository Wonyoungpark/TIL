package ch06.sec14;

public class Car {
	//필드 선언 : 외부에서 접근 불가
	private int speed;
	private boolean stop;
	
	//Getter와 Setter
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if (speed<0) {
			this.speed=0;
//			return; //사용할 필요 없음
		}else this.speed=speed;
		this.speed = speed;
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
		if(stop) this.speed=0;
	}
}

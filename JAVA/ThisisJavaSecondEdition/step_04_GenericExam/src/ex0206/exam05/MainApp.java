package ex0206.exam05;

public class MainApp {

	public static void main(String[] args) {
		MainApp ma = new MainApp();
		
		Box<Integer> box1 = ma.boxing(100);
		System.out.println(box1.getT());
		
		Box<String> box2 = ma.boxing("길동");
		System.out.println(box2.getT());
	}

	//제네릭 메소드 추가
	public <T> Box<T> boxing(T t){
		Box<T> box = new Box<T>();
		box.setT(t);
		
		return box;
	}
	
	public <T> Box<T> boxing2(){
		return null;
	}
	
	public <T> void boxing3(T t) {
		
	}
}

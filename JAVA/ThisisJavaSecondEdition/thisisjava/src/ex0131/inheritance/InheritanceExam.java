package ex0131.inheritance;

class Car{
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}

//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성
	//각 클래스에 인수를 받지 않는 생성자
	//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
class EfSonata extends Car{
	public EfSonata() {
		carname="es";
		cost = 1;
	}
}

class Excel extends Car{
	public Excel() {
		carname="ex";
		cost = 2;}
	String color="red";
}

class Canival extends Car{
	public Canival() {
		carname="ca";
		cost = 3;
	}
}

public class InheritanceExam{
	public static void main(String[] args) {
		//Car, EfSonata, Excel, Canival 네개의 객체를 생성
		// 각 클래스에서 Car calss에 있는 printAttributes()메소드를 호출할 수 있다.
		Car car = new Car();
		EfSonata ef = new EfSonata();
		Excel ex = new Excel();
		Canival ca = new Canival();
		
		car.printAttributes();
		ef.printAttributes();
		ex.printAttributes();
		ca.printAttributes();
	}
}


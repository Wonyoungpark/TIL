package ex0131.instanceofex;

class Car{} 
class EfSonata extends Car{}
class Excel extends Car{}
class Canival extends Car{}
class People{}

public class InstanceofExam{
	public static void main(String args []){
		
		Car car = new Car();
		EfSonata ef = new EfSonata();
		Excel ex = new Excel();
		Canival ca = new Canival();
		People p = new People();		
		
		if(car instanceof Car){
			System.out.println("car instanceof Car is true");
		}else{
			System.out.println("car instanceof Car is false");
		}//true

		
		if(car instanceof EfSonata){
			System.out.println("car instanceof EfSonata is true");
		}else{
			System.out.println("car instanceof EfSonata is false");
		}//false
		
		if(ef instanceof Car){ 
			System.out.println("ef instanceof Car is true");
		}else{
			System.out.println("ef instanceof Car is false");
		}//true
		
		if(ex instanceof Car){
			System.out.println("ex instanceof Car is true");
		}else{
			System.out.println("ex instanceof Car is false");
		} //true
		
		if(ca instanceof Car){
			System.out.println("ca instanceof Car is true");
		}else{
			System.out.println("ca instanceof Car is false");
		}//true
		
		/*if(p instanceof Car){instanceof �����ڴ� ��Ӱ����϶� ����Ҽ� �ִ�.
			System.out.println("p instanceof Car is true");
		} */
	}
}	

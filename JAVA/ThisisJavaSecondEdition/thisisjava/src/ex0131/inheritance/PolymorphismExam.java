package ex0131.inheritance;

class CarCenter{
	public void engineer(Car cd){
		System.out.println("cd주소 ="+cd);
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
		if(cd instanceof Excel) { //cd가 Excel타입인지 체크
			//자식부분 접근 위해 ObjectDownCasting 필요
//			System.out.println("ex.color  = "+cd.color);
			Excel e = (Excel) cd;
			System.out.println("ex.color  = "+e.color);
			System.out.println("ex주소  = "+e);
		}
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSonata ef=new EfSonata();
		Canival ca=new Canival();
		Excel ex=new Excel();
		
		Car c= new Car();
		
		cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		
		System.out.println("ex주소  = "+ex);
		System.out.println("ex.color  = "+ex.color);
		
		cc.engineer(ex);//
		
		
	
	}
}

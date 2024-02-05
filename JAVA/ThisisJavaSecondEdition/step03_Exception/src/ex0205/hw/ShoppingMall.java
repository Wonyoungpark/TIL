package ex0205.hw;

public class ShoppingMall {

	public void getAge(int age) throws AgeException {
//		try {
//			if(age<18) throw new AgeException("애들은 가라");
//		} finally {
//			System.out.println("끝");
//		}
		
		if(age<18) {
			AgeException a = new AgeException(age+" 애들은 가라");
			throw a;
		}
		System.out.println(age+" 입장하신걸 환영합니다.");
	}
}

package ex0206.exam02;

public class Exam02Main {

	public static void main(String[] args) {
		//상품 2개 생성
		Product<Tv,String> p1 = new Product<>();
		p1.setKind(new Tv());
		p1.setModel("스마트tv");
		System.out.println(p1.getModel());
		Tv tv = p1.getKind();
		
		System.out.println("-----------");
		Product<Audio,String> p2 = new Product<Audio,String>();
		p2.setKind(new Audio());
		p2.setModel("메트로 Audio");
		System.out.println(p2.getModel());
		Audio au = p2.getKind();
	}

}

package ex0206.exam03;

public class HomeAgency implements Rentable<Home> {

	@Override
	public Home rent() {
		return new Home();
	}

}

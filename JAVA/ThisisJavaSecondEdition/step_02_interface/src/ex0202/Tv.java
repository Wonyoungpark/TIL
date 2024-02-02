package ex0202;

class Tv extends Elec implements ElecFunction{
	private int channel;
	
	public Tv() {}

	public Tv(int channel) {
		super();
		this.channel = channel;
	}
	
	public Tv(String code, int cost, int channel) {
		super(code,cost);
		this.channel=channel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tv [channel=");
		builder.append(channel);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void start() {
		System.out.println(super.getCode()+"제품 TV를 "+channel+"을 본다");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	
}

package ex0202;

class Audio extends Elec implements ElecFunction {
	private int volume;
	
	public Audio() {}
	public Audio(int volume) {
		super();
		this.volume = volume;
	}
	public Audio(String code, int cost, int volume) {
		super(code,cost);
		this.volume=volume;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Audio [volume=");
		builder.append(volume);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public void start() {
		System.out.println(super.getCode()+"의 Audio를 "+volume+"으로 듣는다.");
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

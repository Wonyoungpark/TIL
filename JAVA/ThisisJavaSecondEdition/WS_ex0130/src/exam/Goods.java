package exam;

/**
  상품으로 속성을 관리하는 개체
*/
public class Goods{
	private String code; //상품코드 null
	private String name;//상품이름  null
	private int price;//가격 0 
	private String explain;//설명 null
	
	public Goods() {}
	
	public Goods(String code, String name, int price, String explain) {
		this(code,price,explain);
		this.name=name;
	}
	
	public Goods(String code,int price, String explain) {
		this(code);
		this.price=price;
		this.explain=explain;
	}
	
	public Goods(String code) {
		this.code=code;
	}

	public void setCode(String code) {this.code=code;}
	public void setName(String name) {this.name=name;}
	public void setPrice(int price) {this.price=price;}
	public void setExplain(String explain) {this.explain=explain;}

	public String getCode() {return this.code;}
	public String getName() {return this.name;}
	public int getPrice() {return this.price;}
	public String getExplain() {return this.explain;}
}
package ex0401.dto;

public class ProductDTO {
    private String code = "A01";
    private String name = "새우깡";
    private int qty = 10;
    private int price = 2500;

    public ProductDTO(){
        System.out.println("ProductDTO Constructor call");
    }

    public String getCode() {
        System.out.println("getCode call");
        return code;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }
}

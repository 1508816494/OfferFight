package offer;

public class Product {
    private Integer id;
    private String name;
    private long price;

    Product(int id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getPrice(int id) {
        return price;
    }

}

package offer;

public interface ProductService {
    static Product ProductQueryInfo(Integer id) {
        System.out.println("得到产品信息");
        return new Product(10,"test", 20);
    };
}

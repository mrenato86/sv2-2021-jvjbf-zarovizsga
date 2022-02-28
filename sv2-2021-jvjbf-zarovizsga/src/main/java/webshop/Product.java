package webshop;

public class Product {

    private long id;
    private String productName;
    private long price;
    private long stock;

    public Product(String productName, long price, long stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public Product(long id, String productName, long price, long stock) {
        this(productName, price, stock);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public long getPrice() {
        return price;
    }

    public long getStock() {
        return stock;
    }
}

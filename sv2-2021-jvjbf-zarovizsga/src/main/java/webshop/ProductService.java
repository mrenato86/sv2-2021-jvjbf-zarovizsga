package webshop;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saleProduct(long id, int amount) {
        Product foundProduct = productRepository.findProductById(id);
        if (foundProduct.getStock() < amount) {
            throw new IllegalArgumentException("Not enough product in stock!");
        }
        productRepository.updateProductStock(id, amount);
    }
}

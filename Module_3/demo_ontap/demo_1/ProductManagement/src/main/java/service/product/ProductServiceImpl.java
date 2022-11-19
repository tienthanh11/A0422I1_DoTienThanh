package service.product;

import model.Product;
import repository.product.IProductRepository;
import repository.product.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> selectAllProduct() {
        return productRepository.selectAllProduct();
    }

    @Override
    public boolean insert(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }
}

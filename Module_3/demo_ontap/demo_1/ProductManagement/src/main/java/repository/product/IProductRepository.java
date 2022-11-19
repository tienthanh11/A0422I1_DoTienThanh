package repository.product;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAllProduct();

    boolean insert(Product product);

    Product findById(int id);

    boolean update(Product product);

    boolean delete(int id);

    List<Product> search(String name);
}

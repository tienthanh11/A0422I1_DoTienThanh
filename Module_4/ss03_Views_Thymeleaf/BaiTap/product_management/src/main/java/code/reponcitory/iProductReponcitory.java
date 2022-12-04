package code.reponcitory;

import code.model.Product;

import java.util.List;

public interface iProductReponcitory {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product customer);

    void remove(int id);

    List<Product> search(String name);
}

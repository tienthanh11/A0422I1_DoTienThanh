package code.service.impl;

import code.reponcitory.iProductReponcitory;
import code.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import code.service.iProductService;

import java.util.List;

@Service
public class productServiceImpl implements iProductService {
    @Autowired
    iProductReponcitory productReponcitory;

    @Override
    public List<Product> findAll() {
        return productReponcitory.findAll();
    }

    @Override
    public void save(Product product) {
        productReponcitory.save(product);
    }

    @Override
    public Product findById(int id) {
        return productReponcitory.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productReponcitory.update(id, product);
    }

    @Override
    public void remove(int id) {
        productReponcitory.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        return productReponcitory.search(name);
    }
}

package code.reponcitory.impl;

import code.model.Product;
import org.springframework.stereotype.Repository;
import code.reponcitory.iProductReponcitory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class productReponcitoryImpl implements iProductReponcitory {
    public static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "milk", 3000, "sugar", "Vinamilk"));
        productMap.put(2, new Product(2, "coffee", 4000, "sugar", "Vinamilk"));
        productMap.put(3, new Product(3, "milk tea", 5000, "milk and tea", "Vinamilk"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>(productMap.values());
        List<Product> productListSearch = new ArrayList<>();
        for (Product product: productList){
            if(name.equals(product.getName())){
                productListSearch.add(product);
            }
        }
        return productListSearch;
    }
}

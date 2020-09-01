package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] findAll() {
        Product[] products = repository.getAll();
        Product[] result = new Product[products.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = products[i];
        }
        return result;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.getAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                //System.arraycopy(products, 0, tmp, 0, products.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}

package service.impl;

import model.Product;
import service.IProductService;

import java.util.ArrayList;

public class ProductServiceImpl implements IProductService {
    private static final ArrayList<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1,"a",20,"no"));
        products.add(new Product(2,"b",21,"no"));
        products.add(new Product(3,"c",22,"no"));
        products.add(new Product(4,"d",23,"no"));
        products.add(new Product(5,"e",24,"yes"));
    }

    @Override
    public ArrayList<Product> getAll() {
        return products;
    }

    @Override
    public ArrayList<Product> findByName(String name) {
        ArrayList<Product> products1 = new ArrayList<>();
        for (Product prod: products) {
            if (prod.getName().equalsIgnoreCase(name)){
                products1.add(prod);
            }
        }
        return products1;
    }

    @Override
    public Product findById(int id) {
        for (Product product: products) {
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for (Product prod: products) {
            if (prod.getId() == product.getId()){
                products.set(prod.getId()-1,product);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        Product product = findById(id);
        products.remove(product);
    }

    public boolean checkProduct(int id){
        for (Product product:products) {
            if (product.getId() == id){
                return true;
            }
        }
        return false;
    }
}

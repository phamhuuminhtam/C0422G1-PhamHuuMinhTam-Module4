package com.product_management.repository.impl;

import com.product_management.model.Product;
import com.product_management.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {

        productList.add(new Product(1, "Iphone 13", 1000000, "Hàng xách tay", "Apple"));
        productList.add(new Product(2, "Iphone x", 1500000, "Hàng chính hãng", "Apple"));
        productList.add(new Product(3, "Iphone 11", 1000000, "Hàng xách tay", "Apple"));
        productList.add(new Product(4, "Iphone xs", 1000000, "Hàng xách tay", "Apple"));
        productList.add(new Product(5, "S10", 2000000, "Hàng chính hãng", "Samsung"));
        productList.add(new Product(6, "s22", 3000000, "Hàng chính hãng", "Samsung"));
        productList.add(new Product(7, "s8", 1500000, "Hàng xách tay", "Samsung"));
    }

    @Override
    public List<Product> findAll(String name) {
        List<Product> result = new ArrayList<>();
        if (name == null)
            return productList;
        else {
            for (Product p : productList) {
                if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                    result.add(p);
                }
            }
            return result;
        }
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
//                p.setName(product.getName());
//                p.setPrice(product.getPrice());
//                p.setDescription(product.getDescription());
//                p.setManufacture(product.getManufacture());
                BeanUtils.copyProperties(product, p);
            }
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (Product p : productList) {
            if (p.getId() == id) {
                product = p;
            }
        }
        return product;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(productList.get(i));
            }
        }
    }

//    @Override
//    public List<Product> searchByName(String name) {
//        List<Product> result = new ArrayList<>();
//        for (Product p : productList){
//            if(p.getName().toLowerCase().contains(name.toLowerCase())){
//                result.add(p);
//            }
//        }
//        return result;
//    }

    @Override
    public Product showDetail(int id) {
        for (Product p : productList) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }


}

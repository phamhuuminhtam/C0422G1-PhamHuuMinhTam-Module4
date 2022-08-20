package com.product_management.repository.impl;

import com.product_management.model.Product;
import com.product_management.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ProductRepositoryImpl implements ProductRepository {


    @Override
    public List<Product> findAll(String name) {

        if (name == null) {
            TypedQuery typedQuery = BaseRepository.entityManager.createQuery("select p from Product p", Product.class);
            return typedQuery.getResultList();
        } else {
            TypedQuery typedQuery = BaseRepository.entityManager.createQuery("select p from Product p where p.name like concat('%',:name,'%') ", Product.class);
            typedQuery.setParameter("name", name);
            return typedQuery.getResultList();
        }
    }

    @Override
    public void add(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public void delete(int id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

}
